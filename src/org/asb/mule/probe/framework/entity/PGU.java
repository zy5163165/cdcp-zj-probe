package org.asb.mule.probe.framework.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.alcatelsbell.nms.valueobject.BObject;

@Entity
@Table(name = "PGU")

public class PGU extends BObject {
	
	String rmUID;
	String grouprmUID;
	String portrmUID;
	String role;
	
	public String getRmUID() {
		return rmUID;
	}
	public void setRmUID(String rmUID) {
		this.rmUID = rmUID;
	}
	public String getGrouprmUID() {
		return grouprmUID;
	}
	public void setGrouprmUID(String grouprmUID) {
		this.grouprmUID = grouprmUID;
	}
	public String getPortrmUID() {
		return portrmUID;
	}
	public void setPortrmUID(String portrmUID) {
		this.portrmUID = portrmUID;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
