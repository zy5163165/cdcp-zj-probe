package com.alcatelsbell.cdcp.nodefx;

import com.alcatelsbell.nms.valueobject.sys.Ems;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author: Ronnie.Chen
 * Date: 14-5-8
 * Time: 下午2:13
 * rongrong.chen@alcatel-sbell.com.cn
 *
 * 用来缓存Node本地的Ems信息，会在server广播ems列表时更新，但未必一定有数据
 */
public class EmsCache {
    private Log logger = LogFactory.getLog(getClass());
    private static EmsCache cache = new EmsCache();
    private EmsCache () {

    }
    public static EmsCache getCache() {
        return cache;
    }

    private ConcurrentHashMap<String,Ems> emsMap = new ConcurrentHashMap<String, Ems>();

    /**
     *
     * @param emsList
     * @return   List<Ems>[] 新增Ems集合，版本被更新的Ems集合，被删除Ems集合
     */
    public List[] update(List<Ems> emsList) {
        List<Ems> updateList = new ArrayList<Ems>();
        List<Ems> newList = new ArrayList<Ems>();
        List<Ems> removeList = new ArrayList<Ems>();

        removeList.addAll(emsMap.values());

        if (emsList != null) {
            for (Ems ems : emsList) {
                Ems oldEms = emsMap.get(ems.getDn());
                if (oldEms == null) {
                    newList.add(ems);
                } else if (oldEms.getVersion() != null && ems.getVersion() != null && ems.getVersion() > oldEms.getVersion()) {
                    updateList.add(ems);
                } else if (oldEms.getAdditionalinfo() != null && !oldEms.getAdditionalinfo().equals(ems.getAdditionalinfo())) {
                    updateList.add(ems);
                }

                emsMap.put(ems.getDn(),ems);
                removeList.remove(oldEms);
            }
        }

        return new List[]{newList,updateList,removeList};
    }

    public Ems getEms(String dn) {
        return emsMap.get(dn);
    }

}
