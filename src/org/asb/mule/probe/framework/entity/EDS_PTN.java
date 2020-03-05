package org.asb.mule.probe.framework.entity;

import com.alcatelsbell.nms.common.crud.annotation.BField;
import com.alcatelsbell.nms.valueobject.BObject; 

import javassist.SerialVersionUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.util.Date;

/**
 * Author: Ronnie.Chen Date: 14-3-26 Time: 下午4:02
 * rongrong.chen@alcatel-sbell.com.cn
 * 
 * EDS= Ems Data Summary
 */
@Entity
@Table(name = "EDS_PTN")
public class EDS_PTN extends BObject {
	
	private static final long serialVersionUID = -1;
	  
	public EDS_PTN(String emsname, Date collectTime, String taskSerial,
			Integer neCount, Integer slotCount, Integer subSlotCount,
			Integer equipmentCount, Integer ptpCount, Integer ftpCount,
			Integer sectionCount, Integer tunnelCount, Integer pwCount,
			Integer pwe3Count, Integer routeCount, Integer tunnelPG) {
		this.emsname = emsname;
		this.collectTime = collectTime;
		this.taskSerial = taskSerial;
		this.neCount = neCount;
		this.slotCount = slotCount;
		this.subSlotCount = subSlotCount;
		this.equipmentCount = equipmentCount;
		this.ptpCount = ptpCount;
		this.ftpCount = ftpCount;
		this.sectionCount = sectionCount;
		this.tunnelCount = tunnelCount;
		this.pwCount = pwCount;
		this.pwe3Count = pwe3Count;
		this.routeCount = routeCount;
		this.tunnelPG = tunnelPG;
	}

	public EDS_PTN() {
	}

	@BField(description = "EMS名称", createType = BField.CreateType.REQUIRED, editType = BField.EditType.HIDE, searchType = BField.SearchType.NULLABLE, mergeType = BField.MergeType.RESERVED, dnField = "name", dnReferenceEntityName = "com.alcatelsbell.cdcp.nbi.model.CEMS")
	private String emsname;

	@BField(description = "结束时间", searchType = BField.SearchType.NULLABLE)
	private Date collectTime;

	@BField(description = "开始时间", searchType = BField.SearchType.NULLABLE)
	private Date startTime;

	@BField(description = "任务编号", searchType = BField.SearchType.NULLABLE)
	private String taskSerial;

	@BField(description = "NE总数")
	private Integer neCount;
	@BField(description = "SLOT总数")
	private Integer slotCount;
	@BField(description = "SUBSLOT总数")
	private Integer subSlotCount;
	@BField(description = "EQUIPMENT总数")
	private Integer equipmentCount;
	@BField(description = "PTP总数")
	private Integer ptpCount;
	@BField(description = "FTP总数")
	private Integer ftpCount;
	@BField(description = "SECTION总数")
	private Integer sectionCount;
	@BField(description = "TUNNEL总数")
	private Integer tunnelCount;
	@BField(description = "PW总数")
	private Integer pwCount;
	@BField(description = "PWE3总数")
	private Integer pwe3Count;
	@BField(description = "ROUTE总数")
	private Integer routeCount;

	@BField(description = "TUNNELPG总数")
	private Integer tunnelPG;

	@BField(description = "网元交叉总数")
	private Integer ccCount;
	@BField(description = "子网交叉总数")
	private Integer sncCount;
	@BField(description = "EMS类型")
	private String emsType;

	@BField(description = "")
	private String timeCost;

	@BField(description = "备注")
	@Column(length = 2048)
	private String additinalInfo;

	@BField(description = "CTP总数")
	private Integer ctpCount;

	public Integer getCtpCount() {
		return ctpCount;
	}

	public void setCtpCount(Integer ctpCount) {
		this.ctpCount = ctpCount;
	}

	public String getEmsType() {
		return emsType;
	}

	public void setEmsType(String emsType) {
		this.emsType = emsType;
	}

	public Integer getSncCount() {
		return sncCount;
	}

