/**
 * 
 */
package org.asb.mule.probe.framework.nbi.job;

import org.apache.log4j.Logger;
import org.asb.mule.probe.framework.service.NbiService;
import org.asb.mule.probe.framework.util.ProbeLog;
import org.quartz.StatefulJob;

import java.util.HashMap;

/**
 * @author lingp
 * 
 */
public abstract class MigrateCommonJob implements StatefulJob {
	// protected Logger nbilog = ProbeLog.getInstance().getNbiLog();
	// protected Logger sbilog = ProbeLog.getInstance().getSbiLog();

	protected NbiService service;
	protected String serial = null;
	protected static final String EMS_TYPE_SDH = "SDH";
	protected static final String EMS_TYPE_PTN = "PTN";
	protected static final String EMS_TYPE_OTN = "OTN";
	protected static final String EMS_TYPE_DWDM = "DWDM";

	public boolean logical = true;

	protected HashMap<String,String> attributes = new HashMap<String, String>();

	public HashMap<String, String> getAttributes() {
		return attributes;
	}

	public void setService(NbiService service) {
		this.service = service;
	}

	public NbiService getService() {
		return service;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

}
