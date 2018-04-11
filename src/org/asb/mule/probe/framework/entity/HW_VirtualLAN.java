package org.asb.mule.probe.framework.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.alcatelsbell.nms.valueobject.BObject;

@Entity
@Table(name = "HW_VirtualLAN")
public class HW_VirtualLAN extends BObject {

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserLabel() {
		return userLabel;
	}

	public void setUserLabel(String userLabel) {
		this.userLabel = userLabel;
	}

	public String getNativeEMSName() {
		return nativeEMSName;
	}

	public void setNativeEMSName(String nativeEMSName) {
		this.nativeEMSName = nativeEMSName;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getParaList() {
		return paraList;
	}

	public void setParaList(String paraList) {
		this.paraList = paraList;
	}

	public String getForwardTPList() {
		return forwardTPList;
	}

	public void setForwardTPList(String forwardTPList) {
		this.forwardTPList = forwardTPList;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

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

	private String name;
	private String userLabel;
	private String nativeEMSName;
	private String owner;
	private String paraList;
	private String forwardTPList;
	private String additionalInfo;
	private String parentDn;
	private String emsName;
}
