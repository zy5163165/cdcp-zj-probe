package org.asb.mule.probe.framework.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.alcatelsbell.nms.valueobject.BObject;

@Entity
@Table(name = "SubnetworkConnection")
public class SubnetworkConnection extends BObject {
	private String name = "";
	private String userLabel = "";
	private String nativeEMSName = "";
	private String owner = "";
	private String sncState = "";
	private String direction = "";
	private String rate = "";
	private String staticProtectionLevel = "";
	private String sncType = "";
	private String aEnd = "";
	private String zEnd = "";
	private String rerouteAllowed = "";
	private String networkRouted = "";
	private String additionalInfo = "";

	private String aPtp = "";
	private String zPtp = "";
	private String aNE = "";
	private String zNE = "";
	private String aEndTrans = "";
	private String zEndTrans = "";
	private String parentDn = "";
	private String emsName = "";

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

	public String getSncState() {
		return sncState;
	}

	public void setSncState(String sncState) {
		this.sncState = sncState;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getStaticProtectionLevel() {
		return staticProtectionLevel;
	}

	public void setStaticProtectionLevel(String staticProtectionLevel) {
		this.staticProtectionLevel = staticProtectionLevel;
	}

	public String getSncType() {
		return sncType;
	}

	public void setSncType(String sncType) {
		this.sncType = sncType;
	}

	public String getaEnd() {
		return aEnd;
	}

	public void setaEnd(String aEnd) {
		this.aEnd = aEnd;
	}

	public String getzEnd() {
		return zEnd;
	}

	public void setzEnd(String zEnd) {
		this.zEnd = zEnd;
	}

	public String getRerouteAllowed() {
		return rerouteAllowed;
	}

	public void setRerouteAllowed(String rerouteAllowed) {
		this.rerouteAllowed = rerouteAllowed;
	}

	public String getNetworkRouted() {
		return networkRouted;
	}

	public void setNetworkRouted(String networkRouted) {
		this.networkRouted = networkRouted;
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

	public String getaPtp() {
		return aPtp;
	}

	public void setaPtp(String aPtp) {
		this.aPtp = aPtp;
	}

	public String getzPtp() {
		return zPtp;
	}

	public void setzPtp(String zPtp) {
		this.zPtp = zPtp;
	}

	public String getaEndTrans() {
		return aEndTrans;
	}

	public void setaEndTrans(String aEndTrans) {
		this.aEndTrans = aEndTrans;
	}

	public String getzEndTrans() {
		return zEndTrans;
	}

	public void setzEndTrans(String zEndTrans) {
		this.zEndTrans = zEndTrans;
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
