package org.asb.mule.probe.framework.entity.spn;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.alcatelsbell.nms.valueobject.BObject;

@Entity
@Table(name = "PWT")

public class PWT extends BObject {
	String rmUID;
	String tunnelrmUID;
	String isTunnelGroup;
	String routingGroup;
	String number;
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
	public String getRoutingGroup() {
		return routingGroup;
	}
	public void setRoutingGroup(String routingGroup) {
		this.routingGroup = routingGroup;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}

	
}
