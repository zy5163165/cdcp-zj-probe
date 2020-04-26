package org.asb.mule.probe.framework.entity.spn;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.alcatelsbell.nms.valueobject.BObject;

@Entity
@Table(name = "MGP")

public class MGP extends BObject {
	String rmUID;
	String nermUID;
	String groupNo;
	String bandwidth;
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
	public String getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}
	public String getBandwidth() {
		return bandwidth;
	}
	public void setBandwidth(String bandwidth) {
		this.bandwidth = bandwidth;
	}

	
}
