package com.alcatelsbell.cdcp.nodefx;

import com.alcatelsbell.nms.interfaces.Constants;
import com.alcatelsbell.nms.valueobject.sys.Ems;

import javax.management.JMX;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

/**
 * Author: Ronnie.Chen
 * Date: 13-9-11
 * Time: 下午2:43
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class ClientTest {
    public static void main(String[] args) throws  Exception {
        Ems ems = new Ems();
        ems.setType("HWU2000");
        ems.setAdditionalinfo(
                "config_emsname|QZ-U2000-1-P;" +
                "config_namingServiceHost|10.212.51.80;" +
                "config_corbaUrl|corbaloc:iiop:10.80.95.69:12001/NameService;" +
                "config_corbaTree|TMF_MTNM.Class/HUAWEI.Vendor/QZ-U2000-1-P.EmsInstance/2\\.0.Version/QZ-U2000-1-P.EmsSessionFactory_I;" +
                "config_corbaUserName|corba3;" +
                "config_corbaPassword|Corba$zj123");

        NodeAdminMBean jmxmpProxy = (NodeAdminMBean)createJmxmpProxy(NodeAdminMBean.class, "10.212.51.80", 10001);
        EmsJob job = new EmsJob();
        job.setSerial("111");
        job.setEms(ems);
        jmxmpProxy.executeJob(job);

    }

    public static Object createJmxmpProxy(Class mbeanIfc,String host, int port) throws Exception {
        JMXServiceURL url = new JMXServiceURL(Constants.JMXMP_PROTOCAL,host,port);
        JMXConnector cs = JMXConnectorFactory.connect(url);
        MBeanServerConnection msc = cs.getMBeanServerConnection();
        ObjectName objectName = new ObjectName(CDCPConstants.NODE_JMS_DOMAIN+":name=NodeAdmin");
        return JMX.newMBeanProxy(msc, objectName, mbeanIfc);

    }
}
