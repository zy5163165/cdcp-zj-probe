package org.asb.mule.probe.framework.entity.spn;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.alcatelsbell.nms.valueobject.BObject;

@Entity
@Table(name = "L3P")

public class L3P extends BObject {
	String rmUID;
	String nermUID;
	String portrmUID;
	String servicermUID;
	String CVID;
	String SVID;
	String IPAddress;
	String IPMask;
	public String getRmUID() {
		return rmUID;
	}
	public void setRmUID(String rmUID) {
		this.rmUID = rmUID;
	}
	public String getNermUID() {
		return nermUID;
	}
	public void setNermUID(String nermUID) {
		this.nermUID = nermUID;
	}
	public String getPortrmUID() {
		return portrmUID;
	}
	public void setPortrmUID(String portrmUID) {
		this.portrmUID = portrmUID;
	}
	public String getServicermUID() {
		return servicermUID;
	}
	public void setServicermUID(String servicermUID) {
		this.servicermUID = servicermUID;
	}
	public String getCVID() {
		return CVID;
	}
	public void setCVID(String cVID) {
		CVID = cVID;
	}
	public String getSVID() {
		return SVID;
	}
	public void setSVID(String sVID) {
		SVID = sVID;
	}
	public String getIPAddress() {
		return IPAddress;
	}
	public void setIPAddress(String iPAddress) {
		IPAddress = iPAddress;
	}
	public String getIPMask() {
		return IPMask;
	}
	public void setIPMask(String iPMask) {
		IPMask = iPMask;
	}

	
}
