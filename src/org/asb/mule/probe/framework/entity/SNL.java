package org.asb.mule.probe.framework.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.alcatelsbell.nms.valueobject.BObject;

@Entity
@Table(name = "SNL")

public class SNL extends BObject {
	
	String rmUID;
	String nativeName;
	String direction;
	String activeState;
	String layer;
	String rate;
	String aEndCtprmUID1;
	String aEndPortrmUID1;
	String aEndCtprmUID2;
	String aEndPortrmUID2;
	String aEndNermUID;
	String zEndCtprmUID1;
	String zEndPortrmUID1;
	String zEndCtprmUID2;
	String zEndPortrmUID2; 
	String zEndNermUID;
	String protectionType;
	
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
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getActiveState() {
		return activeState;
	}
	public void setActiveState(String activeState) {
		this.activeState = activeState;
	}
	public String getLayer() {
		return layer;
	}
	public void setLayer(String layer) {
		this.layer = layer;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getaEndCtprmUID1() {
		return aEndCtprmUID1;
	}
	public void setaEndCtprmUID1(String aEndCtprmUID1) {
		this.aEndCtprmUID1 = aEndCtprmUID1;
	}
	public String getaEndPortrmUID1() {
		return aEndPortrmUID1;
	}
	public void setaEndPortrmUID1(String aEndPortrmUID1) {
		this.aEndPortrmUID1 = aEndPortrmUID1;
	}
	public String getaEndCtprmUID2() {
		return aEndCtprmUID2;
	}
	public void setaEndCtprmUID2(String aEndCtprmUID2) {
		this.aEndCtprmUID2 = aEndCtprmUID2;
	}
	public String getaEndPortrmUID2() {
		return aEndPortrmUID2;
	}
	public void setaEndPortrmUID2(String aEndPortrmUID2) {
		this.aEndPortrmUID2 = aEndPortrmUID2;
	}
	public String getaEndNermUID() {
		return aEndNermUID;
	}
	public void setaEndNermUID(String aEndNermUID) {
		this.aEndNermUID = aEndNermUID;
	}
	public String getzEndCtprmUID1() {
		return zEndCtprmUID1;
	}
	public void setzEndCtprmUID1(String zEndCtprmUID1) {
		this.zEndCtprmUID1 = zEndCtprmUID1;
	}
	public String getzEndPortrmUID1() {
		return zEndPortrmUID1;
	}
	public void setzEndPortrmUID1(String zEndPortrmUID1) {
		this.zEndPortrmUID1 = zEndPortrmUID1;
	}
	public String getzEndCtprmUID2() {
		return zEndCtprmUID2;
	}
	public void setzEndCtprmUID2(String zEndCtprmUID2) {
		this.zEndCtprmUID2 = zEndCtprmUID2;
	}
	public String getzEndPortrmUID2() {
		return zEndPortrmUID2;
	}
	public void setzEndPortrmUID2(String zEndPortrmUID2) {
		this.zEndPortrmUID2 = zEndPortrmUID2;
	}
	public String getzEndNermUID() {
		return zEndNermUID;
	}
	public void setzEndNermUID(String zEndNermUID) {
		this.zEndNermUID = zEndNermUID;
	}
	public String getProtectionType() {
		return protectionType;
	}
	public void setProtectionType(String protectionType) {
		this.protectionType = protectionType;
	}
	
}
