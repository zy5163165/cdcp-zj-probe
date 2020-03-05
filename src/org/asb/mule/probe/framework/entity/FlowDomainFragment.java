package org.asb.mule.probe.framework.entity;


import javax.persistence.Entity;
import javax.persistence.Table;

import com.alcatelsbell.nms.valueobject.BObject;





@Entity
@Table(name = "FlowDomainFragment")

public class FlowDomainFragment extends BObject
{
	
	
	private boolean flexible = false;
	private String networkAccessDomain="";
	private String administrativeState="";
	private String fdfrState="";
	private String multipointServiceAttrParaList;
	private String multipointServiceAttrMacList;
	private String multipointServiceAttrAddInfo;
	private String direction = "";
	private String transmissionParams = "";
	private String rate="";
	private String fdfrType = "";
	private String aEnd = "";
	private String zEnd = "";
	private String aPtp = "";
	private String zPtp = "";
	private String aNE = "";
	private String zNE = "";
	private String aEndTrans = "";
	private String zEndtrans = "";
	/**
	 * @return the flexible
	 */
	public boolean isFlexible() {
		return flexible;
	}
	/**
	 * @param flexible the flexible to set
	 */
	public void setFlexible(boolean flexible) {
		this.flexible = flexible;
	}
	/**
	 * @return the networkAccessDomain
	 */
	public String getNetworkAccessDomain() {
		return networkAccessDomain;
	}
	/**
	 * @param networkAccessDomain the networkAccessDomain to set
	 */
	public void setNetworkAccessDomain(String networkAccessDomain) {
		this.networkAccessDomain = networkAccessDomain;
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
	 * @return the fdfrState
	 */
	public String getFdfrState() {
		return fdfrState;
	}
	/**
	 * @param fdfrState the fdfrState to set
	 */
	public void setFdfrState(String fdfrState) {
		this.fdfrState = fdfrState;
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
	 * @return the fdfrType
	 */
	public String getFdfrType() {
		return fdfrType;
	}
	/**
	 * @param fdfrType the fdfrType to set
	 */
	public void setFdfrType(String fdfrType) {
		this.fdfrType = fdfrType;
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
	/**
	 * @return the multipointServiceAttrParaList
	 */
	public String getMultipointServiceAttrParaList() {
		return multipointServiceAttrParaList;
	}
	/**
	 * @param multipointServiceAttrParaList the multipointServiceAttrParaList to set
	 */
	public void setMultipointServiceAttrParaList(
			String multipointServiceAttrParaList) {
		this.multipointServiceAttrParaList = multipointServiceAttrParaList;
	}
	/**
	 * @return the multipointServiceAttrMacList
	 */
	public String getMultipointServiceAttrMacList() {
		return multipointServiceAttrMacList;
	}
	/**
	 * @param multipointServiceAttrMacList the multipointServiceAttrMacList to set
	 */
	public void setMultipointServiceAttrMacList(String multipointServiceAttrMacList) {
		this.multipointServiceAttrMacList = multipointServiceAttrMacList;
	}
	/**
	 * @return the multipointServiceAttrAddInfo
	 */
	public String getMultipointServiceAttrAddInfo() {
		return multipointServiceAttrAddInfo;
	}
	/**
	 * @param multipointServiceAttrAddInfo the multipointServiceAttrAddInfo to set
	 */
	public void setMultipointServiceAttrAddInfo(String multipointServiceAttrAddInfo) {
		this.multipointServiceAttrAddInfo = multipointServiceAttrAddInfo;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FlowDomainFragment [DN=" + dn + ",aEnd=" + aEnd + ", aEndTrans=" + aEndTrans
				+ ", additionalInfo=" + additionalInfo
				+ ", administrativeState=" + administrativeState
				+ ", direction=" + direction + ", emsName=" + emsName
				+ ", fdfrState=" + fdfrState + ", fdfrType=" + fdfrType
				+ ", flexible=" + flexible + ", multipointServiceAttrAddInfo="
				+ multipointServiceAttrAddInfo
				+ ", multipointServiceAttrMacList="
				+ multipointServiceAttrMacList
				+ ", multipointServiceAttrParaList="
				+ multipointServiceAttrParaList + ", nativeEMSName="
				+ nativeEMSName + ", networkAccessDomain="
				+ networkAccessDomain + ", owner=" + owner + ", parentDn="
				+ parentDn + ", rate=" + rate + ", transmissionParams="
				+ transmissionParams + ", userLabel=" + userLabel + ", zEnd="
				+ zEnd + ", zEndtrans=" + zEndtrans + "]";
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
	public String getaNE() {
		return aNE;
	}
	public void setaNE(String aNE) {
		this.aNE = aNE;
	}
	public String getzNE() {
		return zNE;
	}
	public void setzNE(String zNE) {
		this.zNE = zNE;
	}
}
