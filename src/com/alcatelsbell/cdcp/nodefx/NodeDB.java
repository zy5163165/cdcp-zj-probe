package com.alcatelsbell.cdcp.nodefx;

import com.alcatelsbell.nms.valueobject.BObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

/**
 * Author: Ronnie.Chen
 * Date: 2014/11/9
 * Time: 12:39
 * rongrong.chen@alcatel-sbell.com.cn
 */
public abstract class NodeDB {
    private Log logger = LogFactory.getLog(getClass());

    public abstract BObject insert(BObject bObject) throws Exception;

    public abstract void insert(List<BObject> bObjects) throws Exception;

    public abstract void delete(BObject bObject) throws Exception;

    public abstract BObject storeObjectByDn(BObject bObject) throws Exception;

    public abstract BObject readObjectByDN(Class cls, String dn);

    public abstract List<BObject> readAll(Class cls);
}
