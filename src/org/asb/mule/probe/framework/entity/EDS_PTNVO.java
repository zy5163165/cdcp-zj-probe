package org.asb.mule.probe.framework.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EDS_PTNVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EDS_PTNVO() {
		// TODO Auto-generated constructor stub
	}

	private String emsname;
	private Date collectTime;
	private Date startTime;
	private String taskSerial;
	private Integer neCount;
	private Integer slotCount;
	private Integer subSlotCount;
	private Integer equipmentCount;
	private Integer ptpCount;
	private Integer ftpCount;
	private Integer sectionCount;
	private Integer tunnelCount;
	private Integer pwCount;
	private Integer pwe3Count;
	private Integer routeCount;
	private Integer tunnelPG;
	private Integer ccCount;
	private Integer sncCount;
	private String emsType;
	private String timeCost;
	private String additinalInfo;
	private Integer ctpCount;

	private Long id;
	private Date createDate;
	private String dn;
	private int fromWhere;
	private Date updateDate;

	private int groupCount;

	private List<EDS_PTNVO> edsPTNVOs;

	public List<EDS_PTNVO> getEdsPTNVOs() {
		if (edsPTNVOs == null)
			edsPTNVOs = new ArrayList<EDS_PTNVO>();
		return edsPTNVOs;
	}

	public void setEdsPTNVOs(List<EDS_PTNVO> edsPTNVOs) {
		this.edsPTNVOs = edsPTNVOs;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDn() {
		return dn;
	}

	public void setDn(String dn) {
		this.dn = dn;
	}

	public int getFromWhere() {
		return fromWhere;
	}

	public void setFromWhere(int fromWhere) {
		this.fromWhere = fromWhere;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public int getGroupCount() { 
		return groupCount;
	}

	public void setGroupCount(int groupCount) {
		this.groupCount = groupCount;
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

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
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

	public Integer getCcCount() {
		return ccCount;
	}

	public void setCcCount(Integer ccCount) {
		this.ccCount = ccCount;
	}

	public Integer getSncCount() {
		return sncCount;
	}

	public void setSncCount(Integer sncCount) {
		this.sncCount = sncCount;
	}

	public String getEmsType() {
		return emsType;
	}

	public void setEmsType(String emsType) {
		this.emsType = emsType;
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

	public Integer getCtpCount() {
		return ctpCount;
	}

	public void setCtpCount(Integer ctpCount) {
		this.ctpCount = ctpCount;
	}

}
