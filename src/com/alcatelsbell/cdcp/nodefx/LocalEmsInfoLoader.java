package com.alcatelsbell.cdcp.nodefx;


import com.alcatelsbell.nms.util.SysProperty;
import com.alcatelsbell.nms.valueobject.CdcpDictionary;
import com.alcatelsbell.nms.valueobject.sys.Ems;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.asb.mule.probe.framework.entity.EmsInfo;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

/**
 * Author: Ronnie.Chen
 * Date: 2015/4/13
 * Time: 15:52
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class LocalEmsInfoLoader {
    private Log logger = LogFactory.getLog(getClass());
    private Scheduler m_scheduler = null;

    public void load(String sysNodeDn, NodeAdmin nodeAdmin , EmsInfo emsInfo) {
        logger.info("Load Ems : "+emsInfo);
        String emsname = emsInfo.getName();
        String type = emsInfo.getType();
        String power = emsInfo.getPower();
        String namingServiceIp = SysProperty.getString("corba.namingServiceIp");
        if (namingServiceIp == null) {
            try {
                namingServiceIp = InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException e) {
                logger.error(e, e);
            }
        }

        String corbaUserName = emsInfo.getUsername();
        String corbaPassword = emsInfo.getPassword();
        String corbaTree = emsInfo.getPath();
        String domain = emsInfo.getDomain();
        String schedule_type = emsInfo.getScheduleType();
        String loader = emsInfo.getLoader();
        String schedule_quartzExp = emsInfo.getScheduleExpression();
        String corbaUrl = emsInfo.getUrl();
        if (corbaUrl == null) {
            corbaUrl = "corbaloc:iiop:"+emsInfo.getHost()+":"+emsInfo.getPort()+"/NameService";
        }

        Ems newEms = new Ems();
        newEms.setName(emsname);
        newEms.setSysNodeDn(sysNodeDn);
        newEms.setType(type);
        newEms.setTag1(domain);
        newEms.setUserObject(emsInfo.getProperties());
        System.out.println("newEms :userObject " + newEms.getUserObject());



        if ("on".equals(power))
            newEms.setStatus(CdcpDictionary.EMSSTATUS.OK.value);
        else
            newEms.setStatus(CdcpDictionary.EMSSTATUS.DISABLED.value);
        newEms.setDn(emsname);
        newEms.setProtocalType(CdcpDictionary.PROTOCALTYPE.PTN.value);
        String additionalInfo =
                "config_emsname|"+emsname+";"+
                        "config_namingServiceHost|"+namingServiceIp+";"+
                        "config_corbaUrl|"+corbaUrl+";"+
                        "config_corbaTree|"+corbaTree+";"+
                        "config_corbaUserName|"+corbaUserName+";"+
                        "config_corbaPassword|"+corbaPassword;
        newEms.setAdditionalinfo(additionalInfo);

        if (NodeContext.getNodeContext().getJmsSupport() != null) {
            SBIEvent event = new SBIEvent(emsname,null);
            event.getDataMap().put("Ems",newEms);
            try {
                MessageUtil.sendEmsEventMessage(emsname,event);
            } catch (Exception e) {
                logger.error(e, e);
            }
        }

        try {
            logger.info("Local Ems : "+emsname+" loaded");

            nodeAdmin.newEms(newEms);



            if (schedule_type != null &&   ("on".equals(power))) {
                if (m_scheduler == null) {
                    m_scheduler = StdSchedulerFactory.getDefaultScheduler();
                    m_scheduler.start();
                }

                Trigger m_trigger = null;
                if (schedule_type.equals("cron")) {
                    m_trigger = new CronTrigger("ems-sbi-Trigger-" + emsname,
                            Scheduler.DEFAULT_GROUP, schedule_quartzExp);
                } else if (schedule_type.equals("hourly")){
                    m_trigger = TriggerUtils.makeHourlyTrigger(Integer.parseInt(schedule_quartzExp));
                } else if (schedule_type.equals("minutely")){
                    m_trigger = TriggerUtils.makeMinutelyTrigger(Integer.parseInt(schedule_quartzExp));
                } else if (schedule_type.equals("secondly")){
                    m_trigger = TriggerUtils.makeSecondlyTrigger(Integer.parseInt(schedule_quartzExp));
                }
                if (m_trigger != null) {
                    m_trigger.setStartTime(new Date(new Date().getTime() + 5 * 1000));
                    m_trigger.setName("ems-sbi-Trigger-"+emsname);
                }
                JobDetail jobDetail = new JobDetail("ems-sbi-"+emsname,
                        Scheduler.DEFAULT_GROUP, LocalEmsJob.class);
                jobDetail.getJobDataMap().put("EMS",newEms);
                jobDetail.getJobDataMap().put("NodeAdmin",nodeAdmin);
                jobDetail.getJobDataMap().put("loader",loader);
                m_scheduler.scheduleJob(jobDetail,m_trigger);


                logger.info("schedule EMS : "+emsname+" "+schedule_type+" "+schedule_quartzExp);

                // QuartzUtil.
            }
        } catch (Exception e) {
            logger.error(e, e);
        }

    }

    public void load(String sysNodeDn,NodeAdmin nodeAdmin) {
        Properties  properties = SysProperty.getProperties("def.ems");

        HashMap<String,HashMap<String,String>> map = new HashMap<String, HashMap<String, String>>();
        for (Object o : properties.keySet()) {
            String key = (String)o;
            String emsname = null;
            int i = key.indexOf(".",key.indexOf("def.ems.")+8);
            if (i < 0) {
                emsname = key.substring(key.lastIndexOf(".")+1);
            } else {
                emsname = key.substring(key.indexOf("def.ems.")+8,i);
            }

            if (map.get(emsname) == null)
                map.put(emsname,new HashMap<String, String>());

            map.get(emsname).put(key,properties.getProperty(key));

        }


        for (String emsname : map.keySet()) {
            HashMap<String, String> pros = map.get(emsname);
            String status = pros.get("def.ems."+emsname);
            String type = pros.get("def.ems."+emsname+".type");
            String schedule_quartzExp = pros.get("def.ems."+emsname+".schedule.expression");
            String schedule_type = pros.get("def.ems."+emsname+".schedule.type");
            String namingServiceIp = pros.get("def.ems."+emsname+".namingServiceIp");
            String corbaUrl = pros.get("def.ems."+emsname+".corbaUrl");
            String corbaTree = pros.get("def.ems."+emsname+".corbaTree");
            String corbaUserName = pros.get("def.ems."+emsname+".corbaUserName");
            String corbaPassword = pros.get("def.ems."+emsname+".corbaPassword");
            String loader = pros.get("def.ems."+emsname+".loader");


            Ems newEms = new Ems();
            newEms.setName(emsname);
            newEms.setSysNodeDn(sysNodeDn);
            newEms.setType(type);
            newEms.setTag1(pros.get("def.ems."+emsname+".domain"));
       //     newEms.setVendordn("Huawei");
            if ("on".equals(status))
                newEms.setStatus(CdcpDictionary.EMSSTATUS.OK.value);
            else
                newEms.setStatus(CdcpDictionary.EMSSTATUS.DISABLED.value);
            newEms.setDn(emsname);
            newEms.setProtocalType(CdcpDictionary.PROTOCALTYPE.PTN.value);
            String additionalInfo =
                    "config_emsname|"+emsname+";"+
                            "config_namingServiceHost|"+namingServiceIp+";"+
                            "config_corbaUrl|"+corbaUrl+";"+
                            "config_corbaTree|"+corbaTree+";"+
                            "config_corbaUserName|"+corbaUserName+";"+
                            "config_corbaPassword|"+corbaPassword;
            newEms.setAdditionalinfo(additionalInfo);

            if (NodeContext.getNodeContext().getJmsSupport() != null) {
                SBIEvent event = new SBIEvent(emsname,null);
                event.getDataMap().put("Ems",newEms);
                try {
                    MessageUtil.sendEmsEventMessage(emsname,event);
                } catch (Exception e) {
                    logger.error(e, e);
                }
            }

            try {
                logger.info("Local Ems : "+emsname+" loaded");

                nodeAdmin.newEms(newEms);



                if (schedule_type != null &&   ("on".equals(status))) {
                    if (m_scheduler == null) {
                        m_scheduler = StdSchedulerFactory.getDefaultScheduler();
                        m_scheduler.start();
                    }

                    Trigger m_trigger = null;
                    if (schedule_type.equals("cron")) {
                          m_trigger = new CronTrigger("ems-sbi-Trigger-" + emsname,
                                Scheduler.DEFAULT_GROUP, schedule_quartzExp);
                    } else if (schedule_type.equals("hourly")){
                        m_trigger = TriggerUtils.makeHourlyTrigger(Integer.parseInt(schedule_quartzExp));
                    } else if (schedule_type.equals("minutely")){
                        m_trigger = TriggerUtils.makeMinutelyTrigger(Integer.parseInt(schedule_quartzExp));
                    } else if (schedule_type.equals("secondly")){
                        m_trigger = TriggerUtils.makeSecondlyTrigger(Integer.parseInt(schedule_quartzExp));
                    }
                    if (m_trigger != null) {
                        m_trigger.setStartTime(new Date(new Date().getTime() + 5 * 1000));
                        m_trigger.setName("ems-sbi-Trigger-"+emsname);
                    }
                    JobDetail jobDetail = new JobDetail("ems-sbi-"+emsname,
                            Scheduler.DEFAULT_GROUP, LocalEmsJob.class);
                    jobDetail.getJobDataMap().put("EMS",newEms);
                    jobDetail.getJobDataMap().put("NodeAdmin",nodeAdmin);
                    jobDetail.getJobDataMap().put("loader",loader);
                    m_scheduler.scheduleJob(jobDetail,m_trigger);


                    logger.info("schedule EMS : "+emsname+" "+schedule_type+" "+schedule_quartzExp);

                   // QuartzUtil.
                }
            } catch (Exception e) {
                logger.error(e, e);
            }


        }



    }

    public static void main(String[] args) {
     //   new LocalEmsInfoLoader().load();
    }
}
