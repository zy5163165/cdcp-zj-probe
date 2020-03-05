package org.asb.mule.probe.framework.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.alcatelsbell.nms.valueobject.BObject;

@Entity
@Table(name = "FDFrRoute")
public class MatrixFlowDomainFragment extends BObject {

	private String parentDn = "";
	private String emsName = "";
	private String name = "";
	private String userLabel = "";
	private String nativeEMSName = "";
	private String owner = "";
	private String direction = "";
	private String transmissionParams = "";
	private String multipointServiceAttr = "";
	private String aEnd = "";
	private String zEnd = "";
	private String aPtp = "";
	private String zPtp = "";
	private String aEndTrans = "";
	private String zEndtrans = "";
	private String zpwid = "";
	private String zWorkingMode = "";
	private String fdfrState = "";
	private String administrativeState = "";
	private boolean flexible = false;
	private String mfdfrType = "";
	private String additionalInfo = "";

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

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getTransmissionParams() {
		return transmissionParams;
	}

	public void setTransmissionParams(String transmissionParams) {
		this.transmissionParams = transmissionParams;
	}

	public String getMultipointServiceAttr() {
		return multipointServiceAttr;
	}

	public void setMultipointServiceAttr(String multipointServiceAttr) {
		this.multipointServiceAttr = multipointServiceAttr;
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

	public String getzEndtrans() {
		return zEndtrans;
	}

	public void setzEndtrans(String zEndtrans) {
		this.zEndtrans = zEndtrans;
	}

	public String getFdfrState() {
		return fdfrState;
	}

	public void setFdfrState(String fdfrState) {
		this.fdfrState = fdfrState;
	}

	public String getAdministrativeState() {
		return administrativeState;
	}

	public void setAdministrativeState(String administrativeState) {
		this.administrativeState = administrativeState;
	}

	public boolean isFlexible() {
		return flexible;
	}

	public void setFlexible(boolean flexible) {
		this.flexible = flexible;
	}

	public String getMfdfrType() {
		return mfdfrType;
	}

	public void setMfdfrType(String mfdfrType) {
		this.mfdfrType = mfdfrType;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public String getZpwid() {
		return zpwid;
	}

	public void setZpwid(String zpwid) {
		this.zpwid = zpwid;
	}

	public String getzWorkingMode() {
		return zWorkingMode;
	}

	public void setzWorkingMode(String zWorkingMode) {
		this.zWorkingMode = zWorkingMode;
	}
}
