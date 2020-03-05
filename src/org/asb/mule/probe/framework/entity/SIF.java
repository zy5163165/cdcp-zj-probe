package org.asb.mule.probe.framework.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.alcatelsbell.nms.valueobject.BObject;

@Entity
@Table(name = "SIF")

public class SIF extends BObject {
	
	String rmUID;
	String nermUID;
	
//	String aEndPortrmUID1;
//	String zEndPortrmUID1;
//	String aEndCtprmUID1;
//	String zEndCtprmUID1;
//	String aEndPortrmUID2;
//	String zEndPortrmUID2;
//	String aEndCtprmUID2;
//	String zEndCtprmUID2;
	
	String aEndPort1rmUID;
	String zEndPort1rmUID;
	String aEndCtp1rmUID;
	String zEndCtp1rmUID;
	String aEndPort2rmUID;
	String zEndPort2rmUID;
	String aEndCtp2rmUID;
	String zEndCtp2rmUID;
	
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
	
	public String getaEndPort1rmUID() {
		return aEndPort1rmUID;
	}
	public void setaEndPort1rmUID(String aEndPort1rmUID) {
		this.aEndPort1rmUID = aEndPort1rmUID;
	}
	public String getzEndPort1rmUID() {
		return zEndPort1rmUID;
	}
	public void setzEndPort1rmUID(String zEndPort1rmUID) {
		this.zEndPort1rmUID = zEndPort1rmUID;
	}
	public String getaEndCtp1rmUID() {
		return aEndCtp1rmUID;
	}
	public void setaEndCtp1rmUID(String aEndCtp1rmUID) {
		this.aEndCtp1rmUID = aEndCtp1rmUID;
	}
	public String getzEndCtp1rmUID() {
		return zEndCtp1rmUID;
	}
	public void setzEndCtp1rmUID(String zEndCtp1rmUID) {
		this.zEndCtp1rmUID = zEndCtp1rmUID;
	}
	public String getaEndPort2rmUID() {
		return aEndPort2rmUID;
	}
	public void setaEndPort2rmUID(String aEndPort2rmUID) {
		this.aEndPort2rmUID = aEndPort2rmUID;
	}
	public String getzEndPort2rmUID() {
		return zEndPort2rmUID;
	}
	public void setzEndPort2rmUID(String zEndPort2rmUID) {
		this.zEndPort2rmUID = zEndPort2rmUID;
	}
	public String getaEndCtp2rmUID() {
		return aEndCtp2rmUID;
	}
	public void setaEndCtp2rmUID(String aEndCtp2rmUID) {
		this.aEndCtp2rmUID = aEndCtp2rmUID;
	}
	public String getzEndCtp2rmUID() {
		return zEndCtp2rmUID;
	}
	public void setzEndCtp2rmUID(String zEndCtp2rmUID) {
		this.zEndCtp2rmUID = zEndCtp2rmUID;
	}
	
//	public String getaEndPortrmUID1() {
//		return aEndPortrmUID1;
//	}
//	public void setaEndPortrmUID1(String aEndPortrmUID1) {
//		this.aEndPortrmUID1 = aEndPortrmUID1;
//	}
//	public String getzEndPortrmUID1() {
//		return zEndPortrmUID1;
//	}
//	public void setzEndPortrmUID1(String zEndPortrmUID1) {
//		this.zEndPortrmUID1 = zEndPortrmUID1;
//	}
//	public String getaEndCtprmUID1() {
//		return aEndCtprmUID1;
//	}
//	public void setaEndCtprmUID1(String aEndCtprmUID1) {
//		this.aEndCtprmUID1 = aEndCtprmUID1;
//	}
//	public String getzEndCtprmUID1() {
//		return zEndCtprmUID1;
//	}
//	public void setzEndCtprmUID1(String zEndCtprmUID1) {
//		this.zEndCtprmUID1 = zEndCtprmUID1;
//	}
//	public String getaEndPortrmUID2() {
//		return aEndPortrmUID2;
//	}
//	public void setaEndPortrmUID2(String aEndPortrmUID2) {
//		this.aEndPortrmUID2 = aEndPortrmUID2;
//	}
//	public String getzEndPortrmUID2() {
//		return zEndPortrmUID2;
//	}
//	public void setzEndPortrmUID2(String zEndPortrmUID2) {
//		this.zEndPortrmUID2 = zEndPortrmUID2;
//	}
//	public String getaEndCtprmUID2() {
//		return aEndCtprmUID2;
//	}
//	public void setaEndCtprmUID2(String aEndCtprmUID2) {
//		this.aEndCtprmUID2 = aEndCtprmUID2;
//	}
//	public String getzEndCtprmUID2() {
//		return zEndCtprmUID2;
//	}
//	public void setzEndCtprmUID2(String zEndCtprmUID2) {
//		this.zEndCtprmUID2 = zEndCtprmUID2;
//	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	
}
