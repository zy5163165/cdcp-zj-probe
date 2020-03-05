package org.asb.mule.probe.framework.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.alcatelsbell.nms.valueobject.BObject;

@Entity
@Table(name = "AlarmModel")

public class AlarmModel extends BObject {
	
	//专业类型
	private String transType;
	//厂商
	private String vendor;
	//EMS名称
	private String emsName;
	
	// 告警等级
	private String perceiverServerity;
	// 告警类型
	private String alarmType;
	// 转化告警本地命名
	private String nativeEmsName;
	
	// 告警定位信息
	private String locationInfo;
	//产生时间
	private String startTime;
	//清除时间
	private String endTime;
	
	// 可能用不到的：
	// 告警描述
	private String nativeProbableCause;
	// 告警原因
	private String probableCause;
	
	// 网元告警日期
	private String neTime;
	// 网管告警时间
	private String emsTime;
	
	private String resName;
	
	private String resType;
	
	private String ctpName;

	private String alarmDesc;

	private String additionalInfo = "";
	
	private String memo;
	
	// SnUnit
	private String sysNo;
	private String neNo;
	private String rackNo;
	private String shelfNo;
	private String subShelfNo;
	private String slotNo;
	private String subSlotNo;
	private String cardNo;
	private String portNo;

	@Override
	public String toString() {
		return "ResName：" + this.getResName() + "ResType：" + this.getResType() + "AlarmType:" + this.getAlarmType()
				+ "AlarmDesc:" + this.getAlarmDesc() + "PerceiverServerity：" + this.getPerceiverServerity() + "CtpName："
				+ this.getCtpName() + "EmsTime：" + this.getEmsTime() + "NativeProbableCause"
				+ this.getNativeProbableCause();
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getEmsName() {
		return emsName;
	}

	public void setEmsName(String emsName) {
		this.emsName = emsName;
	}

	public String getPerceiverServerity() {
		return perceiverServerity;
	}

	public void setPerceiverServerity(String perceiverServerity) {
		this.perceiverServerity = perceiverServerity;
	}

	public String getAlarmType() {
		return alarmType;
	}

	public void setAlarmType(String alarmType) {
		this.alarmType = alarmType;
	}

	public String getNativeEmsName() {
		return nativeEmsName;
	}

	public void setNativeEmsName(String nativeEmsName) {
		this.nativeEmsName = nativeEmsName;
	}

	public String getLocationInfo() {
		return locationInfo;
	}

	public void setLocationInfo(String locationInfo) {
		this.locationInfo = locationInfo;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getNativeProbableCause() {
		return nativeProbableCause;
	}

	public void setNativeProbableCause(String nativeProbableCause) {
		this.nativeProbableCause = nativeProbableCause;
	}

	public String getProbableCause() {
		return probableCause;
	}

	public void setProbableCause(String probableCause) {
		this.probableCause = probableCause;
	}

	public String getNeTime() {
		return neTime;
	}

	public void setNeTime(String neTime) {
		this.neTime = neTime;
	}

	public String getEmsTime() {
		return emsTime;
	}

	public void setEmsTime(String emsTime) {
		this.emsTime = emsTime;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public String getResType() {
		return resType;
	}

	public void setResType(String resType) {
		this.resType = resType;
	}

	public String getCtpName() {
		return ctpName;
	}

	public void setCtpName(String ctpName) {
		this.ctpName = ctpName;
	}

	public String getAlarmDesc() {
		return alarmDesc;
	}

	public void setAlarmDesc(String alarmDesc) {
		this.alarmDesc = alarmDesc;
	}

	public String getSysNo() {
		return sysNo;
	}

	public void setSysNo(String sysNo) {
		this.sysNo = sysNo;
	}

	public String getNeNo() {
		return neNo;
	}

	public void setNeNo(String neNo) {
		this.neNo = neNo;
	}

	public String getRackNo() {
		return rackNo;
	}

	public void setRackNo(String rackNo) {
		this.rackNo = rackNo;
	}

	public String getShelfNo() {
		return shelfNo;
	}

	public void setShelfNo(String shelfNo) {
		this.shelfNo = shelfNo;
	}

	public String getSubShelfNo() {
		return subShelfNo;
	}

	public void setSubShelfNo(String subShelfNo) {
		this.subShelfNo = subShelfNo;
	}

	public String getSlotNo() {
		return slotNo;
	}

	public void setSlotNo(String slotNo) {
		this.slotNo = slotNo;
	}

	public String getSubSlotNo() {
		return subSlotNo;
	}

	public void setSubSlotNo(String subSlotNo) {
		this.subSlotNo = subSlotNo;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getPortNo() {
		return portNo;
	}

	public void setPortNo(String portNo) {
		this.portNo = portNo;
	}

	
	
	
}
