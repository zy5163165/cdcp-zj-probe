package org.asb.mule.probe.framework.entity;


import javax.persistence.Entity;
import javax.persistence.Table;

import com.alcatelsbell.nms.valueobject.BObject;





@Entity
@Table(name = "Equipment")

public class Equipment extends BObject
{
	private boolean alarmReportingIndicator=true;
	private String serviceState="";
	private String expectedEquipmentObjectType="";
	private String installedEquipmentObjectType="";
	private String installedPartNumber = "";
	private String installedVersion = "";
	private String installedSerialNumber = "";
	
	

	/**
	 * @return the alarmReportingIndicator
	 */
	public boolean isAlarmReportingIndicator() {
		return alarmReportingIndicator;
	}
	/**
	 * @param alarmReportingIndicator the alarmReportingIndicator to set
	 */
	public void setAlarmReportingIndicator(boolean alarmReportingIndicator) {
		this.alarmReportingIndicator = alarmReportingIndicator;
	}
	/**
	 * @return the serviceState
	 */
	public String getServiceState() {
		return serviceState;
	}
	/**
	 * @param serviceState the serviceState to set
	 */
	public void setServiceState(String serviceState) {
		this.serviceState = serviceState;
	}
	/**
	 * @return the expectedEquipmentObjectType
	 */
	public String getExpectedEquipmentObjectType() {
		return expectedEquipmentObjectType;
	}
	/**
	 * @param expectedEquipmentObjectType the expectedEquipmentObjectType to set
	 */
	public void setExpectedEquipmentObjectType(String expectedEquipmentObjectType) {
		this.expectedEquipmentObjectType = expectedEquipmentObjectType;
	}
	/**
	 * @return the installedEquipmentObjectType
	 */
	public String getInstalledEquipmentObjectType() {
		return installedEquipmentObjectType;
	}
	/**
	 * @param installedEquipmentObjectType the installedEquipmentObjectType to set
	 */
	public void setInstalledEquipmentObjectType(String installedEquipmentObjectType) {
		this.installedEquipmentObjectType = installedEquipmentObjectType;
	}
	/**
	 * @return the installedPartNumber
	 */
	public String getInstalledPartNumber() {
		return installedPartNumber;
	}
	/**
	 * @param installedPartNumber the installedPartNumber to set
	 */
	public void setInstalledPartNumber(String installedPartNumber) {
		this.installedPartNumber = installedPartNumber;
	}
	/**
	 * @return the installedVersion
	 */
	public String getInstalledVersion() {
		return installedVersion;
	}
	/**
	 * @param installedVersion the installedVersion to set
	 */
	public void setInstalledVersion(String installedVersion) {
		this.installedVersion = installedVersion;
	}
	/**
	 * @return the installedSerialNumber
	 */
	public String getInstalledSerialNumber() {
		return installedSerialNumber;
	}
	/**
	 * @param installedSerialNumber the installedSerialNumber to set
	 */
	public void setInstalledSerialNumber(String installedSerialNumber) {
		this.installedSerialNumber = installedSerialNumber;
	}
	
	private String parentDn = "";
	private String emsName = "";
	
	private String userLabel = "";
	
	private String nativeEMSName = "";
	
	
	private String owner = "";
	

	private String additionalInfo = "";
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
		return "Equipment [additionalInfo=" + additionalInfo
				+ ", alarmReportingIndicator=" + alarmReportingIndicator
				+ ", emsName=" + emsName + ", expectedEquipmentObjectType="
				+ expectedEquipmentObjectType
				+ ", installedEquipmentObjectType="
				+ installedEquipmentObjectType + ", installedPartNumber="
				+ installedPartNumber + ", installedSerialNumber="
				+ installedSerialNumber + ", installedVersion="
				+ installedVersion + ", nativeEMSName=" + nativeEMSName
				+ ", owner=" + owner + ", parentDn=" + parentDn
				+ ", serviceState=" + serviceState + ", userLabel=" + userLabel
				+ "]";
	}
	
}
