package org.asb.mule.probe.framework.entity;


import javax.persistence.Entity;
import javax.persistence.Table;

import com.alcatelsbell.nms.valueobject.BObject;





@Entity
@Table(name = "ManagedElement")

public class ManagedElement extends BObject
{
	
	 
	
	
	private String location = "";
	private String neVersion = "";
	
	private String productName = "";
	private String communicationState = "";
	private boolean emsInSyncState = false;
	private String supportedRates ="";
	
	private String parentDn = "";
	private String emsName = "";
	
	private String userLabel = "";
	
	private String nativeEMSName = "";
	
	
	private String owner = "";
	

	private String additionalInfo = "";
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the neVersion
	 */
	public String getNeVersion() {
		return neVersion;
	}
	/**
	 * @param neVersion the neVersion to set
	 */
	public void setNeVersion(String neVersion) {
		this.neVersion = neVersion;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the emsInSyncState
	 */
	public boolean isEmsInSyncState() {
		return emsInSyncState;
	}
	/**
	 * @param emsInSyncState the emsInSyncState to set
	 */
	public void setEmsInSyncState(boolean emsInSyncState) {
		this.emsInSyncState = emsInSyncState;
	}
	/**
	 * @return the supportedRates
	 */
	public String getSupportedRates() {
		return supportedRates;
	}
	/**
	 * @param supportedRates the supportedRates to set
	 */
	public void setSupportedRates(String supportedRates) {
		this.supportedRates = supportedRates;
	}
	/**
	 * @return the communicationState
	 */
	public String getCommunicationState() {
		return communicationState;
	}
	/**
	 * @param communicationState the communicationState to set
	 */
	public void setCommunicationState(String communicationState) {
		this.communicationState = communicationState;
	}
	
	/**
	 * @return the emsName
	 */
	public String getEmsName() {
		return emsName;
	}
	/**
	 * @param emsName the emsName to set
	 */
	public void setEmsName(String emsName) {
		this.emsName = emsName;
	}
	/**
	 * @return the userLabel
	 */
	public String getUserLabel() {
		return userLabel;
	}
	/**
	 * @param userLabel the userLabel to set
	 */
	public void setUserLabel(String userLabel) {
		this.userLabel = userLabel;
	}
	/**
	 * @return the nativeEMSName
	 */
	public String getNativeEMSName() {
		return nativeEMSName;
	}
	/**
	 * @param nativeEMSName the nativeEMSName to set
	 */
	public void setNativeEMSName(String nativeEMSName) {
		this.nativeEMSName = nativeEMSName;
	}

	
	public void setParentDn(String parentDn) {
		this.parentDn = parentDn;
	}
	public String getParentDn() {
		return parentDn;
	}
	/**
	 * @return the additionalInfo
	 */
	public String getAdditionalInfo() {
		return additionalInfo;
	}
	/**
	 * @param additionalInfo the additionalInfo to set
	 */
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}
	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ManagedElement [additionalInfo=" + additionalInfo
				+ ", communicationState=" + communicationState
				+ ", emsInSyncState=" + emsInSyncState + ", emsName=" + emsName
				+ ", location=" + location + ", nativeEMSName=" + nativeEMSName
				+ ", neVersion=" + neVersion + ", owner=" + owner
				+ ", parentDn=" + parentDn + ", productName=" + productName
				+ ", supportedRates=" + supportedRates + ", userLabel="
				+ userLabel + "]";
	}
	
}
