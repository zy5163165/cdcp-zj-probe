package org.asb.mule.probe.framework.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.alcatelsbell.nms.valueobject.BObject;

/**
 * Author: Ronnie.Chen
 * Date: 14-4-8
 * Time: 下午4:13
 * rongrong.chen@alcatel-sbell.com.cn
 */

@Entity
@Table(name = "DeviceInfo")
public class DeviceInfo extends BObject {
	private String deviceDn;
	private String deviceName;
	private String emsName;
	private String productNme;

	public DeviceInfo() {
	}

	public DeviceInfo(String deviceDn, String deviceName, String emsName, String productNme) {
		this.deviceDn = deviceDn;
		this.deviceName = deviceName;
		this.emsName = emsName;
		this.productNme = productNme;
	}

	public String getDeviceDn() {
		return deviceDn;
	}

	public void setDeviceDn(String deviceDn) {
		this.deviceDn = deviceDn;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getEmsName() {
		return emsName;
	}

	public void setEmsName(String emsName) {
		this.emsName = emsName;
	}

	public String getProductNme() {
		return productNme;
	}

	public void setProductNme(String productNme) {
		this.productNme = productNme;
	}
}
