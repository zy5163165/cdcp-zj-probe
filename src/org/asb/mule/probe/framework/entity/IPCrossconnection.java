package org.asb.mule.probe.framework.entity;


import javax.persistence.Entity;
import javax.persistence.Table;

import com.alcatelsbell.nms.valueobject.BObject;





@Entity
@Table(name = "IPCrossconnection")

public class IPCrossconnection extends BObject
{
	
	
	private String ccType="";
	private String administrativeState="";
	private String activeState="";
	private String direction = "";
	private String transmissionParams = "";
	private String rate="";
	private String aEnd = "";
	private String zEnd = "";
	private String aPtp = "";
	private String zPtp = "";
	private String aEndTrans = "";
	private String zEndtrans = "";
	/**
	 * @return the ccType
	 */
	public String getCcType() {
		return ccType;
	}
	/**
	 * @param ccType the ccType to set
	 */
	public void setCcType(String ccType) {
		this.ccType = ccType;
	}
	/**
	 * @return the administrativeState
	 */
	public String getAdministrativeState() {
		return administrativeState;
	}
	/**
	 * @param administrativeState the administrativeState to set
	 */
	public void setAdministrativeState(String administrativeState) {
		this.administrativeState = administrativeState;
	}
	/**
	 * @return the activeState
	 */
	public String getActiveState() {
		return activeState;
	}
	/**
	 * @param activeState the activeState to set
	 */
	public void setActiveState(String activeState) {
		this.activeState = activeState;
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
	 * @return the transmissionParams
	 */
	public String getTransmissionParams() {
		return transmissionParams;
	}
	/**
	 * @param transmissionParams the transmissionParams to set
	 */
	public void setTransmissionParams(String transmissionParams) {
		this.transmissionParams = transmissionParams;
	}
	/**
	 * @return the aEnd
	 */
	public String getaEnd() {
		return aEnd;
	}
	/**
	 * @param aEnd the aEnd to set
	 */
	public void setaEnd(String aEnd) {
		this.aEnd = aEnd;
	}
	/**
	 * @return the zEnd
	 */
	public String getzEnd() {
		return zEnd;
	}
	/**
	 * @param zEnd the zEnd to set
	 */
	public void setzEnd(String zEnd) {
		this.zEnd = zEnd;
	}
	/**
	 * @return the aEndTrans
	 */
	public String getaEndTrans() {
		return aEndTrans;
	}
	/**
	 * @param aEndTrans the aEndTrans to set
	 */
	public void setaEndTrans(String aEndTrans) {
		this.aEndTrans = aEndTrans;
	}
	/**
	 * @return the zEndtrans
	 */
	public String getzEndtrans() {
		return zEndtrans;
	}
	/**
	 * @param zEndtrans the zEndtrans to set
	 */
	public void setzEndtrans(String zEndtrans) {
		this.zEndtrans = zEndtrans;
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

	public void setaPtp(String aPtp) {
		this.aPtp = aPtp;
	}
	public String getaPtp() {
		return aPtp;
	}
	public void setzPtp(String zPtp) {
		this.zPtp = zPtp;
	}
	public String getzPtp() {
		return zPtp;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getRate() {
		return rate;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "IPCrossconnection [aEnd=" + aEnd + ", aEndTrans=" + aEndTrans
				+ ", aPtp=" + aPtp + ", activeState=" + activeState
				+ ", additionalInfo=" + additionalInfo
				+ ", administrativeState=" + administrativeState + ", ccType="
				+ ccType + ", direction=" + direction + ", emsName=" + emsName
				+ ", nativeEMSName=" + nativeEMSName + ", owner=" + owner
				+ ", parentDn=" + parentDn + ", rate=" + rate
				+ ", transmissionParams=" + transmissionParams + ", userLabel="
				+ userLabel + ", zEnd=" + zEnd + ", zEndtrans=" + zEndtrans
				+ ", zPtp=" + zPtp + "]";
	}
}
