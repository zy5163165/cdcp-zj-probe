package org.asb.mule.probe.framework.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Index;

import com.alcatelsbell.nms.valueobject.BObject;

@Entity
@Table(name = "CTP2")

public class CTP2 extends BObject {
	
	@Index(name = "index", columnNames = "relatedPortrmUID,ctpName")
	String relatedPortrmUID;
	String ctpName;
	String rmUID;
	String relatedNErmUID;
	String nativeName;
	String ctpType;
	String frequency;
	String direction;
	
	public String getRmUID() {
		return rmUID;
	}
	public void setRmUID(String rmUID) {
		this.rmUID = rmUID;
	}
	public String getRelatedNErmUID() {
		return relatedNErmUID;
	}
	public void setRelatedNErmUID(String relatedNErmUID) {
		this.relatedNErmUID = relatedNErmUID;
	}
	public String getRelatedPortrmUID() {
		return relatedPortrmUID;
	}
	public void setRelatedPortrmUID(String relatedPortrmUID) {
		this.relatedPortrmUID = relatedPortrmUID;
	}
	public String getNativeName() {
		return nativeName;
	}
	public void setNativeName(String nativeName) {
		this.nativeName = nativeName;
	}
	public String getCtpName() {
		return ctpName;
	}
	public void setCtpName(String ctpName) {
		this.ctpName = ctpName;
	}
	public String getCtpType() {
		return ctpType;
	}
	public void setCtpType(String ctpType) {
		this.ctpType = ctpType;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	

}
