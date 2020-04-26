package org.asb.mule.probe.framework.entity.spn;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.alcatelsbell.nms.valueobject.BObject;

@Entity
@Table(name = "ETP")

public class ETP extends BObject {
	String rmUID;

	public String getRmUID() {
		return rmUID;
	}

	public void setRmUID(String rmUID) {
		this.rmUID = rmUID;
	}
	
}
