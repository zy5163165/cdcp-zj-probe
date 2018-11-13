package com.alcatelsbell.cdcp.nodefx;



/**
 * Author: Ronnie.Chen
 * Date: 14-8-19
 * Time: 下午3:30
 *  支持多EMS节点
 * rongrong.chen@alcatel-sbell.com.cn
 */



import java.io.File;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReentrantLock;


import com.alcatelsbell.nms.util.SysProperty;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.asb.mule.probe.framework.entity.DeviceInfo;
import org.asb.mule.probe.framework.entity.ManagedElement;


import com.alcatelsbell.nms.valueobject.sys.Ems;
import org.asb.mule.probe.framework.service.CorbaSbiService;
import org.asb.mule.probe.framework.service.NbiService;
import org.asb.mule.probe.framework.service.NbiServiceExecutor;

import javax.management.*;

/**
 * Author: Ronnie.Chen
 * Date: 13-9-10
 * Time: 下午8:59
 * rongrong.chen@alcatel-sbell.com.cn
 */
public abstract class CorbaEmsAdapterTemplate implements EmsAdapterWithURISupport,CorbaEmsAdapterTemplateMBean {
    protected Logger logger = NodeContext.getNodeContext().getLogger();
    private boolean kac = SysProperty.getString("cdcp.ems.keepaliveconnection","true").equalsIgnoreCase("true");
    private KeepAliveConnectionsManager keepAliveConnectionsManager = new KeepAliveConnectionsManager();
    private CorbaEmsDynamicMBean corbaEmsDynamicMBean = null;
    private Hashtable<String,Ems> emsTable = new Hashtable<String, Ems>();

    public  KeepAliveConnectionsManager getConnectionManager() {
        return keepAliveConnectionsManager;
    }

    public Hashtable<String,Ems> getEmsTable() {
        return emsTable;
    }

    public CorbaEmsAdapterTemplate() {

        try {
            corbaEmsDynamicMBean = new CorbaEmsDynamicMBean(this);
            ObjectName on2 = new ObjectName(CDCPConstants.NODE_JMS_DOMAIN +":name=ConnectionManager");
            NodeContext.getNodeContext().getmBeanServer().registerMBean(corbaEmsDynamicMBean, on2);

            ObjectName on = new ObjectName(CDCPConstants.NODE_JMS_DOMAIN +":name="+this.getClass().getSimpleName());
            NodeContext.getNodeContext().getmBeanServer().registerMBean(this, on);

        } catch (Exception e) {
            logger.error(e, e);
        }
    }

    @Override
    public void newEms(final Ems ems) throws NodeException {
        synchronized (this) {
            CorbaEms corbaEms = new CorbaEms(ems);
            if (emsTable.containsKey(ems.getDn())) return;
            emsTable.put(ems.getDn(), ems);
            if (kac) {
                Runnable runnable = new Runnable() {
                    public void run() {
                        initEmsConnection(ems);
                    }
                };
                new Thread(runnable).start();

            }
            try {
                Thread.sleep(5000l);
            } catch (InterruptedException e) {

            }

            try {
                ObjectName on2 = new ObjectName(CDCPConstants.NODE_JMS_DOMAIN +":name=Connection_"+ems.getDn());
                if (!NodeContext.getNodeContext().getmBeanServer().isRegistered(on2)) {
                    KeepAliveConnectionDynamicMBean mBean = new KeepAliveConnectionDynamicMBean(this, ems.getDn());
                    NodeContext.getNodeContext().getmBeanServer().registerMBean(mBean, on2);
                }
            } catch (Exception e) {
                logger.error(e, e);
            }
        }


    }

    private void initEmsConnection(final Ems ems) {
               if (keepAliveConnectionsManager.containsConnection(ems.getDn())) {
                   log("connection : "+ems.getDn()+" existed");
                   return;
               }

        try {
            connectEms(ems);
        } catch (NodeException e) {
            logger.error(e, e);
        }

    }

    private void log(String log) {
       logger.info(log);
        System.out.println(log);
    }

    public class CorbaKeepAliveConnection extends KeepAliveConnection {
        private NbiService nbiService = null;

        public NbiService getNbiService() {
            return nbiService;
        }

        public void setNbiService(NbiService nbiService) {
            this.nbiService = nbiService;
        }

