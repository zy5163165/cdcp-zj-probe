package com.alcatelsbell.cdcp.nodefx;


import com.alcatelsbell.nms.valueobject.sys.Ems;
import org.asb.mule.probe.framework.entity.DeviceInfo;

import java.io.Serializable;
import java.net.URI;
import java.util.List;

/**
 * Author: Ronnie.Chen
 * Date: 13-8-31
 * Time: 下午5:33
 * rongrong.chen@alcatel-sbell.com.cn
 */
public interface NodeAdminMBean {
    public void newEms(Ems ems) throws NodeException;

    public void removeEms(Ems ems) throws NodeException;

    public void updateEms(Ems ems) throws NodeException;

    public boolean testEms(Ems ems) throws NodeException;

    public LifecycleState getState(Ems ems) throws NodeException;

    public void executeJob(EmsJob ems) throws NodeException;

    public Serializable pullObject(String token) throws NodeException;

    public List<DeviceInfo> listDevices(Ems ems) throws NodeException;
    public Serializable obtain(Ems ems,URI uri) throws NodeException;
    public Serializable obtain(Ems ems,String uri) throws NodeException;

}
