package org.asb.mule.probe.framework.entity;






public class StaticMacAddress 
{
	
	
	private String staticMacType="";
	private String macAddress="";
	private String peVID="";
	private String ceVID = "";
	private String tpName="";
	private String additionalInfo = "";
	/**
	 * @return the staticMacType
	 */
	public String getStaticMacType() {
		return staticMacType;
	}
	/**
	 * @param staticMacType the staticMacType to set
	 */
	public void setStaticMacType(String staticMacType) {
		this.staticMacType = staticMacType;
	}
	/**
	 * @return the macAddress
	 */
	public String getMacAddress() {
		return macAddress;
	}
	/**
	 * @param macAddress the macAddress to set
	 */
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	/**
	 * @return the peVID
	 */
	public String getPeVID() {
		return peVID;
	}
	/**
	 * @param peVID the peVID to set
	 */
	public void setPeVID(String peVID) {
		this.peVID = peVID;
	}
	/**
	 * @return the ceVID
	 */
	public String getCeVID() {
		return ceVID;
	}
	/**
	 * @param ceVID the ceVID to set
	 */
	public void setCeVID(String ceVID) {
		this.ceVID = ceVID;
	}
	/**
	 * @return the tpName
	 */
	public String getTpName() {
		return tpName;
	}
	/**
	 * @param tpName the tpName to set
	 */
	public void setTpName(String tpName) {
		this.tpName = tpName;
	}
	/**
	 * @return the additionalInfo
	 */
	public String getAdditionalInfo() {
		return additionalInfo;
	}
	/**
	 * @param additionalInfo the additionalInfo to set
	 */
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StaticMacAddress [additionalInfo=" + additionalInfo
				+ ", ceVID=" + ceVID + ", macAddress=" + macAddress
				+ ", peVID=" + peVID + ", staticMacType=" + staticMacType
				+ ", tpName=" + tpName + "]";
	}
	

}
