package com.alcatelsbell.cdcp.nodefx;

import com.alcatelsbell.nms.valueobject.sys.Ems;
import org.asb.mule.probe.framework.entity.DeviceInfo;

import java.util.List;

/**
 * Author: Ronnie.Chen
 * Date: 13-9-10
 * Time: 上午11:01
 * rongrong.chen@alcatel-sbell.com.cn
 */
public interface EmsAdapter {
    public void newEms(Ems ems) throws NodeException;
    public List<DeviceInfo> listDevices(Ems ems) throws NodeException;
    public void removeEms(Ems ems) throws NodeException;

    public void updateEms(Ems ems) throws NodeException;

    public boolean testEms(Ems ems) throws NodeException;

    public LifecycleState getState(Ems ems) throws NodeException;

    public void executeJob(EmsJob ems) throws NodeException;


    public String getType() ;
}
