package org.asb.mule.probe.framework.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.alcatelsbell.nms.valueobject.BObject;

@Entity
@Table(name = "SIF")

public class SIF extends BObject {
	
	String rmUID;
	String nermUID;
	
	String aEndPortrmUID1;
	String zEndPortrmUID1;
	String aEndCtprmUID1;
	String zEndCtprmUID1;
	String aEndPortrmUID2;
	String zEndPortrmUID2;
	String aEndCtprmUID2;
	String zEndCtprmUID2;
	
	String direction;
	
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
	
	public String getaEndPortrmUID1() {
		return aEndPortrmUID1;
	}
	public void setaEndPortrmUID1(String aEndPortrmUID1) {
		this.aEndPortrmUID1 = aEndPortrmUID1;
	}
	public String getzEndPortrmUID1() {
		return zEndPortrmUID1;
	}
	public void setzEndPortrmUID1(String zEndPortrmUID1) {
		this.zEndPortrmUID1 = zEndPortrmUID1;
	}
	public String getaEndCtprmUID1() {
		return aEndCtprmUID1;
	}
	public void setaEndCtprmUID1(String aEndCtprmUID1) {
		this.aEndCtprmUID1 = aEndCtprmUID1;
	}
	public String getzEndCtprmUID1() {
		return zEndCtprmUID1;
	}
	public void setzEndCtprmUID1(String zEndCtprmUID1) {
		this.zEndCtprmUID1 = zEndCtprmUID1;
	}
	public String getaEndPortrmUID2() {
		return aEndPortrmUID2;
	}
	public void setaEndPortrmUID2(String aEndPortrmUID2) {
		this.aEndPortrmUID2 = aEndPortrmUID2;
	}
	public String getzEndPortrmUID2() {
		return zEndPortrmUID2;
	}
	public void setzEndPortrmUID2(String zEndPortrmUID2) {
		this.zEndPortrmUID2 = zEndPortrmUID2;
	}
	public String getaEndCtprmUID2() {
		return aEndCtprmUID2;
	}
	public void setaEndCtprmUID2(String aEndCtprmUID2) {
		this.aEndCtprmUID2 = aEndCtprmUID2;
	}
	public String getzEndCtprmUID2() {
		return zEndCtprmUID2;
	}
	public void setzEndCtprmUID2(String zEndCtprmUID2) {
		this.zEndCtprmUID2 = zEndCtprmUID2;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	
}
