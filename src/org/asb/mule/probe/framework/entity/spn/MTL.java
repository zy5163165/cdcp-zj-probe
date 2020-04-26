package org.asb.mule.probe.framework.entity.spn;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.alcatelsbell.nms.valueobject.BObject;

@Entity
@Table(name = "MTL")

public class MTL extends BObject {
	String rmUID;
	String tunnelrmUID;
	public String getRmUID() {
		return rmUID;
	}
	public void setRmUID(String rmUID) {
		this.rmUID = rmUID;
	}
	public String getTunnelrmUID() {
		return tunnelrmUID;
	}
	public void setTunnelrmUID(String tunnelrmUID) {
		this.tunnelrmUID = tunnelrmUID;
	}

	
}
