package org.asb.mule.probe.framework.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.alcatelsbell.nms.valueobject.BObject;

@Entity
@Table(name = "SNT")

public class SNT extends BObject {
	
	String rmUID;
	String direction;
	String routingGroup;
	String routingNo;
	String aEndPortrmUID;
	String aEndCtprmUID;
	String zEndPortrmUID;
	String zEndCtprmUID;
	String nermUID;
	String role;
	String type;
	String name;
	
	public String getRmUID() {
		return rmUID;
	}
	public void setRmUID(String rmUID) {
		this.rmUID = rmUID;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getRoutingGroup() {
		return routingGroup;
	}
	public void setRoutingGroup(String routingGroup) {
		this.routingGroup = routingGroup;
	}
	public String getRoutingNo() {
		return routingNo;
	}
	public void setRoutingNo(String routingNo) {
		this.routingNo = routingNo;
	}
	public String getaEndPortrmUID() {
		return aEndPortrmUID;
	}
	public void setaEndPortrmUID(String aEndPortrmUID) {
		this.aEndPortrmUID = aEndPortrmUID;
	}
	public String getaEndCtprmUID() {
		return aEndCtprmUID;
	}
	public void setaEndCtprmUID(String aEndCtprmUID) {
		this.aEndCtprmUID = aEndCtprmUID;
	}
	public String getzEndPortrmUID() {
		return zEndPortrmUID;
	}
	public void setzEndPortrmUID(String zEndPortrmUID) {
		this.zEndPortrmUID = zEndPortrmUID;
	}
	public String getzEndCtprmUID() {
		return zEndCtprmUID;
	}
	public void setzEndCtprmUID(String zEndCtprmUID) {
		this.zEndCtprmUID = zEndCtprmUID;
	}
	public String getNermUID() {
		return nermUID;
	}
	public void setNermUID(String nermUID) {
		this.nermUID = nermUID;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
