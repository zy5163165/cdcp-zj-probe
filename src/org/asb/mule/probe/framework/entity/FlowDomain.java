package org.asb.mule.probe.framework.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.alcatelsbell.nms.valueobject.BObject;
@Entity
@Table(name = "FlowDomain")
public class FlowDomain extends BObject {

	private String fDConnectivityState="";
	private String networkAccessDomain="";
	private String transmissionParams = "";
	private String fdType = "";
	private String userLabel = "";	
	private String nativeEMSName = "";
	private String owner = "";
	private String additionalInfo = "";
	public String getfDConnectivityState() {
		return fDConnectivityState;
	}
	public void setfDConnectivityState(String fDConnectivityState) {
		this.fDConnectivityState = fDConnectivityState;
	}
	public String getNetworkAccessDomain() {
		return networkAccessDomain;
	}
	public void setNetworkAccessDomain(String networkAccessDomain) {
		this.networkAccessDomain = networkAccessDomain;
	}
	public String getTransmissionParams() {
		return transmissionParams;
	}
	public void setTransmissionParams(String transmissionParams) {
		this.transmissionParams = transmissionParams;
	}
	public String getFdType() {
		return fdType;
	}
	public void setFdType(String fdType) {
		this.fdType = fdType;
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
	public String getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
}
