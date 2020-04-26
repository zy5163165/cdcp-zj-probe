package org.asb.mule.probe.framework.entity.spn;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.alcatelsbell.nms.valueobject.BObject;

@Entity
@Table(name = "MPI")

public class MPI extends BObject {
	String rmUID;
	String nativeName;
	String ringID;
	public String getRmUID() {
		return rmUID;
	}
	public void setRmUID(String rmUID) {
		this.rmUID = rmUID;
	}
	public String getNativeName() {
		return nativeName;
	}
	public void setNativeName(String nativeName) {
		this.nativeName = nativeName;
	}
	public String getRingID() {
		return ringID;
	}
	public void setRingID(String ringID) {
		this.ringID = ringID;
	}

	
}
