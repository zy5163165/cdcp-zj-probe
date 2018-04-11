package org.asb.mule.probe.framework.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.alcatelsbell.nms.valueobject.BObject;

@Entity
@Table(name = "TrailNtwProtection")
public class TrailNtwProtection extends BObject {
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

	public String getProtectionGroupType() {
		return protectionGroupType;
	}

	public void setProtectionGroupType(String protectionGroupType) {
		this.protectionGroupType = protectionGroupType;
	}

	public String getProtectionSchemeState() {
		return protectionSchemeState;
	}

	public void setProtectionSchemeState(String protectionSchemeState) {
		this.protectionSchemeState = protectionSchemeState;
	}

	public String getReversionMode() {
		return reversionMode;
	}

	public void setReversionMode(String reversionMode) {
		this.reversionMode = reversionMode;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getTrailNtwProtectionType() {
		return trailNtwProtectionType;
	}

	public void setTrailNtwProtectionType(String trailNtwProtectionType) {
		this.trailNtwProtectionType = trailNtwProtectionType;
	}

	public String getProtectionGroupAName() {
		return protectionGroupAName;
	}

	public void setProtectionGroupAName(String protectionGroupAName) {
		this.protectionGroupAName = protectionGroupAName;
	}

	public String getProtectionGroupZName() {
		return protectionGroupZName;
	}

	public void setProtectionGroupZName(String protectionGroupZName) {
		this.protectionGroupZName = protectionGroupZName;
	}

	public String getPgATPList() {
		return pgATPList;
	}

	public void setPgATPList(String pgATPList) {
		this.pgATPList = pgATPList;
	}

	public String getPgZTPList() {
		return pgZTPList;
	}

	public void setPgZTPList(String pgZTPList) {
		this.pgZTPList = pgZTPList;
	}

	public String getWorkerTrailList() {
		return workerTrailList;
	}

	public void setWorkerTrailList(String workerTrailList) {
		this.workerTrailList = workerTrailList;
	}

	public String getProtectionTrail() {
		return protectionTrail;
	}

	public void setProtectionTrail(String protectionTrail) {
		this.protectionTrail = protectionTrail;
	}

	public String getTnpParameters() {
		return tnpParameters;
	}

	public void setTnpParameters(String tnpParameters) {
		this.tnpParameters = tnpParameters;
	}

	public String getApsFunction() {
		return apsFunction;
	}

	public void setApsFunction(String apsFunction) {
		this.apsFunction = apsFunction;
	}

	public String getNetworkAccessDomain() {
		return networkAccessDomain;
	}

	public void setNetworkAccessDomain(String networkAccessDomain) {
		this.networkAccessDomain = networkAccessDomain;
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

	private String userLabel = "";
	private String nativeEMSName = "";
	private String owner = "";
	private String protectionGroupType = "";
	private String protectionSchemeState = "";
	private String reversionMode = "";
	private String rate = "";
	private String trailNtwProtectionType = "";
	private String protectionGroupAName = "";
	private String protectionGroupZName = "";
	private String pgATPList = "";
	private String pgZTPList = "";
	private String workerTrailList = "";
	private String protectionTrail = "";
	private String tnpParameters = "";
	private String apsFunction = "";
	private String networkAccessDomain = "";
	private String additionalInfo = "";

	private String parentDn = "";
	private String emsName = "";

}
