package org.asb.mule.probe.framework.entity.spn;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.alcatelsbell.nms.valueobject.BObject;

@Entity
@Table(name = "IGT")

public class IGT extends BObject {
	String rmUID;
	String vNetrmUID;
	String nativeName;
	public String getRmUID() {
		return rmUID;
	}
	public void setRmUID(String rmUID) {
		this.rmUID = rmUID;
	}
	public String getvNetrmUID() {
		return vNetrmUID;
	}
	public void setvNetrmUID(String vNetrmUID) {
		this.vNetrmUID = vNetrmUID;
	}
	public String getNativeName() {
		return nativeName;
	}
	public void setNativeName(String nativeName) {
		this.nativeName = nativeName;
	}

	
}
