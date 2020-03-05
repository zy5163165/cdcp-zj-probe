package com.alcatelsbell.cdcp.nodefx;

import com.alcatelsbell.nms.db.components.client.JpaClient;
import com.alcatelsbell.nms.interfaces.Constants;
import com.alcatelsbell.nms.service.main.JSSupportMBean;
import com.alcatelsbell.nms.util.ObjectUtil;
import com.alcatelsbell.nms.util.SysProperty;
import com.alcatelsbell.nms.valueobject.BObject;
import com.alcatelsbell.nms.valueobject.sys.Ems;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.management.JMX;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;

/**
 * Author: Ronnie.Chen
 * Date: 2014/12/9
 * Time: 16:28
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class JSSupportClient {
    public void testHW89_2() throws Exception {
        JSSupportMBean mBean = getMBean("10.212.46.89",10009);
        String js = readFile("hw.js");
        Object ret = mBean.executeJSFunction(js, "execute");
        System.out.println("ret = " + ret);
        if (ret instanceof List) {
            for (Object o : (List) ret) {
                if (o instanceof BObject) {
                    System.out.println(((BObject) o).getDn());
                }
            }
        }
    }

    public void testHW89() throws Exception {
        JSSupportMBean mBean = getMBean("10.212.46.89",10003);
        String js = readFile("hw.js");
        Object ret = mBean.executeJSFunction(js, "execute");
        System.out.println("ret = " + ret);
        if (ret instanceof List) {
            for (Object o : (List) ret) {
                if (o instanceof BObject) {
                    System.out.println(((BObject) o).getDn());
                }
            }
        }
    }

    public void testHW82() throws Exception {
        JSSupportMBean mBean = getMBean("10.212.46.82",10082);
        String js = readFile("hw.js");
        Object ret = mBean.executeJSFunction(js, "execute");
        System.out.println("ret = " + ret);
    }

    public void testFH89() throws Exception {
        JSSupportMBean mBean = getMBean("10.212.46.89",10011);
        String js = readFile("fh.js");
        Object ret = mBean.executeJSFunction(js, "execute");
        if (ret instanceof List) {
            for (Object o : (List)ret) {
                if (o instanceof BObject) {
                    System.out.println(((BObject) o).getDn());
                }
            }
        }
        System.out.println("ret = " + ret);
    }


    private String readFile(String file) throws IOException {
        InputStream resourceAsStream = JSSupportClient.class.getClassLoader().getResourceAsStream(file);

        int available = resourceAsStream.available();
        byte[] bs = new byte[available];
        resourceAsStream.read(bs);
        return new String(bs);
    }

    public static JSSupportMBean getMBean(String host,int port) throws  Exception {
        String oname = CDCPConstants.NODE_JMS_DOMAIN +":name=JSSupport";
        System.out.println("test");
        JMXServiceURL url = new JMXServiceURL(Constants.JMXMP_PROTOCAL,host,port);
        JMXConnector cs = JMXConnectorFactory.connect(url);
        System.out.println("connected");
        MBeanServerConnection msc = cs.getMBeanServerConnection();
        ObjectName objectName = new ObjectName(oname);
        System.out.println("objectName = " + objectName);
        JSSupportMBean bean = (JMX.newMBeanProxy(msc, objectName, JSSupportMBean.class));
        System.out.println("bean = " + bean);
        return bean;
    }
    public static void main(String[] args) throws Exception {
//        ObjectUtil.newFolder("../cache/HUZ-OTNM2000-1-P");
//        ObjectUtil.saveObject("HUZ-OTNM2000-1-P/abcde","dsaf");
        System.out.println("new Date() = " + new Date(1419843606410l));
        System.out.println("new Date() = " + new Date(1419876100970l));
//        List allObjects = JpaClient.getInstance().findAllObjects(Ems.class);
//        System.out.println("allObjects = " + allObjects.size());
        SysProperty.getInt("abc");
        new JSSupportClient().testHW89();
    }
}
