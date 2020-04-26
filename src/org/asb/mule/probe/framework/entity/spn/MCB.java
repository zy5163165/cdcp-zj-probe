package org.asb.mule.probe.framework.entity.spn;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.alcatelsbell.nms.valueobject.BObject;

@Entity
@Table(name = "MCB")

public class MCB extends BObject {
	String rmUID;
	String MtnChannelrmUID;
	String role;
	public String getRmUID() {
		return rmUID;
	}
	public void setRmUID(String rmUID) {
		this.rmUID = rmUID;
	}
	public String getMtnChannelrmUID() {
		return MtnChannelrmUID;
	}
	public void setMtnChannelrmUID(String mtnChannelrmUID) {
		MtnChannelrmUID = mtnChannelrmUID;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	
}
