package org.asb.mule.probe.framework.entity.spn;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.alcatelsbell.nms.valueobject.BObject;

@Entity
@Table(name = "IGL")

public class IGL extends BObject {
	String rmUID;
	String IGPTopormUID;
	String nativeName;
	String aEndNermUID;
	String aEndPortrmUID;
	String zEndNermUID;
	String zEndPortrmUID;
	String operateState;
	String bandwidth;
	public String getRmUID() {
		return rmUID;
	}
	public void setRmUID(String rmUID) {
		this.rmUID = rmUID;
	}
	public String getIGPTopormUID() {
		return IGPTopormUID;
	}
	public void setIGPTopormUID(String iGPTopormUID) {
		IGPTopormUID = iGPTopormUID;
	}
	public String getNativeName() {
		return nativeName;
	}
	public void setNativeName(String nativeName) {
		this.nativeName = nativeName;
	}
	public String getaEndNermUID() {
		return aEndNermUID;
	}
	public void setaEndNermUID(String aEndNermUID) {
		this.aEndNermUID = aEndNermUID;
	}
	public String getaEndPortrmUID() {
		return aEndPortrmUID;
	}
	public void setaEndPortrmUID(String aEndPortrmUID) {
		this.aEndPortrmUID = aEndPortrmUID;
	}
	public String getzEndNermUID() {
		return zEndNermUID;
	}
	public void setzEndNermUID(String zEndNermUID) {
		this.zEndNermUID = zEndNermUID;
	}
	public String getzEndPortrmUID() {
		return zEndPortrmUID;
	}
	public void setzEndPortrmUID(String zEndPortrmUID) {
		this.zEndPortrmUID = zEndPortrmUID;
	}
	public String getOperateState() {
		return operateState;
	}
	public void setOperateState(String operateState) {
		this.operateState = operateState;
	}
	public String getBandwidth() {
		return bandwidth;
	}
	public void setBandwidth(String bandwidth) {
		this.bandwidth = bandwidth;
	}

	
}