	public void setSncCount(Integer sncCount) {
		this.sncCount = sncCount;
	}

	public Integer getCcCount() {
		return ccCount;
	}

	public void setCcCount(Integer ccCount) {
		this.ccCount = ccCount;
	}

	public String getEmsname() {
		return emsname;
	}

	public void setEmsname(String emsname) {
		this.emsname = emsname;
	}

	public Date getCollectTime() {
		return collectTime;
	}

	public void setCollectTime(Date collectTime) {
		this.collectTime = collectTime;
	}

	public String getTaskSerial() {
		return taskSerial;
	}

	public void setTaskSerial(String taskSerial) {
		this.taskSerial = taskSerial;
	}

	public Integer getNeCount() {
		return neCount;
	}

	public void setNeCount(Integer neCount) {
		this.neCount = neCount;
	}

	public Integer getSlotCount() {
		return slotCount;
	}

	public void setSlotCount(Integer slotCount) {
		this.slotCount = slotCount;
	}

	public Integer getSubSlotCount() {
		return subSlotCount;
	}

	public void setSubSlotCount(Integer subSlotCount) {
		this.subSlotCount = subSlotCount;
	}

	public Integer getEquipmentCount() {
		return equipmentCount;
	}

	public void setEquipmentCount(Integer equipmentCount) {
		this.equipmentCount = equipmentCount;
	}

	public Integer getPtpCount() {
		return ptpCount;
	}

	public void setPtpCount(Integer ptpCount) {
		this.ptpCount = ptpCount;
	}

	public Integer getFtpCount() {
		return ftpCount;
	}

	public void setFtpCount(Integer ftpCount) {
		this.ftpCount = ftpCount;
	}

	public Integer getSectionCount() {
		return sectionCount;
	}

	public void setSectionCount(Integer sectionCount) {
		this.sectionCount = sectionCount;
	}

	public Integer getTunnelCount() {
		return tunnelCount;
	}

	public void setTunnelCount(Integer tunnelCount) {
		this.tunnelCount = tunnelCount;
	}

	public Integer getPwCount() {
		return pwCount;
	}

	public void setPwCount(Integer pwCount) {
		this.pwCount = pwCount;
	}

	public Integer getPwe3Count() {
		return pwe3Count;
	}

	public void setPwe3Count(Integer pwe3Count) {
		this.pwe3Count = pwe3Count;
	}

	public Integer getRouteCount() {
		return routeCount;
	}

	public void setRouteCount(Integer routeCount) {
		this.routeCount = routeCount;
	}

	public Integer getTunnelPG() {
		return tunnelPG;
	}

	public void setTunnelPG(Integer tunnelPG) {
		this.tunnelPG = tunnelPG;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public String getTimeCost() {
		return timeCost;
	}

	public void setTimeCost(String timeCost) {
		this.timeCost = timeCost;
	}

	public String getAdditinalInfo() {
		return additinalInfo;
	}

	public void setAdditinalInfo(String additinalInfo) {
		this.additinalInfo = additinalInfo;
	}


	@Override
	public String toString() {
		return "EDS_PTN{" + "emsname='" + emsname + '\'' + ", collectTime="
				+ collectTime + ", startTime=" + startTime + ", taskSerial='"
				+ taskSerial + '\'' + ", neCount=" + neCount + ", slotCount="
				+ slotCount + ", subSlotCount=" + subSlotCount
				+ ", equipmentCount=" + equipmentCount + ", ptpCount="
				+ ptpCount + ", ftpCount=" + ftpCount + ", sectionCount="
				+ sectionCount + ", tunnelCount=" + tunnelCount + ", pwCount="
				+ pwCount + ", pwe3Count=" + pwe3Count + ", routeCount="
				+ routeCount + ", tunnelPG=" + tunnelPG + ", ccCount="
				+ ccCount + ", sncCount=" + sncCount + ", emsType='" + emsType
				+ '\'' + ", timeCost='" + timeCost + '\'' + ", additinalInfo='"
				+ additinalInfo + '\'' + ", ctpCount=" + ctpCount + '}';
	}
}
