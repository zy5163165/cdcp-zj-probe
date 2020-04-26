package org.asb.mule.probe.framework.entity.spn;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.alcatelsbell.nms.valueobject.BObject;

@Entity
@Table(name = "MGB")

public class MGB extends BObject {
	String rmUID;
	String phyPortrmUID;
	public String getRmUID() {
		return rmUID;
	}
	public void setRmUID(String rmUID) {
		this.rmUID = rmUID;
	}
	public String getPhyPortrmUID() {
		return phyPortrmUID;
	}
	public void setPhyPortrmUID(String phyPortrmUID) {
		this.phyPortrmUID = phyPortrmUID;
	}

	
}
