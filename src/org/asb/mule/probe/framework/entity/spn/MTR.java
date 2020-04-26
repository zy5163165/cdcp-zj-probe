package org.asb.mule.probe.framework.entity.spn;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.alcatelsbell.nms.valueobject.BObject;

@Entity
@Table(name = "MTR")

public class MTR extends BObject {
	String rmUID;
	String nermUID;
	String eastPortrmUID;
	String westPortrmUID;
	String nodeID;
	String wtrTime;
	String reversionMode;
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
	public String getEastPortrmUID() {
		return eastPortrmUID;
	}
	public void setEastPortrmUID(String eastPortrmUID) {
		this.eastPortrmUID = eastPortrmUID;
	}
	public String getWestPortrmUID() {
		return westPortrmUID;
	}
	public void setWestPortrmUID(String westPortrmUID) {
		this.westPortrmUID = westPortrmUID;
	}
	public String getNodeID() {
		return nodeID;
	}
	public void setNodeID(String nodeID) {
		this.nodeID = nodeID;
	}
	public String getWtrTime() {
		return wtrTime;
	}
	public void setWtrTime(String wtrTime) {
		this.wtrTime = wtrTime;
	}
	public String getReversionMode() {
		return reversionMode;
	}
	public void setReversionMode(String reversionMode) {
		this.reversionMode = reversionMode;
	}

	
}
