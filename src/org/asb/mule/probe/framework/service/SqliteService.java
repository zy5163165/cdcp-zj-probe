package org.asb.mule.probe.framework.service;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import com.alcatelsbell.nms.util.SysProperty;
import org.asb.mule.probe.framework.entity.ManagedElement;

import com.alcatelsbell.nms.common.SysUtil;
import com.alcatelsbell.nms.db.components.service.JPASupport;
import com.alcatelsbell.nms.db.components.service.JPASupportFactory;
import com.alcatelsbell.nms.db.components.service.JPAUtil;
import com.alcatelsbell.nms.util.log.LogUtil;
import com.alcatelsbell.nms.valueobject.BObject;


public class SqliteService {
	private JPASupport jpaSupport;
	private String dataPath;
	private static SqliteService instance;
    //private Logger logger  = ProbeLog.getInstance().getDataLog();
	
	
	public static SqliteService getInstance() {
        try {
            throw new Exception("SqliteService !!!!!!!!");
        } catch (Exception e) {
            e.printStackTrace();
            if (true)
            return null;
        }
        if (null == instance) {
			instance = new SqliteService();
		//	instance.init();
		}
		return instance;
	}

	public void setDataPath(String dataPath) {
		this.dataPath = dataPath;
	}

	public String getDataPath() {
		return dataPath;
	}
    
	public void init(){
        if (jpaSupport != null)  {
            jpaSupport.release();
        }
		setJpaSupport(JPASupportFactory.createSqliteJPASupport(getDataPath()));
	}

	public void setJpaSupport(JPASupport jpaSupport) {
		this.jpaSupport = jpaSupport;
	}

	public JPASupport getJpaSupport() {
		return jpaSupport;
	}

    private LinkedBlockingQueue<BObject> queue = new LinkedBlockingQueue();
    private  Runnable consumer = null;
    private transient boolean idle = true;
    private ReentrantLock lock = new ReentrantLock();
    private Condition insertFinish = null;
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
                            BObject bo = queue.take();
                            int consumeSize = queue.size() > 2000 ? 2000 : queue.size();

                            jpaSupport.begin();
                            JPAUtil.getInstance().createObject(jpaSupport,-1,bo);
                            for (int i = 0; i < consumeSize; i++) {
                                bo = queue.take();
                                JPAUtil.getInstance().createObject(jpaSupport,-1,bo);

                            }
                            jpaSupport.end();
                            if (queue.isEmpty()) {
                                idle = true;
                                if (insertFinish != null) {
                                    lock.lock();
                                    try {
                                        insertFinish.signal();
                                    } catch (Exception e) {
                                        LogUtil.error(getClass(), e, e);
                                    } finally {
                                        lock.unlock();
                                    }
                                }
                            }

                        } catch (Exception e) {
                            //logger.error(e,e);
                        	e.printStackTrace();
                            jpaSupport.release();
                            jpaSupport = JPASupportFactory.createSqliteJPASupport(getDataPath());
                        }

                        System.out.println("insert queue size = "+queue.size());
                        LogUtil.debug(this,"insert queue size = "+queue.size());
                        //    BObject bo = queue.take();

                    }
                }
            };
            new Thread(consumer).start();
        }
    }

    public void waitingForInsertBObject() {
         if (idle) return ;
        insertFinish = lock.newCondition();
        lock.lock();
        try {
            insertFinish.await();
            insertFinish = null;
        } catch (InterruptedException e) {
            LogUtil.error(getClass(), e, e);
        } finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) {

        SqliteService.getInstance().setDataPath("mydata.db");
        SqliteService.getInstance().init();
        for (int i = 0; i < 100000; i++) {
            ManagedElement me = new ManagedElement();
            me.setDn(SysUtil.nextDN());
            SqliteService.getInstance().insertBObject(me);
        }
        SqliteService.getInstance().waitingForInsertBObject();
        System.out.println("finish");
    }

    public static void main2(String[] args) throws Exception {

        SqliteService.getInstance().setDataPath("mydata.db");
        SqliteService.getInstance().init();
        JPASupport jpaSupport1 = SqliteService.getInstance().getJpaSupport();
        jpaSupport1.begin();
        for (int i = 0; i < 100000; i++) {
            ManagedElement me = new ManagedElement();
            me.setDn(SysUtil.nextDN());
            JPAUtil.getInstance().createObject(jpaSupport1,-1,me);

        }
        jpaSupport1.end();

    }


}
