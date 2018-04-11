package org.asb.mule.probe.framework.entity;


import javax.persistence.Entity;
import javax.persistence.Table;

import com.alcatelsbell.nms.valueobject.BObject;





@Entity
@Table(name = "Section")

public class Section extends BObject
{
	
	private String rate="";
	private String direction="";
	private String aEndTP="";
	private String zEndTP = "";
	private String parentDn = "";
	private String emsName = "";
	
	private String userLabel = "";
	
	private String nativeEMSName = "";
	
	
	private String owner = "";
	

	private String additionalInfo = "";
	/**
	 * @return the rate
	 */
	public String getRate() {
		return rate;
	}
	/**
	 * @param rate the rate to set
	 */
	public void setRate(String rate) {
		this.rate = rate;
	}
	/**
	 * @return the direction
	 */
	public String getDirection() {
		return direction;
	}
	/**
	 * @param direction the direction to set
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}
	/**
	 * @return the aEndTP
	 */
	public String getaEndTP() {
		return aEndTP;
	}
	/**
	 * @param aEndTP the aEndTP to set
	 */
	public void setaEndTP(String aEndTP) {
		this.aEndTP = aEndTP;
	}
	/**
	 * @return the zEndTP
	 */
	public String getzEndTP() {
		return zEndTP;
	}
	/**
	 * @param zEndTP the zEndTP to set
	 */
	public void setzEndTP(String zEndTP) {
		this.zEndTP = zEndTP;
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
		return "Section [aEndTP=" + aEndTP + ", additionalInfo="
				+ additionalInfo + ", direction=" + direction + ", emsName="
				+ emsName + ", nativeEMSName=" + nativeEMSName + ", owner="
				+ owner + ", parentDn=" + parentDn + ", rate=" + rate
				+ ", userLabel=" + userLabel + ", zEndTP=" + zEndTP + "]";
	}
}
