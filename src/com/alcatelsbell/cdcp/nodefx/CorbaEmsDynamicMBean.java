package com.alcatelsbell.cdcp.nodefx;

import com.alcatelsbell.nms.valueobject.sys.Ems;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.management.*;
import java.lang.reflect.Constructor;
import java.util.*;

/**
 * Author: Ronnie.Chen
 * Date: 2015/4/9
 * Time: 12:54
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class CorbaEmsDynamicMBean implements DynamicMBean {
    private Log logger = LogFactory.getLog(getClass());

    CorbaEmsAdapterTemplate emsAdapter = null;

    public CorbaEmsDynamicMBean(CorbaEmsAdapterTemplate emsAdapter) {
        this.emsAdapter = emsAdapter;
    }

    @Override
    public Object getAttribute(String attribute_name)
            throws AttributeNotFoundException, MBeanException,
            ReflectionException {
        // 检查属性是否为空
        if (attribute_name == null) {
            throw new RuntimeOperationsException(new IllegalArgumentException(
                    "Attribute name cannot be null"),
                    "Cannot invoke a getter of " + dClassName
                            + " with null attribute name");
        }
        KeepAliveConnection connection = emsAdapter.getConnectionManager().getConnection(attribute_name);
        boolean b = connection == null ? false : connection.checkConnection();

        String curr = emsAdapter.emsCurrSyncInfo.get(attribute_name);
        String last = emsAdapter.emsLastSyncInfo.get(attribute_name);

        return (b?"CONNECTED":"!UNCONNECTED!")+"\r\n" + (curr == null ? "FREE":curr) +"\r\n"+( last == null ? "":last);
        // 如果属性不可识别,抛出异常
//        throw (new AttributeNotFoundException("Cannot find " + attribute_name
//                + " attribute in " + dClassName));
    }


    @Override
    public void setAttribute(Attribute attribute) throws AttributeNotFoundException, InvalidAttributeValueException, MBeanException, ReflectionException {

    }

    @Override
    public AttributeList getAttributes(String[] attributeNames) {
        if (attributeNames == null) {
            throw new RuntimeOperationsException(new IllegalArgumentException(
                    "attributeNames[] cannot be null"),
                    "Cannot invoke a getter of " + dClassName);
        }
        AttributeList resultList = new AttributeList();
        if (attributeNames.length == 0)
            return resultList;
        for (int i = 0; i < attributeNames.length; i++) {
            try {
                Object value = getAttribute((String) attributeNames[i]);
                resultList.add(new Attribute(attributeNames[i], value));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return (resultList);
    }

    @Override
    public AttributeList setAttributes(AttributeList attributes) {
        if (attributes == null) {
            throw new RuntimeOperationsException(new IllegalArgumentException(
                    "AttributeList attributes cannot be null"),
                    "Cannot invoke a setter of " + dClassName);
        }
        AttributeList resultList = new AttributeList();
        if (attributes.isEmpty())
            return resultList;
        for (Iterator i = attributes.iterator(); i.hasNext();) {
            Attribute attr = (Attribute) i.next();
            try {
                setAttribute(attr);
                String name = attr.getName();
                Object value = getAttribute(name);
                resultList.add(new Attribute(name, value));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return (resultList);
    }

    @Override
    public Object invoke(String actionName, Object[] params, String[] signature) throws MBeanException, ReflectionException {
        return null;
    }

    @Override
    public MBeanInfo getMBeanInfo() {
        return buildDynamicMBeanInfo();
    }

    private String state = "initial state";
    private int nbChanges = 0;
    private int nbResets = 0;
    private String dClassName = this.getClass().getName();
    private String dDescription = "Simple implementation of a dynamic MBean.";





    private MBeanInfo buildDynamicMBeanInfo() {
        MBeanInfo dMBeanInfo = null;
          MBeanOperationInfo[] dOperations = null;
          MBeanConstructorInfo[] dConstructors = new MBeanConstructorInfo[1];
        HashMap<String, KeepAliveConnection> connections = emsAdapter.getConnectionManager().getConnections();
        Hashtable<String, Ems> emsTable = emsAdapter.getEmsTable();
        MBeanAttributeInfo[] dAttributes = new MBeanAttributeInfo[emsTable.size()];
        List<MBeanOperationInfo> operationInfoList = new ArrayList<MBeanOperationInfo>();
        int idx = 0;
        for (String key : emsTable.keySet()) {

                dAttributes[idx++] = new MBeanAttributeInfo(key, "java.lang.String",
                        key + " 连接状态 ", true, false, false);


            KeepAliveConnection connection = connections.get(key);
            if (connection != null && connection.checkConnection()) {
                MBeanParameterInfo[] params = new MBeanParameterInfo[]{new MBeanParameterInfo("url","java.lang.String","url")};
                MBeanOperationInfo operationInfo =  new MBeanOperationInfo(
                        key+"_obtain",
                        "obtain(): node://"+key+"/EMS",
                        params, "String", MBeanOperationInfo.ACTION);
                operationInfoList.add(operationInfo);
            }




        }

        dOperations = new MBeanOperationInfo[operationInfoList.size()];
        for (int i = 0; i < operationInfoList.size(); i++) {
            dOperations[i] = operationInfoList.get(i);
        }

//        dAttributes[0] = new MBeanAttributeInfo("State", "java.lang.String",
//                "State: state string.", true, false, false);
//        dAttributes[1] = new MBeanAttributeInfo(
//                "NbChanges",
//                "java.lang.Integer",
//                "NbChanges: number of times the State string has been changed.",
//                true, false, false);
        Constructor[] constructors = this.getClass().getConstructors();
        dConstructors[0] = new MBeanConstructorInfo(
                "SimpleDynamic(): Constructs a SimpleDynamic object",
                constructors[0]);
    //    MBeanParameterInfo[] params = null;
    //    dOperations = ( MBeanOperationInfo[] )asArray(operationInfoList);
        dMBeanInfo = new MBeanInfo(dClassName, dDescription, dAttributes,
                dConstructors, dOperations, new MBeanNotificationInfo[0]);
        return dMBeanInfo;
    }

    private static Object[] asArray(List l ) {
        Object[] array = new Object[l.size()];
        for (int i = 0; i < l.size(); i++) {
            array[i] = l.get(i);
        }
        return array;
    }

    public static void main(String[] args) {
        List<String> l = new ArrayList();
        l.add("adsf");
        String[] s = ( String[] )l.toArray();
        System.out.println("s = " + s);
    }

}
