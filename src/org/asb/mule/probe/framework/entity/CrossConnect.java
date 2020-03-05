package org.asb.mule.probe.framework.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.alcatelsbell.nms.valueobject.BObject;

@Entity
@Table(name = "CrossConnect")
public class CrossConnect extends BObject {
	private boolean active = false;
	private String direction = "";
	private String ccType = "";
	private String aEndNameList = "";
	private String zEndNameList = "";
	private String aEndTP = "";
	private String zEndTP = "";
	private String additionalInfo = "";

	private String parentDn = "";
	private String emsName = "";

	public String getParentDn() {
		return parentDn;
	}

	public void setParentDn(String parentDn) {
		this.parentDn = parentDn;
	}

	public String getEmsName() {
		return emsName;
	}

	public void setEmsName(String emsName) {
		this.emsName = emsName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getCcType() {
		return ccType;
	}

	public void setCcType(String ccType) {
		this.ccType = ccType;
	}

	public String getaEndNameList() {
		return aEndNameList;
	}

	public void setaEndNameList(String aEndNameList) {
		this.aEndNameList = aEndNameList;
	}

	public String getzEndNameList() {
		return zEndNameList;
	}

	public void setzEndNameList(String zEndNameList) {
		this.zEndNameList = zEndNameList;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public String getaEndTP() {
		return aEndTP;
	}

	public void setaEndTP(String aEndTP) {
		this.aEndTP = aEndTP;
	}

	public String getzEndTP() {
		return zEndTP;
	}

	public void setzEndTP(String zEndTP) {
		this.zEndTP = zEndTP;
	}

}
