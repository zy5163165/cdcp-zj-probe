package org.asb.mule.probe.framework.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.alcatelsbell.nms.valueobject.BObject;

@Entity
@Table(name = "HW_EthService")
public class HW_EthService extends BObject {

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

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public boolean isActiveState() {
		return activeState;
	}

	public void setActiveState(boolean activeState) {
		this.activeState = activeState;
	}

	public String getaEndPoint() {
		return aEndPoint;
	}

	public void setaEndPoint(String aEndPoint) {
		this.aEndPoint = aEndPoint;
	}

	public String getzEndPoint() {
		return zEndPoint;
	}

	public void setzEndPoint(String zEndPoint) {
		this.zEndPoint = zEndPoint;
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

	public String getaEnd() {
		return aEnd;
	}

	public void setaEnd(String aEnd) {
		this.aEnd = aEnd;
	}

	public short getaVlanID() {
		return aVlanID;
	}

	public void setaVlanID(short aVlanID) {
		this.aVlanID = aVlanID;
	}

	public int getaTunnel() {
		return aTunnel;
	}

	public void setaTunnel(int aTunnel) {
		this.aTunnel = aTunnel;
	}

	public int getaVC() {
		return aVC;
	}

	public void setaVC(int aVC) {
		this.aVC = aVC;
	}

	public String getaAdditionalInfo() {
		return aAdditionalInfo;
	}

	public void setaAdditionalInfo(String aAdditionalInfo) {
		this.aAdditionalInfo = aAdditionalInfo;
	}

	public String getzEnd() {
		return zEnd;
	}

	public void setzEnd(String zEnd) {
		this.zEnd = zEnd;
	}

	public short getzVlanID() {
		return zVlanID;
	}

	public void setzVlanID(short zVlanID) {
		this.zVlanID = zVlanID;
	}

	public int getzTunnel() {
		return zTunnel;
	}

	public void setzTunnel(int zTunnel) {
		this.zTunnel = zTunnel;
	}

	public int getzVC() {
		return zVC;
	}

	public void setzVC(int zVC) {
		this.zVC = zVC;
	}

	public String getzAdditionalInfo() {
		return zAdditionalInfo;
	}

	public void setzAdditionalInfo(String zAdditionalInfo) {
		this.zAdditionalInfo = zAdditionalInfo;
	}

	private String name;
	private String userLabel;
	private String nativeEMSName;
	private String owner;
	private String serviceType;
	private String direction;
	private boolean activeState;
	private String additionalInfo;
	private String parentDn;
	private String emsName;

	private String aEndPoint;
	private String zEndPoint;
	private String aEnd;
	private short aVlanID;
	private int aTunnel;
	private int aVC;
	private String aAdditionalInfo;
	private String zEnd;
	private short zVlanID;
	private int zTunnel;
	private int zVC;
	private String zAdditionalInfo;

}
