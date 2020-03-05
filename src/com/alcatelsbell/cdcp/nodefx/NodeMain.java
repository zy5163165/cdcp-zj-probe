package com.alcatelsbell.cdcp.nodefx;

import com.alcatelsbell.cdcp.nodefx.nbi.netty.CdcpNettyServer;
import com.alcatelsbell.nms.common.JMSSupport;
import com.alcatelsbell.nms.interfaces.Constants;
import com.alcatelsbell.nms.service.main.JSSupport;
import com.alcatelsbell.nms.util.SysProperty;
import com.alcatelsbell.nms.util.jms.JMSSupportSpringImpl;
import com.alcatelsbell.nms.valueobject.sys.Ems;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.asb.mule.probe.framework.Main;
import org.asb.mule.probe.framework.entity.EmsInfo;
import org.asb.mule.probe.framework.util.FileLogger;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.management.ObjectName;
import java.io.Serializable;
import java.util.List;

/**
 * Author: Ronnie.Chen
 * Date: 13-9-10
 * Time: 上午10:52
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class NodeMain {



    private static void checkSystemProperty(String propertyName, String prompt) {
        String property = SysProperty.getString(propertyName);
        if (property == null) {
            if (prompt == null)
                System.err.println("Please config property \""+propertyName+"\" in system.properties");
            else
                System.err.println(prompt);
            System.exit(1);
        }
    }
    public static void main(String[] args) {
        if (args != null) {
            if (args.length > 0)
                SysProperty.getProperties().setProperty(Constants.SYSTEM_PROPERTY_JMX_NODE,args[0]);
            if (args.length > 1)
                SysProperty.getProperties().setProperty(Constants.SYSTEM_PROPERTY_JMXMP_PORT,args[1]);
            if (args.length > 2)
                SysProperty.getProperties().setProperty(Constants.SYSTEM_PROPERTY_JMX_HTML_PORT,args[2]);
        }
        checkSystemProperty(Constants.SYSTEM_PROPERTY_JMX_NODE,"Please use \"NodeMain $nodename $jmxport $htmlport \" to start application \n or config property \"node\" with a global unique value in system.properties ");
 //       checkSystemProperty(CDCPConstants.SYSTEM_PROPERTY_ACTIVE_MQ_URL,null);
        checkSystemProperty(Constants.SYSTEM_PROPERTY_JMXMP_PORT,null);
//        checkSystemProperty(Constants.SYSTEM_PROPERTY_JMX_HTML_PORT,null);
//        checkSystemProperty(CDCPConstants.SYSTEM_PROPERTY_FTP_HOST,null);
//        checkSystemProperty(CDCPConstants.SYSTEM_PROPERTY_FTP_USER,null);
//        checkSystemProperty(CDCPConstants.SYSTEM_PROPERTY_FTP_PASSWORD,null);
        checkSystemProperty(CDCPConstants.SYSTEM_PROPERTY_EMS_ADAPTERS,null);


        String node = SysProperty.getString(Constants.SYSTEM_PROPERTY_JMX_NODE);
        String jmsUrl = SysProperty.getString(CDCPConstants.SYSTEM_PROPERTY_ACTIVE_MQ_URL);
        System.out.println("**************************************************");
        System.out.println("*                                                *");
        System.out.println("*            CDCP NODE 1.0                       *");
        System.out.println("*                                                *");
        System.out.println("*                                                *");
        System.out.println("**************************************************");
        System.out.println("node = "+node);
        System.out.println("jmsUrl = " + jmsUrl);
        System.out.println("node log = ../logs/"+node+".log");
        final NodeContext nodeContext = new NodeContext();
        NodeContext.setNodeContext(nodeContext);
        nodeContext.setLogger(new FileLogger(node+".log").getLogger());

        if (jmsUrl != null) {
            JMSSupport jmsSupport = new JMSSupportSpringImpl(new ActiveMQConnectionFactory(jmsUrl));
            nodeContext.setJmsSupport(jmsSupport);
            nodeContext.setAttribute("JSSupport",jmsSupport);
            System.out.println("Connect to : "+jmsUrl);
        }
        NodeMBeanServer server = new NodeMBeanServer(nodeContext);
        server.start();

        try {
            NodeAdmin nodeAdmin = new NodeAdmin();
            ObjectName ifcON = new ObjectName(CDCPConstants.NODE_JMS_DOMAIN+":name=NodeAdmin");
            server.getmBeanServer().registerMBean(nodeAdmin, ifcON);

            JSSupport support = new JSSupport();
            ObjectName on2 = new ObjectName(CDCPConstants.NODE_JMS_DOMAIN +":name=JSSupport");
            server.getmBeanServer().registerMBean(support, on2);


            nodeContext.setAttribute("NodeAdmin",nodeAdmin);


            if (jmsUrl != null)
                jmsRegister(nodeContext,nodeAdmin);


            if (SysProperty.getString("nbi.netty","off").equalsIgnoreCase("on")) {
                System.out.println("Starting NBI netty server ...");
                CdcpNettyServer.startInBackground(args);
            }

            System.out.println("**********************************************************");
            System.out.println();
            System.out.println("**                CONGRATULATIONS !!!!!!                **");
            System.out.println("**            NODE STARTUPED SUCCESSFULLY !             **");
            System.out.println();
            System.out.println("**********************************************************");

            LocalEmsInfoLoader localEmsInfoLoader = new LocalEmsInfoLoader();
            localEmsInfoLoader.load(node,nodeAdmin);

            String emsLoaderClass = SysProperty.getString("emsProviderClass");
            if (emsLoaderClass != null) {
                Object o = Class.forName(emsLoaderClass).newInstance();
                if (o instanceof EmsInfoProvider) {
                    List<EmsInfo> emsInfos = ((EmsInfoProvider) o).provide();
                    if (emsInfos != null) {
                        for (EmsInfo emsInfo : emsInfos) {
                            if (emsInfo.getPower() == null || emsInfo.getPower().equalsIgnoreCase("on"))
                                localEmsInfoLoader.load(node,nodeAdmin,emsInfo);
                            else
                                System.out.println(emsInfo.getName()+" is off .");
                        }
                    }
                }
            }


        } catch (Exception e) {
            nodeContext.getLogger().error(e,e);
            e.printStackTrace();
        }

        if (args.length > 3) {
            Main.main(args);
        }

    }

    private static void jmsRegister(final NodeContext nodeContext,final NodeAdmin nodeAdmin) throws Exception {
        nodeContext.getJmsSupport().addTopicSubscriber(CDCPConstants.TOPIC_SERVER_BROADCAST,new MessageListener() {
            @Override
            public void onMessage(Message message) {
                try {
                    heartBeat(nodeContext);
                } catch (Exception e) {
                    nodeContext.getLogger().error(e, e);
                }

                try {
                    if (message instanceof ObjectMessage) {
                        CdcpMessage cdcpMessage = (CdcpMessage)((ObjectMessage) message).getObject();
                        Serializable object = cdcpMessage.getObject();
                        if (object != null && object instanceof List) {
                            List<Ems> emsList = (List)object;
                            nodeAdmin.handleLatestEmsList(emsList);
                        }
                    }
                } catch (Exception e) {
                    nodeContext.getLogger().error(e, e);
                }
            }
        });
        CdcpMessage message = nodeContext.createMessage();
        message.setType(CDCPConstants.MESSAGE_TYPE_NODE_STARTUP);
        message.setAttribute(CDCPConstants.MESSAGE_ATTRIBUTE_RECEIVE_UN_FINISH_TASKS,
                SysProperty.getString(CDCPConstants.MESSAGE_ATTRIBUTE_RECEIVE_UN_FINISH_TASKS,"false"));
        nodeContext.getJmsSupport().sendTopicMessage(CDCPConstants.TOPIC_NODE,message);
        Runnable heartbeat = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(30 * 60 * 1000l);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    heartBeat(nodeContext);
                }
            }
        };
        new Thread(heartbeat).start();
    }

    private static void heartBeat(NodeContext nodeContext) {
        CdcpMessage message = nodeContext.createMessage();
        message.setType(CDCPConstants.MESSAGE_TYPE_NODE_ALIVE);
        try {
            nodeContext.getJmsSupport().sendTopicMessage(CDCPConstants.TOPIC_NODE,message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
