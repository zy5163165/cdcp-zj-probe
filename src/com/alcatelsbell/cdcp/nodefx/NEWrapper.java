package com.alcatelsbell.cdcp.nodefx;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.asb.mule.probe.framework.entity.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * Author: Ronnie.Chen
 * Date: 14-3-12
 * Time: 下午5:19
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class NEWrapper implements Serializable {
    private ManagedElement me;
    private List<Equipment> equipments;
    private List<EquipmentHolder> equipmentHolders;
    private List<PTP> ptps;
    private List<CTP> ctps;

    private HashMap attributes = new HashMap();

    public HashMap getAttributes() {
        return attributes;
    }

    public List<CTP> getCtps() {
        return ctps;
    }

    public void setCtps(List<CTP> ctps) {
        this.ctps = ctps;
    }

    public ManagedElement getMe() {
        return me;
    }

    public void setMe(ManagedElement me) {
        this.me = me;
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }

    public List<EquipmentHolder> getEquipmentHolders() {
        return equipmentHolders;
    }

    public void setEquipmentHolders(List<EquipmentHolder> equipmentHolders) {
        this.equipmentHolders = equipmentHolders;
    }

    public List<PTP> getPtps() {
        return ptps;
    }

    public void setPtps(List<PTP> ptps) {
        this.ptps = ptps;
    }
}
