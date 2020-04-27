package com.alcatelsbell.cdcp.nodefx;

import java.io.File;
import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;
import org.asb.mule.probe.framework.entity.DeviceInfo;

import com.alcatelsbell.cdcp.nodefx.nbi.httpd.HttpServer;
import com.alcatelsbell.nms.util.SysProperty;
import com.alcatelsbell.nms.valueobject.sys.Ems;

/**
 * Author: Ronnie.Chen
 * Date: 13-8-31
 * Time: 下午4:18
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class NodeAdmin implements NodeAdminMBean
{

    private Logger logger = NodeContext.getNodeContext().getLogger();
    private NodeContext nodeContext = null;
    private NodeMBeanServer mBeanServer = null;
    private HashMap<String,EmsAdapter> adapters = new HashMap<String, EmsAdapter>();

    public NodeAdmin() throws Exception {
        String emsAdapter = SysProperty.getString(CDCPConstants.SYSTEM_PROPERTY_EMS_ADAPTERS);
        String[] split = emsAdapter.split(";");
        List<CorbaEmsAdapterTemplate> corbaAdapters = new ArrayList<CorbaEmsAdapterTemplate>();
        for (int i = 0; i < split.length; i++) {
            String adapter = split[i];
            try {
                EmsAdapter emsAdapter1 = (EmsAdapter) Class.forName(adapter).newInstance();
                if (emsAdapter1 instanceof CorbaEmsAdapterTemplate)
                    corbaAdapters.add((CorbaEmsAdapterTemplate)emsAdapter1);
                adapters.put(emsAdapter1.getType(),emsAdapter1);
            } catch (Exception e) {
                logger.error(e,e);
            }
        }

        if(SysProperty.getString("nbi.rest","off").equalsIgnoreCase("on")) {
            int port = SysProperty.getInt("nbi.rest.port", 9090);
            HttpServer httpServer = new HttpServer(corbaAdapters, port);
            httpServer.start();
            logger.info("NBI Restful Server started on :"+port);
        } else {
            logger.info("NBI Restful Server not configured .");
        }

    }

    public EmsAdapter getEmsAdapter(Ems ems) throws NodeException {
        EmsAdapter adapter = adapters.get(ems.getType());
        if (adapter == null) {
            logger.error("Failed to find ems adapter : "+ems.getType());
            throw new NodeException("Failed to find ems adapter : "+ems.getType());
        }
        return adapter;
    }


    public void startAllApps() {
        File xmlDir = new File("xmls");
        File[] files = xmlDir.listFiles();

        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            startApp(file);
        }
    }

    private void startApp(File xmlFile) {

    }

    public void handleLatestEmsList(List<Ems> emsList) {
        List<Ems> nodeEmsList = new ArrayList<Ems>();
        for (Ems ems : emsList) {
            if (ems.getSysNodeDn() != null && ems.getSysNodeDn().equals(NodeContext.getNodeContext().getNodeDName()))
                nodeEmsList.add(ems);
        }
        logger.info("Ems for node is :"+(nodeEmsList == null ? null : nodeEmsList.size()));
        List[] result = EmsCache.getCache().update(nodeEmsList);
        List<Ems> newList = result[0];
        List<Ems> updateList = result[1];
        List<Ems> removeList = result[2];
        if (newList.size() > 0 || updateList.size() > 0 || removeList.size() > 0)
            logger.info("EmsListUpdate:total="+(nodeEmsList == null? null:nodeEmsList.size())
                    +"; newList="+newList.size()
                    +";updateList="+updateList.size()
                    +";removeList="+removeList.size());
        if (newList != null) {
            for (Ems ems : newList) {
                try {
                    EmsAdapter emsAdapter = getEmsAdapter(ems);
                    logger.info(ems.getDn() + emsAdapter);
                    if (emsAdapter != null)
                        emsAdapter.newEms(ems);
                } catch (Exception e) {
                    logger.error(e, e);
                }
            }
        }

        if (updateList != null) {
            for (Ems ems : updateList) {
                try {
                    EmsAdapter emsAdapter = getEmsAdapter(ems);
                    if (emsAdapter != null)
                        emsAdapter.updateEms(ems);
                } catch (Exception e) {
                    logger.error(e, e);
                }
            }
        }

        if (removeList != null) {
            for (Ems ems : removeList) {
                try {
                    EmsAdapter emsAdapter = getEmsAdapter(ems);
                    if (emsAdapter != null)
                        emsAdapter.removeEms(ems);
                } catch (Exception e) {
                    logger.error(e, e);
                }
            }
        }
    }




    @Override
    public void newEms(Ems ems) throws NodeException {
        System.out.println("ems = " + ems.getDn());
         getEmsAdapter(ems).newEms(ems);
        System.out.println("ok");
    }

    @Override
    public void removeEms(Ems ems) throws NodeException {
         getEmsAdapter(ems).removeEms(ems);
    }

    @Override
    public void updateEms(Ems ems) throws NodeException {
         getEmsAdapter(ems).updateEms(ems);
    }

    @Override
    public boolean testEms(Ems ems) throws NodeException {
        ReentrantLock emsLock = getEmsLock(ems.getDn());
        if (!emsLock.tryLock())
            return true;

        else {
            try {
                return getEmsAdapter(ems).testEms(ems);
            } catch (NodeException e) {
                logger.error(e, e);
                throw e;
            } finally {
                emsLock.unlock();
            }
        }

    }

    @Override
    public LifecycleState getState(Ems ems) throws NodeException {
        return getEmsAdapter(ems).getState(ems);
    }




    private EmsConcurrentLock lock = new EmsConcurrentLock
            (SysProperty.getInt(CDCPConstants.SYSTEM_PROPERTY_CONCURRENT_EMS_SIZE,10));


    /**
     * 用来确保Ems始终只有一个任务在执行（包括test，获取网元列表等操作)
     */
    private ConcurrentHashMap<String,ReentrantLock> emsLocks = new ConcurrentHashMap<String, ReentrantLock>();

    private synchronized ReentrantLock getEmsLock(String emsName) {
        if (emsLocks.get(emsName) == null) {
            emsLocks.put(emsName, new ReentrantLock());
        }
        return emsLocks.get(emsName);
    }

    private ConcurrentHashMap<String,EmsJobConsumer> consumers = new ConcurrentHashMap<String, EmsJobConsumer>();

    /**
     *  每个ems维护一个队列，使得同一个ems的job依次进行
     *  CDCPConstants.SYSTEM_PROPERTY_CONCURRENT_EMS_SIZE 用来控制同时执行的emsjob数量，默认为10
     * @param job
     * @throws NodeException
     */
    @Override
    public void executeJob(final EmsJob job) throws NodeException {
        logger.info("executeJob:"+job);
        final EmsAdapter emsAdapter = getEmsAdapter(job.getEms());
        String emsname = job.getEms().getDn();

        if (consumers.get(emsname) == null) {
            synchronized (consumers) {
                if (consumers.get(emsname) == null) {
                    EmsJobConsumer consumer = new EmsJobConsumer(emsname, emsAdapter);
                    consumer.start();

                    if (EmsJob.JOB_TYPE_SYNC_DEVICE.equals(job.getJobType())) {
                        if (consumer.state == EmsJobConsumer.STATE_RUNNING) {
                             throw new NodeException(CDCPConstants.EXCEPTION_MSG_EMS_BUSY);
                        }
                    }
                    consumers.put(emsname, consumer);
                }
            }
        }
        EmsJobConsumer emsJobConsumer = consumers.get(emsname);
        int size = emsJobConsumer.emsJobQueue.size();
        try {
            String s1 = "准备开始采集,";
            String s2 =  "个任务执行中";
            MessageUtil.sendSBIMessage(job.getSerial(), s1
                    +size+(emsJobConsumer.state == EmsJobConsumer.STATE_IDLE ? 0:1)+s2);
        } catch (Exception e) {
            logger.error(e, e);
        }
        logger.info(emsname+" Existed " + emsJobConsumer.emsJobQueue.size()+" tasks");
        try {
            if (job.getSerial() != null) {
                if (emsJobConsumer.runningJob != null && job.getSerial().equals(emsJobConsumer.runningJob.getSerial()))  {
                    logger.info(job.getSerial()+" 任务已经存在,忽略.");
                    return;
                }
                for (EmsJob emsJob : emsJobConsumer.emsJobQueue) {
                    if (job.getSerial().equals(emsJob.getSerial())) {
                        logger.info(job.getSerial()+" 任务已经存在,忽略.");
                        return;
                    }
                }
            }
        } catch (Exception e) {
            logger.error(e, e);
        }
        emsJobConsumer.emsJobQueue.offer(job);
        logger.info(emsname+" 任务下发成功 ");
    }

    @Override
    public Serializable pullObject(String token) throws NodeException {
        Serializable object = ObjectBase.getInstance().getObject(token);
        ObjectBase.getInstance().destoryObject(token);
        return object;
    }

    @Override
    public List<DeviceInfo> listDevices(Ems ems) throws NodeException {
        ReentrantLock emsLock = getEmsLock(ems.getDn());
        if (!emsLock.tryLock()) {
            logger.info("[listDevices]tryLock failed");
            return null;
        }
        else {
            try {
                List<DeviceInfo> list = getEmsAdapter(ems).listDevices(ems);
                logger.info("[listDevices]return list : "+(list == null ? null: list.size()));
                return list;
            } catch (NodeException e) {
                logger.info("[listDevices]error");
                logger.error(e, e);
            } finally {
                emsLock.unlock();
            }
        }
        logger.info("[listDevices]null");
        return null;
    }

    @Override
    public Serializable obtain(Ems ems,URI uri) throws NodeException {
        try {
            EmsAdapter emsAdapter = getEmsAdapter(ems);
            if (emsAdapter != null && emsAdapter instanceof EmsAdapterWithURISupport)
                return ((EmsAdapterWithURISupport) emsAdapter).obtain(ems,uri);
            else {
                throw new NodeException("EmsAdapter:"+emsAdapter+"; not instance of EmsAdapterWithURISupport",new Exception());
            }
        } catch (Exception e) {
            logger.error(e, e);
            throw new NodeException(e.getMessage(),e) ;
        }
    }

    @Override
    public Serializable obtain(Ems ems,String uri) throws NodeException {
        try {
            EmsAdapter emsAdapter = getEmsAdapter(ems);
            if (emsAdapter != null && emsAdapter instanceof EmsAdapterWithURISupport)
                return ((EmsAdapterWithURISupport) emsAdapter).obtain(ems,uri);
            else {
                throw new NodeException("EmsAdapter:"+emsAdapter+"; not instance of EmsAdapterWithURISupport",new Exception());
            }
        } catch (Exception e) {
            logger.error(e, e);
            throw new NodeException(e.getMessage(),e) ;
        }
    }


    class EmsJobConsumer extends Thread{
        public static final int STATE_IDLE = 0;
        public static final int STATE_RUNNING = 1;
        public LinkedBlockingQueue<EmsJob> emsJobQueue = new LinkedBlockingQueue();
        ReentrantLock emsLock = null;
        EmsJobConsumer(String emsname, EmsAdapter emsAdapter) {
            this.emsname = emsname;
            this.emsAdapter = emsAdapter;
            emsLock = getEmsLock(emsname);
        }
        public volatile int state = STATE_IDLE;
        private String emsname = null;
        private EmsAdapter emsAdapter = null;
        private EmsJob runningJob = null;
        public void run() {

            while (true) {
                try {
                    lock.getLock();
                } catch (InterruptedException e) {
                    logger.error(e,e);
                    try {
                        Thread.sleep(100000l);
                        continue;
                    } catch (InterruptedException e1) {

                    }
                }
                EmsJob job = null;
                try {

                    job = emsJobQueue.take();
                    state = STATE_RUNNING;

                    emsLock.lock();
                    MessageUtil.sendSBIMessage(job.getSerial(), "[采集节点]开始采集EMS北向数据");
                    runningJob = job;
                    emsAdapter.executeJob(job);

                } catch (NodeException ee) {
                    try {
                        MessageUtil.sendSBIFailedMessage(ee.getMessage(), job.getSerial());
                    } catch (Exception e1) {
                        logger.error(e1, e1);
                    }
                } catch (Exception e) {
                    try {
                        MessageUtil.sendSBIFailedMessage("UnkownSBIError:"+e.getMessage(), job.getSerial());
                    } catch (Exception e1) {
                        logger.error(e1, e1);
                    }
                    logger.error(e,e);
                } finally {
                    try {
                        lock.releaseLock();
                    } catch (Exception e) {
                        logger.error(e, e);
                    }
                    try {
                        runningJob = null;
                        emsLock.unlock();
                        state = STATE_IDLE;
                    } catch (Exception e) {
                        logger.error(e, e);
                    }
                }
            }
        }
    }

}
