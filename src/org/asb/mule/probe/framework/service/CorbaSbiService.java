package org.asb.mule.probe.framework.service;

import com.alcatelsbell.cdcp.nodefx.EmsStateManager;
import com.alcatelsbell.cdcp.nodefx.MessageUtil;
import com.alcatelsbell.cdcp.nodefx.NodeException;
import org.apache.log4j.Logger;
import org.asb.mule.probe.framework.util.ProbeLog;




public abstract class CorbaSbiService implements SbiService {

	
	
	
	//protected Logger sbilog = ProbeLog.getInstance().getSbiLog();
	private String emsName = "";
	private String emsDn ="";//used as function input parameter
	
	//Naming service
	// ȷ������ORB����ip����������(jacorb.dns.enable,jacorb.ior_proxy_host,jacorb.ior_proxy_port)
	// on-������off-ip
	private String namingServiceDns = "";
	private String namingServiceIp = "";
	
	//corba login
	private String corbaUrl = "";
	private String corbaTree = "";
	private String corbaUserName = "";
	private String corbaPassword = "";
	
	private boolean connectState = false;





	public boolean reconnect() {
		disconnect();
	
		return connect();
	}
	/**
	 * @return the namingServiceDns
	 */
	public String getNamingServiceDns() {
		return namingServiceDns;
	}
	/**
	 * @param namingServiceDns the namingServiceDns to set
	 */
	public void setNamingServiceDns(String namingServiceDns) {
		this.namingServiceDns = namingServiceDns;
	}
	/**
	 * @return the namingServiceIp
	 */
	public String getNamingServiceIp() {
		return namingServiceIp;
	}
	/**
	 * @param namingServiceIp the namingServiceIp to set
	 */
	public void setNamingServiceIp(String namingServiceIp) {
		this.namingServiceIp = namingServiceIp;
	}
	/**
	 * @return the corbaUrl
	 */
	public String getCorbaUrl() {
		return corbaUrl;
	}
	/**
	 * @param corbaUrl the corbaUrl to set
	 */
	public void setCorbaUrl(String corbaUrl) {
		this.corbaUrl = corbaUrl;
	}
	/**
	 * @return the corbaUserName
	 */
	public String getCorbaUserName() {
		return corbaUserName;
	}
	/**
	 * @param corbaUserName the corbaUserName to set
	 */
	public void setCorbaUserName(String corbaUserName) {
		this.corbaUserName = corbaUserName;
	}
	/**
	 * @return the corbaPassword
	 */
	public String getCorbaPassword() {
		return corbaPassword;
	}
	/**
	 * @param corbaPassword the corbaPassword to set
	 */
	public void setCorbaPassword(String corbaPassword) {
		this.corbaPassword = corbaPassword;
	}
	public void setCorbaTree(String corbaTree) {
		this.corbaTree = corbaTree;
	}
	public String getCorbaTree() {
		return corbaTree;
	}
	public void setEmsName(String emsName) {
		this.emsName = emsName;
	}
	public String getEmsName() {
		return emsName;
	}
	public void setConnectState(boolean connectState) {
		this.connectState = connectState;
	}
	public boolean isConnectState() {
		return connectState;
	}
	public void setEmsDn(String emsDn) {
		this.emsDn = emsDn;
	}
	public String getEmsDn() {
		return emsDn;
	}

	public void handleException(NodeException ex) {
		
		if (getEmsDn() == null || getEmsDn().trim().isEmpty()) setEmsDn(getEmsName());

		EmsStateManager.getInstance().emsError(getEmsName(),ex,"Ems Exception:code:"+ex.getExceptionCode()+";msg:"+ex.getMessage());
		try {
			MessageUtil.sendEmsExceptionMessage(getEmsDn(),ex.getExceptionCode(),ex.getMessage(),false);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void handleExceptionRecover(String exceptionCode) {
		if (getEmsDn() == null || getEmsDn().trim().isEmpty()) setEmsDn(getEmsName());
		EmsStateManager.getInstance().emsOk(getEmsName(),"Ems Exception Recover:"+exceptionCode);
		try {
			MessageUtil.sendEmsExceptionMessage(getEmsDn(),exceptionCode,"",true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
