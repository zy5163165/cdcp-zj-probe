package com.alcatelsbell.cdcp.nodefx;

import com.alcatelsbell.nms.common.JMSSupport;
import com.alcatelsbell.nms.common.SysUtil;
import org.apache.log4j.Logger;

import javax.management.MBeanServer;
import java.io.File;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author: Ronnie.Chen
 * Date: 13-8-31
 * Time: 下午4:39
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class NodeContext {
    private ConcurrentHashMap attributes = new ConcurrentHashMap();

    private String nodeDName;
    private String nodeName;
    private String ipAddress;
    private String workPath;
    private String physicalAddress;
    private int jmxmpPort;
    private int jmxHtmlPort;
    private Logger logger = null;
    private NodeDB nodeDB = null;

    private JMSSupport jmsSupport = null;
    private static NodeContext _nodeContext = null;
    public static NodeContext getNodeContext() {
          return _nodeContext;
    }
    public static void  setNodeContext(NodeContext nodeContext) {
        _nodeContext = nodeContext;
    }
    public JMSSupport getJmsSupport() {
        return jmsSupport;
    }

    public void setJmsSupport(JMSSupport jmsSupport) {
        this.jmsSupport = jmsSupport;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    private MBeanServer mBeanServer = null;

    public MBeanServer getmBeanServer() {
        return mBeanServer;
    }

    public void setmBeanServer(MBeanServer mBeanServer) {
        this.mBeanServer = mBeanServer;
    }


    //
//    public NodeContext(String[] locations) {
//        springApplicationContext = new ClassPathXmlApplicationContext(locations);
//    }
//
//    public NodeContext(AbstractApplicationContext springApplicationContext) {
//        this.springApplicationContext = springApplicationContext;
//    }
//
//    public AbstractApplicationContext getSpringApplicationContext() {
//        return springApplicationContext;
//    }
//
//    public void setSpringApplicationContext(AbstractApplicationContext springApplicationContext) {
//        this.springApplicationContext = springApplicationContext;
//    }


    public Object getAttribute(String key) {
        return attributes.get(key);
    }

    public void setAttribute(String key,Object value) {
        attributes.put(key,value);
    }

    public String getNodeDName() {
        return nodeDName;
    }

    public void setNodeDName(String nodeDName) {
        this.nodeDName = nodeDName;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getWorkPath() {
        return workPath;
    }

    public void setWorkPath(String workPath) {
        this.workPath = workPath;
    }

    public String getPhysicalAddress() {
        return physicalAddress;
    }

    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    public int getJmxmpPort() {
        return jmxmpPort;
    }

    public void setJmxmpPort(int jmxmpPort) {
        this.jmxmpPort = jmxmpPort;
    }

    public int getJmxHtmlPort() {
        return jmxHtmlPort;
    }

    public void setJmxHtmlPort(int jmxHtmlPort) {
        this.jmxHtmlPort = jmxHtmlPort;
    }

    public CdcpMessage createMessage() {
        CdcpMessage message = new CdcpMessage();
        message.setNodeDName( getNodeDName());
        message.setNodeName( getNodeName());
        message.setJmxHtmlPort( getJmxHtmlPort());
        message.setJmxmpPort( getJmxmpPort());
        message.setSerialId(SysUtil.nextLongId()+"");
        message.setIpAddress(getIpAddress());
        message.setWorkPath(SysUtil.getHostName()+"_"+new File("").getAbsolutePath());
        return message;

    }

    public void deliverEmsJobObject(String taskSerial ,Serializable object) {
        ObjectBase.getInstance().registerObject(taskSerial,object);
        try {
            MessageUtil.sendSBIFinishMessage(taskSerial);
        } catch (Exception e) {
            logger.error(e, e);
        }
    }

    public NodeDB getNodeDB() {
        return nodeDB;
    }

    public void setNodeDB(NodeDB nodeDB) {
        this.nodeDB = nodeDB;
    }
}
