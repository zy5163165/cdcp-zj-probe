package org.asb.mule.probe.framework.entity.spn;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.alcatelsbell.nms.valueobject.BObject;

@Entity
@Table(name = "L3T")

public class L3T extends BObject {
	String rmUID;
	String tunnelrmUID;
	String isTunnelGroup;
	public String getRmUID() {
		return rmUID;
	}
	public void setRmUID(String rmUID) {
		this.rmUID = rmUID;
	}
	public String getTunnelrmUID() {
		return tunnelrmUID;
	}
	public void setTunnelrmUID(String tunnelrmUID) {
		this.tunnelrmUID = tunnelrmUID;
	}
	public String getIsTunnelGroup() {
		return isTunnelGroup;
	}
	public void setIsTunnelGroup(String isTunnelGroup) {
		this.isTunnelGroup = isTunnelGroup;
	}

	
}
