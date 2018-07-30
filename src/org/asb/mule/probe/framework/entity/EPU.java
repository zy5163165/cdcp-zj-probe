package org.asb.mule.probe.framework.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.alcatelsbell.nms.valueobject.BObject;

@Entity
@Table(name = "EPU")

public class EPU extends BObject {
	
	String rmUID;
	String grouprmUID;
	String cardrmUID;
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
	public String getCardrmUID() {
		return cardrmUID;
	}
	public void setCardrmUID(String cardrmUID) {
		this.cardrmUID = cardrmUID;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
