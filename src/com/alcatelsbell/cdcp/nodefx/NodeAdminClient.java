package com.alcatelsbell.cdcp.nodefx;

import com.alcatelsbell.nms.interfaces.Constants;
import com.alcatelsbell.nms.valueobject.sys.Ems;
//import com.gigaspaces.jmx.focalserver.MBeanProxy;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.management.JMX;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.Serializable;
import java.net.URI;

/**
 * Author: Ronnie.Chen
 * Date: 14-8-21
 * Time: 下午7:01
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class NodeAdminClient {
    private Log logger = LogFactory.getLog(getClass());
    public static void test(String host,int port) throws  Exception {
        String oname = CDCPConstants.NODE_JMS_DOMAIN + ":name=NodeAdmin";
        System.out.println("test");
        JMXServiceURL url = new JMXServiceURL(Constants.JMXMP_PROTOCAL,host,port);
        JMXConnector cs = JMXConnectorFactory.connect(url);
        System.out.println("connected");
        MBeanServerConnection msc = cs.getMBeanServerConnection();
        ObjectName objectName = new ObjectName(oname);
        System.out.println("objectName = " + objectName);
        NodeAdminMBean bean = (JMX.newMBeanProxy(msc, objectName, NodeAdminMBean.class));
        System.out.println("bean = " + bean);
        bean.newEms(new Ems());
        System.out.println("success");
    }

    public static NodeAdminMBean getMBean(String host,int port) throws  Exception {
        String oname = CDCPConstants.NODE_JMS_DOMAIN + ":name=NodeAdmin";
        System.out.println("test");
        JMXServiceURL url = new JMXServiceURL(Constants.JMXMP_PROTOCAL,host,port);
        JMXConnector cs = JMXConnectorFactory.connect(url);
        System.out.println("connected");
        MBeanServerConnection msc = cs.getMBeanServerConnection();
        ObjectName objectName = new ObjectName(oname);
        System.out.println("objectName = " + objectName);
        NodeAdminMBean bean = (JMX.newMBeanProxy(msc, objectName, NodeAdminMBean.class));
        System.out.println("bean = " + bean);
        return bean;
    }


    public static void main(String[] args) throws Exception {
        NodeAdminMBean mBean = getMBean(args[0], Integer.parseInt(args[1]));
        String emsdn = args[2];
        Ems ems = new Ems();
        ems.setDn(emsdn);
        ems.setType(args[3]);
        String str1 = "node://" + emsdn + "/EMS";

        ems = (Ems)mBean.obtain(ems, new URI(str1));
        System.out.println(str1+" = " + ems);
        String str = "node://" + emsdn + "/" + args[4] + "";
        Serializable obtain = mBean.obtain(ems, new URI(str));
        System.out.println(str+" = " + obtain);

    }
}
