package com.alcatelsbell.cdcp.nodefx;

import com.alcatelsbell.nms.common.SysUtil;
import com.alcatelsbell.nms.db.components.service.DBUtil;
import com.alcatelsbell.nms.db.components.service.JPASupport;
import com.alcatelsbell.nms.db.components.service.JPASupportFactory;
import com.alcatelsbell.nms.db.components.service.JPAUtil;
import com.alcatelsbell.nms.valueobject.BObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.asb.mule.probe.framework.entity.ManagedElement;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author: Ronnie.Chen
 * Date: 2014/11/9
 * Time: 12:39
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class NodeDBSqliteImpl extends NodeDB {
    private Log logger = LogFactory.getLog(getClass());
    private HashSet<Class> cachedEntities = new HashSet<Class>();
    private ConcurrentHashMap<Class,HashMap<String,BObject>> dataCache = new ConcurrentHashMap<Class, HashMap<String,BObject>>();

    public void addCacheEntity(Class cls) {
        cachedEntities.add(cls);
    }


    public void addCacheEntities(Class... cls) {
        cachedEntities.addAll(Arrays.asList(cls));
    }

    private JPASupport jpaSupport = null;

    public NodeDBSqliteImpl() {
        jpaSupport = JPASupportFactory.createSqliteJPASupport("node.db");


        for (Class cachedEntity : cachedEntities) {
            List allObjects = null;

            try {
                allObjects = JPAUtil.getInstance().findAllObjects(jpaSupport, cachedEntity);
                logger.info("Loading cache : "+cachedEntity+ " size = "+(allObjects == null ? null: allObjects.size()));
            } catch (Exception e) {
                logger.error(e, e);
            }
            if (allObjects != null)
                dataCache.put(cachedEntity,toMap(allObjects));
        }
//        List<Object[]> list = DBUtil.getInstance().querySQL(jpaSupport, "select * from sqlite_master where type='table'");
//        for (Object[] row : list) {
//            String tableName = (String)row[1];
//            JPAUtil.getInstance().querySQL(jpaSupport,"select * from "+tableName,)
//        }
    }

    private HashMap<String,BObject> toMap(List<BObject> objects) {
        HashMap<String,BObject> map = new HashMap<String, BObject>();
        if (objects != null) {
            for (BObject object : objects) {
                map.put(object.getDn(),object);
            }
        }
        return map;
    }
    @Override
    public BObject insert(BObject bObject) throws Exception {
        jpaSupport.begin();
        bObject = JPAUtil.getInstance().createObject(jpaSupport, -1, bObject);
        jpaSupport.end();
        addToCache(bObject.getClass(),bObject);
        return bObject;
    }
    @Override
    public void insert(List<BObject> bObjects) throws Exception {
        jpaSupport.begin();
        for (BObject bObject : bObjects) {
            JPAUtil.getInstance().createObject(jpaSupport,-1,bObject);
        }
        jpaSupport.end();
        addToCache(bObjects.getClass(),bObjects);
    }
    @Override
    public void delete(BObject bObject) throws Exception {
        jpaSupport.begin();
        JPAUtil.getInstance().removeObject(jpaSupport, -1, bObject);
        jpaSupport.end();
        HashMap<String,BObject> list = dataCache.get(bObject.getClass());
        if (list != null) list.remove(bObject.getDn());
    }

    @Override
    public BObject storeObjectByDn(BObject bObject) throws Exception {
        jpaSupport.begin();
        bObject = JPAUtil.getInstance().storeObjectByDn(jpaSupport, -1, bObject);
        jpaSupport.end();
        HashMap<String,BObject> list = dataCache.get(bObject.getClass());
        if (list != null) list.put(bObject.getDn(), bObject);
        return bObject;
    }
    @Override
    public BObject readObjectByDN(Class cls,String dn) {
        HashMap<String,BObject> list = dataCache.get(cls);
        if (list != null) return list.get(dn);
        return null;
    }
    @Override
    public List<BObject> readAll(Class cls) {
        HashMap<String,BObject> list = dataCache.get(cls);
        return list != null ? new ArrayList<BObject>(list.values()) : null;
    }



    private void addToCache(Class cls,List<BObject> objects) {
        HashMap<String,BObject> list = dataCache.get(cls);
        if (list == null) {
            list = new HashMap<String,BObject>();
            dataCache.put(cls,list);
        }
        list.putAll(toMap(objects));
    }
    private void addToCache(Class cls, BObject objects) {
        if (objects != null) {
            HashMap<String, BObject> list = dataCache.get(cls);
            if (list == null) {
                list = new HashMap<String, BObject>();
                dataCache.put(cls, list);
            }
            list.put(objects.getDn(), objects);
        }
    }


    public static void main(String[] args) throws Exception {

        new NodeDBSqliteImpl();
        JPASupport jpaSupport = JPASupportFactory.createSqliteJPASupport(":memory:");
        jpaSupport.begin();

        for (int i = 0; i < 100; i++) {
            ManagedElement me = new ManagedElement();
            me.setDn(SysUtil.nextDN());
            me.setNativeEMSName(i+"");
            JPAUtil.getInstance().createObject(jpaSupport,-1,me);
        }
        jpaSupport.end();


        List allObjects = JPAUtil.getInstance().findAllObjects(jpaSupport, ManagedElement.class);
        System.out.println("allObjects = " + allObjects);



    }



}
