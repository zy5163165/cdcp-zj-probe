package org.asb.mule.probe.framework.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.alcatelsbell.nms.valueobject.BObject;

@Entity
@Table(name = "SBN")

public class SBN extends BObject {
	
	String rmUID;
	String nativeName;
	String parentSubnetrmUID;
	String xPos;
	String yPos;

	public String getRmUID() {
		return rmUID;
	}
	public void setRmUID(String rmUID) {
		this.rmUID = rmUID;
	}
	public String getNativeName() {
		return nativeName;
	}
	public void setNativeName(String nativeName) {
		this.nativeName = nativeName;
	}
	public String getParentSubnetrmUID() {
		return parentSubnetrmUID;
	}
	public void setParentSubnetrmUID(String parentSubnetrmUID) {
		this.parentSubnetrmUID = parentSubnetrmUID;
	}
	public String getxPos() {
		return xPos;
	}
	public void setxPos(String xPos) {
		this.xPos = xPos;
	}
	public String getyPos() {
		return yPos;
	}
	public void setyPos(String yPos) {
		this.yPos = yPos;
	}
	
}
