package com.alcatelsbell.cdcp.nodefx;


import com.alcatelsbell.nms.common.SysUtil;
import com.alcatelsbell.nms.interfaces.Constants;
import com.alcatelsbell.nms.util.SysProperty;
import com.sun.jdmk.comm.HtmlAdaptorServer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.management.*;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
import java.io.File;

/**
 * Author: Ronnie.Chen
 * Date: 13-8-31
 * Time: 下午4:37
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class NodeMBeanServer {
  //  private static final String SYSTEM_PROPERTY_JMX_NODE = "SYSTEM_PROPERTY_JMX_NODE";
    private Log logger = LogFactory.getLog(getClass());
    private MBeanServer mBeanServer = null;
    private HtmlAdaptorServer htmlAdaptor = null;
    private JMXServiceURL jmxmpServiceURL = null;
    private String nodeName;
    private NodeContext nodeContext = null;

    public NodeMBeanServer(NodeContext nodeContext) {
        this.nodeContext = nodeContext;
    }

    public void start() {
        nodeName = SysProperty.getString(Constants.SYSTEM_PROPERTY_JMX_NODE, SysUtil.getHostName() + "_" + new File("").getAbsolutePath());
        System.setProperty(Constants.SYSTEM_PROPERTY_JMX_NODE,nodeName);
        logger.info("nodeName="+nodeName);
        mBeanServer = MBeanServerFactory.createMBeanServer(CDCPConstants.NODE_JMS_DOMAIN);
        createJMXConnectorServer();
        createHTMLAdapter();


        nodeContext.setNodeDName(nodeName);
        nodeContext.setNodeName(nodeName);
        nodeContext.setJmxHtmlPort(htmlAdaptor.getPort());
        nodeContext.setJmxmpPort(jmxmpServiceURL.getPort());
        nodeContext.setIpAddress(SysUtil.getHostName());
        nodeContext.setmBeanServer(mBeanServer);
        String dbCls = SysProperty.getString("cdcp.nodedb.class");
        try {
            if (dbCls != null)
                nodeContext.setNodeDB(dbCls == null ? new NodeDBSqliteImpl() : (NodeDB)Class.forName(dbCls).newInstance());
        } catch (Exception e) {
            logger.error(e, e);
        }

        //   createLiveHeartBeat();

    }

//    private void createLiveHeartBeat() {
//        NodeMessage message = nodeContext.createNodeMessage(Constants.COMMAND_NODE_STARTUP,null);
//
//
//        try {
//            nodeContext.getMessageDelegation().sendTopicMessage(com.alcatelsbell.nms.node.Constants.TOPIC_NODE_SYSTEM, message);
//        } catch (Exception e) {
//            logger.error(e, e);
//        }
//
//        TimerTask timerTask = new TimerTask() {
//            @Override
//            public void run() {
//                NodeMessage message = nodeContext.createNodeMessage(Constants.COMMAND_NODE_ALIVE,null);
//                try {
//                    nodeContext.getMessageDelegation().sendTopicMessage(com.alcatelsbell.nms.node.Constants.TOPIC_NODE_SYSTEM, message);
//                } catch (Exception e) {
//                    logger.error(e, e);
//                }
//            }
//        };
//        new Timer().schedule(timerTask,3600 * 1000, 3600 * 1000);
//    }

    private void createJMXConnectorServer() {
        Runnable r = new Runnable(){
            public void run() {

                try {
                    jmxmpServiceURL = new JMXServiceURL(Constants.JMXMP_PROTOCAL,
                            SysUtil.getHostName(),
                            SysProperty.getInt(Constants.SYSTEM_PROPERTY_JMXMP_PORT,Constants.JMX_REMOTE_PORT));

                    JMXConnectorServer cs = JMXConnectorServerFactory.newJMXConnectorServer(jmxmpServiceURL, null, mBeanServer);
                    logger.info("JMXMP URL = "+jmxmpServiceURL);
                    System.out.println("jmxmpServiceURL = " + jmxmpServiceURL);
                    cs.start();
                } catch ( Exception ex2) {
                    logger.error(ex2,ex2);
                }
            }
        };
        new Thread(r).run();
    }

    public MBeanServer getmBeanServer() {
        return mBeanServer;
    }

    private void createHTMLAdapter() {
        htmlAdaptor = new HtmlAdaptorServer();
        ObjectName htmlAdaptorON = null;
        try {
            htmlAdaptorON = new ObjectName(Constants.JMX_DOMAIN +
                    ":name=HtmlAdaptor");
            mBeanServer.registerMBean(htmlAdaptor, htmlAdaptorON);

        } catch (NullPointerException ex) {
            ex.printStackTrace();
        } catch (MalformedObjectNameException ex) {
            ex.printStackTrace();
        } catch (NotCompliantMBeanException ex) {
            ex.printStackTrace();
        } catch (MBeanRegistrationException ex) {
            ex.printStackTrace();
        } catch (InstanceAlreadyExistsException ex) {
            ex.printStackTrace();
        }

        htmlAdaptor.setPort(SysProperty.getInt(Constants.SYSTEM_PROPERTY_JMX_HTML_PORT,Constants.JMX_HTTP_PORT));

        logger.info("Starting the HtmlAdaptor....on port:"+htmlAdaptor.getPort());
        htmlAdaptor.start();

    }


    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

}
