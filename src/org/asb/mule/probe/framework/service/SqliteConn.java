package org.asb.mule.probe.framework.service;

import java.beans.PropertyVetoException;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import com.alcatelsbell.nms.db.components.service.JPASupportSpringImpl;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.asb.mule.probe.framework.entity.CTP;
import org.asb.mule.probe.framework.entity.ManagedElement;

import com.alcatelsbell.nms.common.SysUtil;
import com.alcatelsbell.nms.db.components.service.JPASupport;
import com.alcatelsbell.nms.db.components.service.JPASupportFactory;
import com.alcatelsbell.nms.db.components.service.JPAUtil;
import com.alcatelsbell.nms.util.log.LogUtil;
import com.alcatelsbell.nms.valueobject.BObject;
import org.asb.mule.probe.framework.util.FileLogger;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;


public class SqliteConn {
    private JPASupport jpaSupport;
    private String dataPath;
    private FileLogger logger = null;

    private static FileLogger defaultLogger = new FileLogger("sqlite.log");
    public SqliteConn(FileLogger logger) {
        this.logger = logger;
    }

    public SqliteConn() {
        this.logger = defaultLogger;
    }



    public void setDataPath(String dataPath) {
        this.dataPath = dataPath;
        try {
            File parentFile = new File(dataPath).getParentFile();
            if (parentFile != null)
                parentFile.mkdirs();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getDataPath() {
        return dataPath;
    }

    public void init(){
        if (jpaSupport != null)  {
            jpaSupport.release();
        }
        setJpaSupport(createSqliteJPASupport(getDataPath()));
    }


    public static JPASupport createSqliteJPASupport(String filePath)   {
        ComboPooledDataSource datasource = new ComboPooledDataSource();
        try {
            datasource.setDriverClass("org.sqlite.JDBC");
        } catch (PropertyVetoException e) {
            LogUtil.error(JPASupportFactory.class, e, e);
        }


        datasource.setJdbcUrl("jdbc:sqlite:"+filePath);
        datasource.setInitialPoolSize(5);
        datasource.setMaxPoolSize(5);
        datasource.setMinPoolSize(5);



        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(datasource);
        factory.setPersistenceUnitName("sqlitePU");
        factory.afterPropertiesSet();
        JPASupportSpringImpl jpaSupportSpring = new JPASupportSpringImpl(factory.getObject());
        jpaSupportSpring.setSingleThreadTx(false);
        jpaSupportSpring.setClearCacheOnEnd(true);

        System.out.println("setClearCacheOnEnd");


        jpaSupportSpring.getProperties().put("Factory",factory);
        jpaSupportSpring.getProperties().put("Datasource",datasource);
        return jpaSupportSpring;


    }


    public void setJpaSupport(JPASupport jpaSupport) {
        this.jpaSupport = jpaSupport;
    }

    public JPASupport getJpaSupport() {
        return jpaSupport;
    }

    private LinkedBlockingQueue<BObject> queue = new LinkedBlockingQueue();
    private  Runnable consumer = null;
    private Thread consumerThread = null;
    private transient boolean idle = true;
    private ReentrantLock lock = new ReentrantLock();
    private Condition insertFinish = null;
    private HashMap<Class,HashSet<String>> clsDnMap = new HashMap<Class, HashSet<String>>();

    private volatile boolean stop = false;
    public void release() {
        clsDnMap.clear();
        stop = true;
        if (consumerThread != null)
            consumerThread.interrupt();
        try {
            Thread.sleep(1000l);
        } catch (InterruptedException e) {

        }
        jpaSupport.release();
    }

    public void insertBObject(BObject object) {
        queue.offer(object);
        idle = false;
        if (consumer == null) {
            consumer = new Runnable() {

                //               private JPASupport support = JPASupportFactory.createSqliteJPASupport(getDataPath());
                @Override
                public void run() {
                    while (true) {
                        try {
                            BObject bo = null;
                            try {
                                bo = queue.take();
                            } catch (InterruptedException e) {
                                if (stop) break;
                            }
                            int consumeSize = queue.size() > 2000 ? 2000 : queue.size();

                            jpaSupport.begin();

                            HashSet<String> dns = clsDnMap.get(bo.getClass());
                            if (dns == null) {
                                dns = new HashSet<String>();
                                clsDnMap.put(bo.getClass(),dns);
                            }


                            if (!dns.contains(bo.getDn())) {
                                JPAUtil.getInstance().createObject(jpaSupport, -1, bo);
                                dns.add(bo.getDn());
                            }

                            for (int i = 0; i < consumeSize; i++) {
                                bo = queue.take();

                                 dns = clsDnMap.get(bo.getClass());
                                if (dns == null) {
                                    dns = new HashSet<String>();
                                    clsDnMap.put(bo.getClass(),dns);
                                }
                                if (!dns.contains(bo.getDn())) {
                                    JPAUtil.getInstance().createObject(jpaSupport, -1, bo);
                                    dns.add(bo.getDn());
                                }


                            }
                            jpaSupport.end();
                            if (queue.isEmpty()) {
                                lock.lock();
                                idle = true;
                                try {
                                    if (insertFinish != null) {
                                        insertFinish.signal();

                                    }
                                } catch (Exception e) {
                                    LogUtil.error(getClass(), e, e);
                                } finally {
                                    lock.unlock();
                                }
                            }

                        } catch (Exception e) {
                            //logger.error(e,e);
                            e.printStackTrace();
                            logger.error(e,e);
                            jpaSupport.release();
                            jpaSupport =  createSqliteJPASupport(getDataPath());
                        }

                        System.out.println("insert queue size = "+queue.size());
                        LogUtil.debug(this,"insert queue size = "+queue.size());
                        //    BObject bo = queue.take();

                    }
                }
            };
            consumerThread = new Thread(consumer);
            consumerThread.setName("CONSUMER-"+dataPath);
            consumerThread.start();
        }
    }

    public void waitingForInsertBObject() {
        lock.lock();
        try {
            if (idle) return ;
            insertFinish = lock.newCondition();
            insertFinish.await();
            insertFinish = null;

        } catch (InterruptedException e) {
            LogUtil.error(getClass(), e, e);
        } finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) {
       SqliteConn conn = new SqliteConn();
        conn.setDataPath("c:\\uywww.db");
        conn.init();

        for (int i = 0; i < 1000000; i++) {
            CTP ctp = new CTP();
            ctp.setDn((i % 3)+"");
            conn.insertBObject(ctp);
            System.out.println(i);
        }
        conn.waitingForInsertBObject();
        conn.release();
        System.out.println("finished");

    }




}