        public CorbaKeepAliveConnection(String key, NbiService nbiService) {
            super(key);
            this.nbiService = nbiService;
        }

        @Override
        public boolean checkConnection() {
            return nbiService.getConnectState();
        }

        @Override
        public boolean heartbeat() {
            try {
                boolean b = nbiService.ping();
                if (b)
                    EmsStateManager.getInstance().emsOk(nbiService.getEmsName(),"PING SUCCESS");
                else
                    EmsStateManager.getInstance().emsError(nbiService.getEmsName(),null,"PING FAILED");
                return b;
            } catch (Exception e) {
                EmsStateManager.getInstance().emsError(nbiService.getEmsName(),e,"PING EXCEPTION");
                logger.error(e, e);
                return false;
            }

        }



        @Override
        public boolean reconnect() {
            try {
                nbiService.disconnect();
            } catch (Exception e) {
                logger.error(e, e);
            }
            try {
                Thread.sleep(150000l);
            } catch (InterruptedException e) {
                logger.error(e, e);
            }
            return connect();
//           return false;

        }

        @Override
        public boolean disconnect() {
            try {
                nbiService.disconnect();
            } catch (Exception e) {
                logger.error(e, e);
            }
            return true;
        }

        @Override
        public boolean connect() {
            boolean b =  nbiService.connect();
            if (b) {
                EmsStateManager.getInstance().emsOk(nbiService.getEmsName(), "connect SUCCESS");
                HashMap data = new HashMap();
                data.put("CONNECT","SUCCESS");
                SbiEventManager.getInstance().offer(new SBIEvent
                        (nbiService.getEmsName(),null,"event",SBIEvent.SOURCE_TYPE_EMS,data));

            }
            else {
                EmsStateManager.getInstance().emsError(nbiService.getEmsName(), null, "connect FAILED");
              //  HashMap map = new HashMap();
                HashMap data = new HashMap();
             //   map.put("event",data);
                data.put("event_type","ems_disconnect");
                data.put("ems",nbiService.getEmsName());

                SbiEventManager.getInstance().offer(new SBIEvent
                        (nbiService.getEmsName(),null,"event",SBIEvent.SOURCE_TYPE_EMS,data));
            }
            return b;
        }


    }



    @Override
    public void removeEms(Ems ems) throws NodeException {
        KeepAliveConnection connection = keepAliveConnectionsManager.getConnection(ems.getDn());
        if (connection != null) {
            connection.disconnect();
            keepAliveConnectionsManager.removeConnection(ems.getDn());
        }
        emsTable.remove(ems.getDn());

        logger.info("EMS : "+ems.getDn()+" removed !");
    }

    @Override
    public void updateEms(Ems ems) throws NodeException {
        removeEms(ems);
        try {
            Thread.sleep(10000l);
        } catch (InterruptedException e) {
            logger.error(e, e);
        }
        newEms(ems);
    }



    private Hashtable<String,ReentrantLock> emsLock = new Hashtable<String, ReentrantLock>();

    private synchronized ReentrantLock getLock(String emsDn) {
        ReentrantLock lock = emsLock.get(emsDn);
        if (lock == null) {
            lock = new ReentrantLock();
            emsLock.put(emsDn,lock);
        }
        return lock;
    }

    public void delayUnLock(final ReentrantLock lock) {
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(60000l);
                } catch (InterruptedException e) {

                }
                lock.unlock();
            }
        };
        new Thread(runnable).start();
    }


    @Override
    public boolean testEms(Ems ems) throws NodeException {
        Object result = execute(ems, new EmsExecutable() {
            @Override
            public Object execute(NbiService u2000Service) {
            //    return u2000Service.getCorbaService().isConnectState();
                return doTestEms(u2000Service);

            }
        });
        return result == null ? false : (Boolean)result;

        // return false;
    }

    public abstract Object doTestEms(NbiService nbiService);

    @Override
    public LifecycleState getState(Ems ems) throws NodeException {
        CorbaEms corbaEms = new CorbaEms(ems);
        return null;
    }

