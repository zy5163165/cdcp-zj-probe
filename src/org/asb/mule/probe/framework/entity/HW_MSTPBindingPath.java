package org.asb.mule.probe.framework.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.alcatelsbell.nms.valueobject.BObject;

@Entity
@Table(name = "HW_MSTPBindingPath")
public class HW_MSTPBindingPath extends BObject {

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getAllPathList() {
		return allPathList;
	}

	public void setAllPathList(String allPathList) {
		this.allPathList = allPathList;
	}

	public String getUsedPathList() {
		return usedPathList;
	}

	public void setUsedPathList(String usedPathList) {
		this.usedPathList = usedPathList;
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

	private String direction;
	private String allPathList;
	private String usedPathList;
	private String additionalInfo;
	private String parentDn;
	private String emsName;

}
