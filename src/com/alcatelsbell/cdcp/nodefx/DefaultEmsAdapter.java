package com.alcatelsbell.cdcp.nodefx;

import com.alcatelsbell.nms.valueobject.sys.Ems;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.asb.mule.probe.framework.entity.DeviceInfo;

import java.util.List;

/**
 * Author: Ronnie.Chen
 * Date: 2015/3/17
 * Time: 10:53
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class DefaultEmsAdapter implements EmsAdapter{
    private Log logger = LogFactory.getLog(getClass());

    @Override
    public void newEms(Ems ems) throws NodeException {

    }

    @Override
    public List<DeviceInfo> listDevices(Ems ems) throws NodeException {
        return null;
    }

    @Override
    public void removeEms(Ems ems) throws NodeException {

    }

    @Override
    public void updateEms(Ems ems) throws NodeException {

    }

    @Override
    public boolean testEms(Ems ems) throws NodeException {
        return false;
    }

    @Override
    public LifecycleState getState(Ems ems) throws NodeException {
        return null;
    }

    @Override
    public void executeJob(EmsJob ems) throws NodeException {

    }

    @Override
    public String getType() {
        return null;
    }
}
