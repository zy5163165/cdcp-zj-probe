package com.alcatelsbell.cdcp.nodefx;

import com.alcatelsbell.nms.db.components.service.JPASupport;
import com.alcatelsbell.nms.db.components.service.JPASupportFactory;
import com.alcatelsbell.nms.util.ObjectUtil;
import com.alcatelsbell.nms.util.SortUtil;
import com.alcatelsbell.nms.valueobject.BObject;
import com.alcatelsbell.nms.valueobject.sys.Ems;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.asb.mule.probe.framework.entity.*;
import org.asb.mule.probe.framework.service.NbiService;
import org.hibernate.Session;
import org.hibernate.ejb.HibernateEntityManager;
import org.hibernate.jdbc.Work;

import javax.management.*;
import javax.persistence.EntityManager;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Author: Ronnie.Chen
 * Date: 2015/4/9
 * Time: 16:26
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class KeepAliveConnectionDynamicMBean implements DynamicMBean {
    private Log logger = LogFactory.getLog(getClass());

    CorbaEmsAdapterTemplate emsAdapter = null;
    String emsDn = null;

    public KeepAliveConnectionDynamicMBean(CorbaEmsAdapterTemplate emsAdapter,String emsDn) {
        this.emsAdapter = emsAdapter;
        this.emsDn = emsDn;
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
        if (attribute_name.equals("state")) {
            KeepAliveConnection connection = emsAdapter.getConnectionManager().getConnection(emsDn);
            if (connection == null)
                return false;
            return connection.checkConnection();
        }


        // 如果属性不可识别,抛出异常
        throw (new AttributeNotFoundException("Cannot find " + attribute_name
                + " attribute in " + dClassName));
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

    private String resultToString(Object result) {
        if (result == null) return "-null-";
        String key ="result_"+ System.currentTimeMillis() ;
        try {
            if (result instanceof Serializable)
                ObjectUtil.saveObject(key,result);
        } catch (Exception e) {
            logger.error(e, e);
        }
        if (result instanceof BObject) {
            return key+"\r\n"+((BObject) result).getDn();
        } else if (result instanceof Collection) {
            StringBuffer sb = new StringBuffer(key+"\r\n");
            sb.append(" size = "+((Collection) result).size()+"\r\n");
            for (Object o : (Collection) result) {
                if (o instanceof BObject)
                    sb.append(((BObject) o).getDn()+"<br>");
                else
                    sb.append(o.toString());

                if (o instanceof ManagedElement)
                    sb.append(((ManagedElement) o).getNativeEMSName()+"<br>");

                if (o instanceof EquipmentHolder)
                    sb.append(((EquipmentHolder) o).getNativeEMSName()+"<br>");

                if (o instanceof Equipment)
                    sb.append(((Equipment) o).getNativeEMSName()+"<br>");

                if (o instanceof PTP)
                    sb.append(((PTP) o).getNativeEMSName()+"<br>");

                if (o instanceof SubnetworkConnection)
                    sb.append(((SubnetworkConnection) o).getNativeEMSName()+"<br>");

                if (o instanceof FlowDomainFragment)
                    sb.append(((FlowDomainFragment) o).getNativeEMSName()+"<br>");

            }
            sb.append(" size = "+((Collection) result).size());
            return sb.toString();
        }
        return key+"\r\n"+result.toString();

    }
    @Override
    public Object invoke(String actionName, Object[] params, String[] signature) throws MBeanException, ReflectionException {
        KeepAliveConnection connection = emsAdapter.getConnectionManager().getConnection(emsDn);
        if (actionName.equals("getCacheObject")) {
            Object param = params[0];
            Object object = ObjectUtil.readObject((String) param);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(baos);
                objectOutputStream.writeObject(object);
                return baos.toByteArray();

            } catch (IOException e) {
                logger.error(e, e);
            } finally {
                try {
                    baos.close();
                } catch (IOException e) {
                    logger.error(e, e);
                }
            }


        } else if (actionName.contains("__")) {
            File dbFile = dbFiles.get(actionName);
            return query(JPASupportFactory.createSqliteJPASupport(dbFile.getAbsolutePath()),(String)params[0]);
        }

        else if (connection != null && connection instanceof CorbaEmsAdapterTemplate.CorbaKeepAliveConnection) {
            NbiService nbiService = ((CorbaEmsAdapterTemplate.CorbaKeepAliveConnection) connection).getNbiService();
            Class<? extends NbiService> cls = nbiService.getClass();

            try {
                if (params == null || params.length == 0) {
                    Method method = cls.getMethod(actionName);
                    Object result = method.invoke(nbiService);
                    return resultToString(result);
                }  else if (params.length == 1) {
                    Method method = cls.getMethod(actionName,String.class);
                    Object result = method.invoke(nbiService,params);
                    return resultToString(result);
                }
            } catch (NoSuchMethodException e) {
                logger.error(e, e);
            } catch (IllegalAccessException e) {
                logger.error(e, e);
            } catch (InvocationTargetException e) {
                logger.error(e, e);
            }
        }


        return null;
    }

    private String query(JPASupport jpaSupport,final String sql) {

        final StringBuffer sb = new StringBuffer();
        try {
            EntityManager entityManager = jpaSupport.getEntityManager();
            if (entityManager instanceof HibernateEntityManager) {
                Session session = ((HibernateEntityManager) entityManager).getSession();

                session.doWork(new Work() {
                    @Override
                    public void execute(Connection conn) throws SQLException {
                        PreparedStatement stat = conn.prepareStatement(sql);
                        ResultSet resultSet = stat.executeQuery();

                        int columnCount = resultSet.getMetaData().getColumnCount();
                        for (int i = 1; i <= columnCount; i++) {
                            String columnName = resultSet.getMetaData().getColumnName(i);
                            sb.append("[" + i + "]" + columnName + " ");

                        }
                        sb.append("<br>");
                        int row = 1;
                        while (resultSet.next() && row < 10000) {
                            sb.append(row++ + " : ");
                            for (int i = 1; i <= columnCount; i++) {
                                Object object = resultSet.getObject(i);
                                //   System.out.print(row++ + " : ");
                                sb.append("[" + i + "]" + object);
                            }
                            sb.append("<br>");
                            sb.append("-----------------------------------------------------------------------<br>");
                        }

                        resultSet.close();
                        stat.close();                    }
                });
            } else {
                throw new Exception("Not Hibernate Entity Manager :" + entityManager);
            }
        } catch ( Exception e) {
            return e.getMessage();
        }
        return sb.toString();

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



    private List<File> searchFiles(String emsdn,File rootDir) {
        if (!rootDir.exists()) return new ArrayList<File>();
        List<File> files = new ArrayList<File>();
        File[] fs = rootDir.listFiles();
        if (fs != null) {
            for (File f : fs) {
                if (f.isDirectory() && f.getName().equals(emsdn)) {
                    files.addAll(Arrays.asList(f.listFiles()));
                } else if (f.isDirectory()) {
                    files.addAll(searchFiles(emsdn, f));
                }
            }
        }

        return files;
    }

    private HashMap<String,File> dbFiles = new HashMap<String, File>();

    private MBeanInfo buildDynamicMBeanInfo() {
        dbFiles.clear();

        MBeanInfo dMBeanInfo = null;
        MBeanOperationInfo[] dOperations = null;
        MBeanConstructorInfo[] dConstructors = new MBeanConstructorInfo[1];
        HashMap<String, KeepAliveConnection> connections = emsAdapter.getConnectionManager().getConnections();
        Hashtable<String, Ems> emsTable = emsAdapter.getEmsTable();
        MBeanAttributeInfo[] dAttributes = new MBeanAttributeInfo[]
                {
                        new MBeanAttributeInfo("state", "java.lang.Boolean",
                                emsDn + " 连接状态 ", true, false, true)
                };
        List<MBeanOperationInfo> operationInfoList = new ArrayList<MBeanOperationInfo>();

        MBeanOperationInfo op =  new MBeanOperationInfo(
                "getCacheObject",
                "getCacheObject",
                new MBeanParameterInfo[]{new MBeanParameterInfo("para","java.lang.String","para")}
        , "byte[]", MBeanOperationInfo.ACTION);
        operationInfoList.add(op);

        KeepAliveConnection connection = emsAdapter.getConnectionManager().getConnection(emsDn);
       if (connection != null &&  connection instanceof CorbaEmsAdapterTemplate.CorbaKeepAliveConnection) {
           NbiService nbiService = ((CorbaEmsAdapterTemplate.CorbaKeepAliveConnection) connection).getNbiService();
           Class<? extends NbiService> cls = nbiService.getClass();
           Method[] methods = cls.getDeclaredMethods();
           for (Method method : methods) {
               if (method.getParameterTypes() == null || method.getParameterTypes().length == 0) {
                   MBeanOperationInfo operationInfo =  new MBeanOperationInfo(
                           method.getName(),
                           method.getName(),
                           new MBeanParameterInfo[0], "String", MBeanOperationInfo.ACTION);
                   operationInfoList.add(operationInfo);
               } else if (method.getParameterTypes().length == 1 && method.getParameterTypes()[0].equals(String.class)) {
                   MBeanParameterInfo[] params = new MBeanParameterInfo[]{new MBeanParameterInfo("para","java.lang.String","para")};
                   MBeanOperationInfo operationInfo =  new MBeanOperationInfo(
                           method.getName(),
                           method.getName(),
                           params, "String", MBeanOperationInfo.ACTION);
                   operationInfoList.add(operationInfo);
               }
           }
       }


        File dir = new File("/data/sqlitedb");

        List<File> dbs = searchFiles(emsDn, dir);
        SortUtil.sort(dbs, new SortUtil.CompareAdapter() {
            @Override
            public int compare(Object o1, Object o2) {
                return  (((File)o1).lastModified()  < ((File)o2).lastModified()) ? 1 : 0 ;
            }
        });
        int total = dbs.size() > 10 ? 10 : dbs.size();
        for (int i = total -1; i >= 0; i--) {
            File file = dbs.get(i);
            MBeanParameterInfo[] params = new MBeanParameterInfo[]{new MBeanParameterInfo("sql","java.lang.String","sql")};
            String methodName = file.getName() + "__" + (file.length() / (1024 * 1024)) +"M";
            methodName+= new SimpleDateFormat("_yyyyMMdd.HHmmss").format(new Date(file.lastModified()));
            MBeanOperationInfo operationInfo =  new MBeanOperationInfo(
                    methodName,
                    file.getAbsolutePath(),
                    params, "String", MBeanOperationInfo.ACTION);
            dbFiles.put(methodName,file);
            operationInfoList.add(operationInfo);
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
