package org.asb.mule.probe.framework.entity.spn;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.alcatelsbell.nms.valueobject.BObject;

@Entity
@Table(name = "MCS")

public class MCS extends BObject {
	String rmUID;
	String MtnChannelrmUID;
	String routingNo;
	String inPortrmUID;
	String outPortrmUID;
	String nermUID;
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
	public String getRoutingNo() {
		return routingNo;
	}
	public void setRoutingNo(String routingNo) {
		this.routingNo = routingNo;
	}
	public String getInPortrmUID() {
		return inPortrmUID;
	}
	public void setInPortrmUID(String inPortrmUID) {
		this.inPortrmUID = inPortrmUID;
	}
	public String getOutPortrmUID() {
		return outPortrmUID;
	}
	public void setOutPortrmUID(String outPortrmUID) {
		this.outPortrmUID = outPortrmUID;
	}
	public String getNermUID() {
		return nermUID;
	}
	public void setNermUID(String nermUID) {
		this.nermUID = nermUID;
	}

	
}
