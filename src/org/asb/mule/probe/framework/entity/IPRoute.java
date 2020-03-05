package org.asb.mule.probe.framework.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.alcatelsbell.nms.valueobject.BObject;

@Entity
@Table(name = "IPRoute")

public class IPRoute extends BObject{

	private String trafficTrunkDn;
    private String aend;
    private String zend;
    private String emsName;

    public String getEmsName() {
        return emsName;
    }

    public void setEmsName(String emsName) {
        this.emsName = emsName;
    }

    public String getAend() {
        return aend;
    }

    public void setAend(String aend) {
        this.aend = aend;
    }

    public String getZend() {
        return zend;
    }

    public void setZend(String zend) {
        this.zend = zend;
    }

    public String getTrafficTrunkDn() {
		return trafficTrunkDn;
	}
	public void setTrafficTrunkDn(String trafficTrunkDn) {
		this.trafficTrunkDn = trafficTrunkDn;
	}
	public String getIpCrossconnectionDn() {
		return ipCrossconnectionDn;
	}
	public void setIpCrossconnectionDn(String ipCrossconnectionDn) {
		this.ipCrossconnectionDn = ipCrossconnectionDn;
	}
	private String ipCrossconnectionDn;
}
