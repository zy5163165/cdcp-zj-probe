package com.alcatelsbell.cdcp.nodefx;

import com.alcatelsbell.nms.common.SysConst;
import com.alcatelsbell.nms.common.SysUtil;
import com.alcatelsbell.nms.util.log.LogUtil;
import com.alcatelsbell.nms.valueobject.sys.Log;
import org.asb.mule.probe.framework.entity.EDS_PTN;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

/**
 * Author: Ronnie.Chen
 * Date: 13-9-11
 * Time: 下午1:22
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class MessageUtil {
    public static void sendSBIFinishMessage(FtpInfo ftpInfo,String taskSerial) throws Exception {
        LogUtil.error(MessageUtil.class,"Warnning !!!!! EDS_PTN is null");
        sendSBIFinishMessage(ftpInfo, taskSerial, null); 
    }

    public static void sendSBIFinishMessage(FtpInfo ftpInfo,String taskSerial,EDS_PTN eds) throws Exception {
        if (NodeContext.getNodeContext().getJmsSupport() == null) {
            LogUtil.error(MessageUtil.class,"JMS not configured");
            return;
        }

        NodeContext nodeContext = NodeContext.getNodeContext();
        CdcpMessage message = nodeContext.createMessage();
        message.setType(CDCPConstants.MESSAGE_TYPE_TASK_INFO);
        message.setObject(ftpInfo);
        message.setAttribute(CDCPConstants.MESSAGE_ATTRIBUTE_TASK_SERIAL,taskSerial);
        if (eds != null) {
            message.setAttribute(CDCPConstants.MESSAGE_ATTRIBUTE_TASK_EDS,eds);
        }
        nodeContext.getJmsSupport().sendTopicMessage(CDCPConstants.TOPIC_EMS_SBI, message);
        LogUtil.info(MessageUtil.class,"sendTopicMessage : "+CDCPConstants.TOPIC_EMS_SBI+" message="+ftpInfo);
    }

    public static void sendSBIFinishMessage(File ftpInfo, String taskSerial, EDS_PTN eds) throws Exception {
        if (NodeContext.getNodeContext().getJmsSupport() == null) {
            LogUtil.error(MessageUtil.class,"JMS not configured");
            return;
        }

        NodeContext nodeContext = NodeContext.getNodeContext();
        CdcpMessage message = nodeContext.createMessage();
        message.setType(CDCPConstants.MESSAGE_TYPE_TASK_INFO);
        message.setObject(ftpInfo);
        message.setAttribute(CDCPConstants.MESSAGE_ATTRIBUTE_TASK_SERIAL,taskSerial);
        if (eds != null) {
            message.setAttribute(CDCPConstants.MESSAGE_ATTRIBUTE_TASK_EDS,eds);
        }
        nodeContext.getJmsSupport().sendTopicMessage(CDCPConstants.TOPIC_EMS_SBI, message);
        LogUtil.info(MessageUtil.class,"sendTopicMessage : "+CDCPConstants.TOPIC_EMS_SBI+" message="+ftpInfo);
    }



    public static void sendSBIFinishMessage(String taskSerial) throws Exception {
        if (NodeContext.getNodeContext().getJmsSupport() == null) {
            LogUtil.error(MessageUtil.class,"JMS not configured");
            return;
        }

        NodeContext nodeContext = NodeContext.getNodeContext();
        CdcpMessage message = nodeContext.createMessage();
        message.setType(CDCPConstants.MESSAGE_TYPE_TASK_INFO);
        message.setObject(new ObjectInfo(taskSerial));
        message.setAttribute(CDCPConstants.MESSAGE_ATTRIBUTE_TASK_SERIAL,taskSerial);
        nodeContext.getJmsSupport().sendTopicMessage(CDCPConstants.TOPIC_EMS_SBI, message);
    }

    public static void sendSBIFailedMessage(String cause,String taskSerial) throws Exception {
        if (NodeContext.getNodeContext().getJmsSupport() == null) {
            LogUtil.error(MessageUtil.class,"JMS not configured");
            return;
        }

        NodeContext nodeContext = NodeContext.getNodeContext();
        CdcpMessage message = nodeContext.createMessage();
        message.setType(CDCPConstants.MESSAGE_TYPE_TASK_INFO);
        message.setObject(cause);
        message.setAttribute(CDCPConstants.MESSAGE_ATTRIBUTE_TASK_SERIAL,taskSerial);
        nodeContext.getJmsSupport().sendTopicMessage(CDCPConstants.TOPIC_EMS_SBI, message);
    }

    public static void sendSBIMessage(String taskSerial ,String info)  throws Exception {
        if (NodeContext.getNodeContext().getJmsSupport() == null) {
            LogUtil.error(MessageUtil.class,"JMS not configured");
            return;
        }

        NodeContext nodeContext = NodeContext.getNodeContext();
        CdcpMessage message = nodeContext.createMessage();
        message.setType(CDCPConstants.MESSAGE_TYPE_TASK_INFO);
        message.setAttribute(CDCPConstants.MESSAGE_ATTRIBUTE_LOG_TXT,info);
        message.setAttribute(CDCPConstants.MESSAGE_ATTRIBUTE_TASK_SERIAL,taskSerial);
        nodeContext.getJmsSupport().sendTopicMessage(CDCPConstants.TOPIC_LOG, message);
    }

    public static void sendSBIMessage(String taskSerial ,String info,int percentage)  throws Exception {
        if (NodeContext.getNodeContext().getJmsSupport() == null) {
            LogUtil.error(MessageUtil.class,"JMS not configured");
            return;
        }

        NodeContext nodeContext = NodeContext.getNodeContext();
        CdcpMessage message = nodeContext.createMessage();
        message.setType(CDCPConstants.MESSAGE_TYPE_TASK_INFO);
        message.setAttribute(CDCPConstants.MESSAGE_ATTRIBUTE_LOG_TXT,info);
        message.setAttribute(CDCPConstants.MESSAGE_ATTRIBUTE_TASK_SERIAL,taskSerial);
        message.setAttribute(CDCPConstants.MESSAGE_ATTRIBUTE_PERCENTAGE,percentage);
        nodeContext.getJmsSupport().sendTopicMessage(CDCPConstants.TOPIC_LOG, message);
    }

    public static void sendEmsAlarmMessage(Serializable data) throws Exception{
        if (NodeContext.getNodeContext().getJmsSupport() == null) {
            LogUtil.error(MessageUtil.class,"JMS not configured");
            return;
        }

        NodeContext nodeContext = NodeContext.getNodeContext();
        nodeContext.getJmsSupport().sendTopicMessage(CDCPConstants.TOPIC_EMS_ALARM, data);
    }

    public static void sendEmsEventMessage(String emsDn ,SBIEvent sbiEvent)  throws Exception {
        if (NodeContext.getNodeContext().getJmsSupport() == null) {
            LogUtil.error(MessageUtil.class,"JMS not configured");
            return;
        }

        NodeContext nodeContext = NodeContext.getNodeContext();
        CdcpMessage message = nodeContext.createMessage();
        sbiEvent.setEmsDn(emsDn);
        message.setType(CDCPConstants.MESSAGE_TYPE_SBI_EVENT);
        message.setAttribute(CDCPConstants.MESSAGE_ATTRIBUTE_EMSDN, emsDn);
        message.setObject(sbiEvent);
        nodeContext.getJmsSupport().sendTopicMessage(CDCPConstants.TOPIC_EMS_SBI_EVENT, message);
    }

    public static void sendEmsExceptionMessage(String emsDn ,String exceptionCode,String exceptionDetail,boolean recover)  throws Exception {
        if (NodeContext.getNodeContext().getJmsSupport() == null) {
            LogUtil.error(MessageUtil.class,"JMS not configured");
            return;
        }

        SBIEvent event  = new SBIEvent();
        event.setEmsDn(emsDn);
        event.setType(SBIEvent.TYPE_EXCEPTION);
        HashMap hashMap = new HashMap();
        hashMap.put("EXCEPTION_CODE",exceptionCode);
        hashMap.put("EXCEPTION_DETAIL",exceptionDetail);
        hashMap.put("RECOVER",recover);
        event.setDataMap(hashMap);

        sendEmsEventMessage(emsDn,event);

    }

}