//    private static CorbaService corbaService = null;
//    private static U2000Service nbiservice = null;



    private long bootTime = System.currentTimeMillis();

    public String readEmsJobList() {
        StringBuffer sb = new StringBuffer();
        for (EmsJob o : emsjobList) {
            sb.append(o.getDataMap().get("RECEIVE_TIME")+" ").append(o.getSerial()).append(" \r \n");
        }
        return sb.toString();
    }
    public String readDeviceJobList() {
        StringBuffer sb = new StringBuffer();
        for (EmsJob o : devicejobList) {
            sb.append(o.getDataMap().get("RECEIVE_TIME")+" ").append(o.getSerial()).append(" \r \n");
        }
        return sb.toString();
    }

    public LinkedList<EmsJob> emsjobList = new LinkedList();
    public LinkedList<EmsJob> devicejobList = new LinkedList();
    @Override
    public void executeJob(EmsJob emsJob) throws NodeException {

//        if (System.currentTimeMillis() -  bootTime < 60000) {
//            try {
//
//                long sleep = 60000 - (System.currentTimeMillis() - bootTime);
//                logger.info("sleeping "+sleep+" ms");
//                Thread.sleep(sleep);
//            } catch (InterruptedException e) {
//
//            }
//        }
        if (EmsJob.JOB_TYPE_SYNC_DEVICE.equals(emsJob.getJobType())) {
            if (devicejobList.size() == 100) devicejobList.removeFirst();
            emsJob.getDataMap().put("RECEIVE_TIME",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            devicejobList.addLast(emsJob);

            String devicedn = (String) emsJob.getDataMap().get(CDCPConstants.EMSJOB_DATA_KEY_DEVICE_DN);
            String synType = (String) emsJob.getDataMap().get(CDCPConstants.EMSJOB_DATA_KEY_SYNC_TYPE);
            if (synType.equals(CDCPConstants.EMSJOB_DATA_VALUE_SYNC_TYPE_MAN)) {
                syncDevice(emsJob.getEms(), emsJob.getSerial(), devicedn);
            } else if (synType.equals(CDCPConstants.EMSJOB_DATA_VALUE_SYNC_TYPE_AUTO)) {
                System.err.println("EMSJOB_DATA_VALUE_SYNC_TYPE_AUTO not implemented.");
            }
        } else {
            if (emsjobList.size() == 100) emsjobList.removeFirst();
            emsJob.getDataMap().put("RECEIVE_TIME",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            emsjobList.addLast(emsJob);
            syncEMS(emsJob.getEms(), emsJob.getSerial());
        }
    }
    protected  String currentDateString() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
    public Hashtable<String,String> emsCurrSyncInfo = new Hashtable<String, String>();
    public Hashtable<String,String> emsLastSyncInfo = new Hashtable<String, String>();
    private void syncEMS(Ems _ems, String serial) {
        final String _serial = serial;
        final Ems ems = _ems;
        execute(ems,new EmsExecutable() {
            @Override
            public Object execute(NbiService u2000Service) {
                logger.info("start syn ems:"+ems.getDn());
                emsCurrSyncInfo.put(ems.getDn(),"RUNNING,START:"+currentDateString());
                long t1 = System.currentTimeMillis();
                Object o = doSyncEms(u2000Service,ems,_serial);
                long t = System.currentTimeMillis() - t1;
                float hour = (float)(t / 100000)/36f;
                emsCurrSyncInfo.put(ems.getDn(),"FREE");
                emsLastSyncInfo.put(ems.getDn(),"LAST FINISH :"+currentDateString()+" SPEND "+hour+"HOUR");
                return o;
//                if (ems.getTag1() == null) ems.setTag1("PTN");
//                if (ems.getTag1().equals("SDH") || ems.getTag1().equals("OTN") || ems.getTag1().equals("WDM")) {
//                    DayMigrationJob4SDH job = new DayMigrationJob4SDH();
//
//                    job.setService(u2000Service);
//                    job.setSerial(_serial);
//                    job.execute();
//                }
//                else {
//                    DayMigrationJob job = new DayMigrationJob();
//                    job.setService(u2000Service);
//                    job.setSerial(_serial);
//                    job.execute();
//                }
//
//                return null;
            }
        });


    }

    public abstract Object doSyncEms (NbiService nbiService,Ems _ems, String serial);
    public abstract Object doSyncDevice (NbiService nbiService,String _serial, String devicedn);

    public void disconnectEms(String emsDn) throws NodeException {
        try {
            keepAliveConnectionsManager.getConnection(emsDn).disconnect();
        } catch (Exception e) {
            logger.error(e, e);
        }
        keepAliveConnectionsManager.removeConnection(emsDn);
    }
    public boolean connectEms(Ems ems) throws NodeException {
        try {
            Thread.currentThread().getContextClassLoader();
            NbiService nbiService = initCorbaService(ems);
            CorbaKeepAliveConnection corbaKeepAliveConnection = new CorbaKeepAliveConnection(ems.getDn(), nbiService);


            while (!corbaKeepAliveConnection.checkConnection()) {
                EmsStateManager.getInstance().emsError(ems.getDn(),null,"connection failed");
                log ("EMS:"+ems.getDn()+" connection failed  ! try to reconnect in 300 seconds");
                            Thread.sleep(5 * 60 * 1000l);

                corbaKeepAliveConnection.reconnect();
              //  return false;
            }

            log("EMS:"+ems.getDn()+" connected !");
            EmsStateManager.getInstance().emsOk(ems.getDn(),"connectEms");
            keepAliveConnectionsManager.addConnection(corbaKeepAliveConnection);




            return true;
        } catch (Exception e) {
            logger.error(e, e);
        } finally {

        }
        return false;

    }
    private void syncDevice(Ems ems, String serial, String devicedn) throws NodeException {
        final String _serial = serial;
        final String _devicedn = devicedn;
        execute(ems,new EmsExecutable() {
            @Override
            public Object execute(NbiService u2000Service) {
//                DeviceJob job = new DeviceJob(_devicedn);
//                job.setService(u2000Service);
//                job.setSerial(_serial);
//                job.execute();
                return doSyncDevice(u2000Service,_serial,_devicedn);
            }
        });



    }

    @Override
    public List<DeviceInfo> listDevices(Ems ems) throws NodeException {
        return (List<DeviceInfo>) executeImmediate(ems, new EmsExecutable() {
            @Override
            public Object execute(NbiService u2000Service) {
                List<ManagedElement> nes = u2000Service.retrieveAllManagedElements();
                List<DeviceInfo> deviceInfos = new ArrayList<DeviceInfo>();
                for (ManagedElement ne : nes) {
                    DeviceInfo deviceInfo = new DeviceInfo();
                    deviceInfo.setDn(ne.getDn());
                    deviceInfo.setDeviceDn(ne.getDn());
                    deviceInfo.setDeviceName(ne.getNativeEMSName());
                    deviceInfo.setProductNme(ne.getProductName());
                    deviceInfo.setCreateDate(new Date());
                    deviceInfo.setEmsName(u2000Service.getEmsName());

                    deviceInfos.add(deviceInfo);
                }
                return deviceInfos;
            }
        });


    }


    private NbiService initCorbaService(Ems ems) {
        CorbaEms corbaEms = new CorbaEms(ems);
        CorbaSbiService corbaService = createCorbaSbiService();
        corbaService.setEmsName(corbaEms.getEmsName());
        corbaService.setNamingServiceDns("off");
        corbaService.setNamingServiceIp(corbaEms.getNamingServiceHost());
        corbaService.setCorbaUrl(corbaEms.getCorbaUrl());
        corbaService.setCorbaTree(corbaEms.getCorbaTree());
        corbaService.setCorbaUserName(corbaEms.getCorbaUserName());
        corbaService.setCorbaPassword(corbaEms.getCorbaPassword());
        corbaService.init();

        NbiService nbiservice = createNbiService(corbaService);
        
//        nbiservice.setCorbaService(corbaService);
//        nbiservice.setKey("2000");
        return nbiservice;
    }
    
    // 伪装连接，目的是获取corbaService
    private NbiService initCorbaServiceFake(Ems ems) {
        CorbaEms corbaEms = new CorbaEms(ems);
        log("Ems:"+ems.getDn()+"-initCorbaService-createCorbaSbiService...");
        CorbaSbiService corbaService = createCorbaSbiService();
        log("Ems:"+ems.getDn()+"-initCorbaService-set...");
        corbaService.setEmsName(corbaEms.getEmsName());
        corbaService.setNamingServiceDns("off");
        corbaService.setNamingServiceIp(corbaEms.getNamingServiceHost());
        corbaService.setCorbaUrl(corbaEms.getCorbaUrl());
        corbaService.setCorbaTree(corbaEms.getCorbaTree());
        corbaService.setCorbaUserName(corbaEms.getCorbaUserName());
        corbaService.setCorbaPassword(corbaEms.getCorbaPassword());
        log("Ems:"+ems.getDn()+"-initCorbaService-init...");
        corbaService.initFake();

        log("Ems:"+ems.getDn()+"-initCorbaService-createNbiService...");
        NbiService nbiservice = createNbiService(corbaService);
        log("Ems:"+ems.getDn()+"-initCorbaService-return...");
//        nbiservice.setCorbaService(corbaService);
//        nbiservice.setKey("2000");
        return nbiservice;
    }

    /**
     *
     * @param ems
     *
     * @param uri
     *
     * exp :  node://HWU2000-HZ/resource/neinfo#12345
     * schema=node
     * authority=HWU2000-HZ
     * path=/resource/neinfo
     * fragment=12345
     *
     * new URI("node://"+emsdn+"/"+op+"/12345");
     *
     * @return
     * @throws Exception
     */
    @Override
    public Serializable obtain(Ems ems, URI uri) throws Exception {
        logger.info("[OBTAIN],ems = "+ems.getDn()+"URI="+uri);
        String path = uri.getPath();
        String op = path;

        if (op.startsWith("/")) op = op.substring(1);
        logger.info("OP="+op);
        if (op.equals("DISCONNECT")) {
             disconnectEms(ems.getDn());
            return true;
        }
        else if (op.equals("CONNECT")) {
            return  connectEms(ems);
        }
        else if (op.equals("RECONNECT")) {
            disconnectEms(ems.getDn());
            connectEms(ems);
        }
        else if (op.equals("EMS")) {
           return emsTable.get(ems.getDn());
        }
        //    node://HWU2000-HZ/NBIExecute#com.alcatelsbell.cdcp.Abc
        else if (op.equals("NBIExecute")) {
            String clsName = uri.getFragment();
            EmsSBIClassloader classloader = new EmsSBIClassloader(getClass().getClassLoader());
            classloader.addFile(new File("../lib-nex/nex.jar"));
            Object object  = classloader.loadClass(clsName).newInstance();
            log("CorbaEmsAdapterTemplate.obtain");
            if (object instanceof EmsExecutable && !StringUtils.contains(ems.getTag1(), "New"))
               return (Serializable)executeWithLongLiveConnection(ems,(EmsExecutable)object);

        } else if (op.startsWith("NBIService")) {
            // node://HWU2000-HZ/NBIService/neinfo#12345$$
            final String _method = op.substring(op.indexOf("/")+1);
            final List<String> paraList = new ArrayList<String>();

            String paras = uri.getFragment();

            logger.info("method = "+_method);
            logger.info("paras = "+paras);
            if (paras != null && paras.length() > 0) {

                String[] ps = paras.split("&&");
                if (ps != null && ps.length > 0)
                    paraList.addAll(Arrays.asList(ps));

            }



            Object o =   executeImmediate(ems, new EmsExecutable() {
                @Override
                public Object execute(NbiService u2000Service) {
                    Class<? extends NbiService> aClass = u2000Service.getClass();
                    Method[] methods = aClass.getMethods();
                    Method method = null;
                    for (Method method1 : methods) {
                        if (method1.getName().equals(_method) && method1.getParameterTypes().length == paraList.size()) {
                            method = method1;
                        }
                    }


                    if (method != null) {
                        Class<?>[] parameterTypes = method.getParameterTypes();
                        Object[] p = new Object[parameterTypes.length];

                        for (int i = 0; i < parameterTypes.length; i++) {
                            Class<?> type = parameterTypes[i];
                            if (type.equals(String.class)) {
                                p[i] = paraList.get(i);
                            } else if (type.equals(Integer.class) ||  type.equals(type.equals(int.class))) {
                                p[i] = Integer.parseInt(paraList.get(i));
                            } else if (type.equals(Long.class) ||  type.equals(type.equals(long.class))) {
                                p[i] = Integer.parseInt(paraList.get(i));
                            }
                        }

                        try {
                            if (p.length == 0)
                                return method.invoke(u2000Service);
                            return method.invoke(u2000Service,p);
                        } catch (IllegalAccessException e) {
                            logger.error(e, e);
                        } catch (InvocationTargetException e) {
                            logger.error(e, e);
                        }
                    }
                    return null;
                }
            });
            if (o instanceof Collection)
                return new ArrayList((Collection) o);
            else if (o instanceof Serializable)
                return (Serializable)o;
            else return o.toString();

        }
        else {
            logger.error("UNKOWN OP = "+op);

        }




        return  "UNKOWN OP = "+op;

    }

    @Override
    public Serializable obtain(Ems ems, String s) throws Exception {
        return obtain(ems,new URI(s));
    }

    public abstract CorbaSbiService createCorbaSbiService();

    public abstract NbiService createNbiService(CorbaSbiService corbaSbiService);

    private Object execute(Ems ems,EmsExecutable emsExecutable) {
    	log("CorbaEmsAdapterTemplate.execute-" + ems.getDn() + "-" + ems.getTag1());
        if (kac || !StringUtils.contains(ems.getTag1(), "New")) {
        	log("CorbaEmsAdapterTemplate.execute-New");
           return  executeWithLongLiveConnection(ems,emsExecutable);
        } else {
        	log("CorbaEmsAdapterTemplate.execute-Old");
           return  executeOld(ems, emsExecutable);
        }
    }

    private Object executeImmediate(Ems ems,EmsExecutable emsExecutable) {
        CorbaKeepAliveConnection keepAliveConnection = (CorbaKeepAliveConnection) keepAliveConnectionsManager.getConnection(ems.getDn());
        if (keepAliveConnection != null)
            return emsExecutable.execute(keepAliveConnection.nbiService);
        return null;
    }

    private Object executeOld(Ems ems,EmsExecutable emsExecutable) {
        NbiService u2000Service = null;
        ReentrantLock lock = getLock(ems.getDn());
        lock.lock();
        try {
            u2000Service = initCorbaService(ems);

            return emsExecutable.execute(u2000Service);
        } catch (Throwable e) {
            logger.error(e, e);
        } finally {
            try {
                if (u2000Service != null) {
                    u2000Service.disconnect();
                    u2000Service = null;
                }
            } catch (Throwable e) {
                logger.error(e, e);
            }

            try {
                Thread.sleep(60000l);
            } catch (InterruptedException e) {

            }
            lock.unlock();
            // delayUnLock(getLock(ems.getDn()));
        }
        return null;
    }



    public Object executeWithLongLiveConnection(Ems ems,EmsExecutable emsExecutable)  {
    	log("Ems:"+ems.getDn()+"-executeWithLongLiveConnection Start..." + "-" + ems.getTag1());
        CorbaKeepAliveConnection keepAliveConnection = null;
        long waitingSec = 5;
        
        if (StringUtils.contains(ems.getTag1(), "New")) {
        	log("Ems:"+ems.getDn()+"-executeWithLongLiveConnection initCorbaService...");
        	NbiService nbiService = initCorbaServiceFake(ems);
        	log("Ems:"+ems.getDn()+"-executeWithLongLiveConnection 伪装连接...");
        	CorbaKeepAliveConnection corbaKeepAliveConnection = new CorbaKeepAliveConnection(ems.getDn(), nbiService);
        	log("EMS:"+ems.getDn()+" connected !");
        	EmsStateManager.getInstance().emsOk(ems.getDn(),"connectEms");
        	keepAliveConnectionsManager.addConnection(corbaKeepAliveConnection);
        }
        
        	while ((keepAliveConnection = (CorbaKeepAliveConnection) keepAliveConnectionsManager.borrowConnection(ems.getDn()))
                    == null) {
                log("Ems:"+ems.getDn()+" is not ready for job ,please wait ... "+waitingSec+" seconds");
                try {
                    Thread.sleep(waitingSec * 1000l);
                    if (waitingSec < 3600)
                        waitingSec = waitingSec * 2;
                } catch (InterruptedException e) {

                }
            }

        try {
        	log("Ems:"+ems.getDn()+"-executeWithLongLiveConnection try...");
            return emsExecutable.execute(keepAliveConnection.nbiService);
        } finally {
            keepAliveConnectionsManager.returnConnection(keepAliveConnection);
        }
    }




}
