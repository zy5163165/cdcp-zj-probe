package org.asb.mule.probe.framework.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Index;

import com.alcatelsbell.nms.valueobject.BObject;

@Entity
@Table(name = "R_TrafficTrunk_CC_Section")
public class R_TrafficTrunk_CC_Section extends BObject {

	@Index(name = "trafficTrunDn_Index")
	private String trafficTrunDn = "";
	private String type = "";
	private String CcOrSectionDn = "";
	private String aEnd = "";
	private String zEnd = "";
	private String aPtp = "";
	private String zPtp = "";
	private String additionalInfo = "";

	/**
	 * @return the trafficTrunDn
	 */
	public String getTrafficTrunDn() {
		return trafficTrunDn;
	}

	/**
	 * @param trafficTrunDn
	 *            the trafficTrunDn to set
	 */
	public void setTrafficTrunDn(String trafficTrunDn) {
		this.trafficTrunDn = trafficTrunDn;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the ccOrSectionDn
	 */
	public String getCcOrSectionDn() {
		return CcOrSectionDn;
	}

	/**
	 * @param ccOrSectionDn
	 *            the ccOrSectionDn to set
	 */
	public void setCcOrSectionDn(String ccOrSectionDn) {
		CcOrSectionDn = ccOrSectionDn;
	}

	/**
	 * @return the aEnd
	 */
	public String getaEnd() {
		return aEnd;
	}

	/**
	 * @param aEnd
	 *            the aEnd to set
	 */
	public void setaEnd(String aEnd) {
		this.aEnd = aEnd;
	}

	/**
	 * @return the zEnd
	 */
	public String getzEnd() {
		return zEnd;
	}

	/**
	 * @param zEnd
	 *            the zEnd to set
	 */
	public void setzEnd(String zEnd) {
		this.zEnd = zEnd;
	}

	/**
	 * @return the aPtp
	 */
	public String getaPtp() {
		return aPtp;
	}

	/**
	 * @param aPtp
	 *            the aPtp to set
	 */
	public void setaPtp(String aPtp) {
		this.aPtp = aPtp;
	}

	/**
	 * @return the zPtp
	 */
	public String getzPtp() {
		return zPtp;
	}

	/**
	 * @param zPtp
	 *            the zPtp to set
	 */
	public void setzPtp(String zPtp) {
		this.zPtp = zPtp;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
}
