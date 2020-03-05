package com.alcatelsbell.cdcp.nodefx;

import com.alcatelsbell.nms.service.main.JSSupport;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.asb.mule.probe.framework.entity.ManagedElement;
//import org.asb.mule.probe.ptn.fenghuo.service.FenghuoService;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;

/**
 * Author: Ronnie.Chen
 * Date: 2014/12/9
 * Time: 18:18
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class Test {
    private Log logger = LogFactory.getLog(getClass());

    public static void main(String[] args) throws Exception {
        ManagedElement me = new ManagedElement();
        me.setNativeEMSName("abcde");
        me.setAdditionalInfo("ad");
        me.setEmsName("adsf");
        Object clone = me.clone();
        MBeanServer mBeanServer = MBeanServerFactory.createMBeanServer(CDCPConstants.NODE_JMS_DOMAIN);
        JSSupport nodeAdmin = new JSSupport();
        ObjectName ifcON = new ObjectName(CDCPConstants.NODE_JMS_DOMAIN+":name=NodeAdmin");
        mBeanServer.registerMBean(nodeAdmin, ifcON);
        System.out.println("mBeanServer = " + mBeanServer);

    }
}
