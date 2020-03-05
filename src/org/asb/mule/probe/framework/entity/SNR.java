package org.asb.mule.probe.framework.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.alcatelsbell.nms.valueobject.BObject;

@Entity
@Table(name = "SNR")

public class SNR extends BObject {
	
	String rmUID;
	String serverConnectionrmUID;
	
	public String getRmUID() {
		return rmUID;
	}
	public void setRmUID(String rmUID) {
		this.rmUID = rmUID;
	}
	public String getServerConnectionrmUID() {
		return serverConnectionrmUID;
	}
	public void setServerConnectionrmUID(String serverConnectionrmUID) {
		this.serverConnectionrmUID = serverConnectionrmUID;
	}
	
	
	
}
