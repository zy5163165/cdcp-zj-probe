package org.asb.mule.probe.framework.entity;


import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Index;

import com.alcatelsbell.nms.valueobject.BObject;





@Entity
@Table(name = "R_FTP_PTP")

public class R_FTP_PTP extends BObject
{
	
	@Index(name="ftp_Index")
	private String ftpDn="";
	private String tpMappingMode="";
	private String rate="";
	private String transmissionParams = "";
	private String ptpDn="";
	/**
	 * @return the ftpDn
	 */
	public String getFtpDn() {
		return ftpDn;
	}
	/**
	 * @param ftpDn the ftpDn to set
	 */
	public void setFtpDn(String ftpDn) {
		this.ftpDn = ftpDn;
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
	public void setPtpDn(String ptpDn) {
		this.ptpDn = ptpDn;
	}
	public String getPtpDn() {
		return ptpDn;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "R_FTP_PTP [ftpDn=" + ftpDn + ", ptpDn=" + ptpDn + ", rate="
				+ rate + ", tpMappingMode=" + tpMappingMode
				+ ", transmissionParams=" + transmissionParams + "]";
	}
	
}
