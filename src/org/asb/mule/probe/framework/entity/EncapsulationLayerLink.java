package org.asb.mule.probe.framework.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.alcatelsbell.nms.valueobject.BObject;

@Entity
@Table(name = "EncapsulationLayerLink")
public class EncapsulationLayerLink extends BObject {

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTransmissionParams() {
		return transmissionParams;
	}

	public void setTransmissionParams(String transmissionParams) {
		this.transmissionParams = transmissionParams;
	}

	public short getRate() {
		return rate;
	}

	public void setRate(short rate) {
		this.rate = rate;
	}

	public String getNetworkAccessDomain() {
		return networkAccessDomain;
	}

	public void setNetworkAccessDomain(String networkAccessDomain) {
		this.networkAccessDomain = networkAccessDomain;
	}

	public String getEndTPs() {
		return endTPs;
	}

	public void setEndTPs(String endTPs) {
		this.endTPs = endTPs;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public boolean isSegment() {
		return segment;
	}

	public void setSegment(boolean segment) {
		this.segment = segment;
	}

	public String getRouteGroups() {
		return routeGroups;
	}

	public void setRouteGroups(String routeGroups) {
		this.routeGroups = routeGroups;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	private String parentDn;
	private String emsName;

	private String name;
	private String userLabel;
	private String nativeEMSName;
	private String owner;
	private String type;
	private String transmissionParams;
	private short rate;
	private String networkAccessDomain;
	private String endTPs;
	private String route;
	private boolean segment;
	private String routeGroups;
	private String additionalInfo;
}
