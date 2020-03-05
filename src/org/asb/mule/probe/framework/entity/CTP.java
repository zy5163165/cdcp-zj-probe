package org.asb.mule.probe.framework.entity;


import javax.persistence.Entity;
import javax.persistence.Table;

import com.alcatelsbell.nms.valueobject.BObject;





@Entity
@Table(name = "CTP")

public class CTP extends BObject
{
	
	
	
	private boolean edgePoint=false;
	private String type="";
	private String connectionState="";
	private String tpMappingMode="";
	private String direction = "";
	private String transmissionParams = "";
	private String tpProtectionAssociation = "";
	private String rate = "";
	private String portdn="";
	private String parentCtpdn="";
	/**
	 * @return the edgePoint
	 */
	public boolean isEdgePoint() {
		return edgePoint;
	}
	/**
	 * @param edgePoint the edgePoint to set
	 */
	public void setEdgePoint(boolean edgePoint) {
		this.edgePoint = edgePoint;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the connectionState
	 */
	public String getConnectionState() {
		return connectionState;
	}
	/**
	 * @param connectionState the connectionState to set
	 */
	public void setConnectionState(String connectionState) {
		this.connectionState = connectionState;
	}
	/**
	 * @return the tpMappingMode
	 */
	public String getTpMappingMode() {
		return tpMappingMode;
	}
	/**
	 * @param tpMappingMode the tpMappingMode to set
	 */
	public void setTpMappingMode(String tpMappingMode) {
		this.tpMappingMode = tpMappingMode;
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
	 * @return the tpProtectionAssociation
	 */
	public String getTpProtectionAssociation() {
		return tpProtectionAssociation;
	}
	/**
	 * @param tpProtectionAssociation the tpProtectionAssociation to set
	 */
	public void setTpProtectionAssociation(String tpProtectionAssociation) {
		this.tpProtectionAssociation = tpProtectionAssociation;
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
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getPortdn() {
		return portdn;
	}
	public void setPortdn(String portdn) {
		this.portdn = portdn;
	}
	public String getParentCtpdn() {
		return parentCtpdn;
	}
	public void setParentCtpdn(String parentCtpdn) {
		this.parentCtpdn = parentCtpdn;
	}
}
