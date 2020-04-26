package org.asb.mule.probe.framework.entity.spn;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.alcatelsbell.nms.valueobject.BObject;

@Entity
@Table(name = "PRB")

public class PRB extends BObject {
	
	String rmUID;
	String nermUID;
	String phyPortrmUID;
	String phyPortParentCardrmUID;
	String logPortParentCardrmUID;
	
	public String getRmUID() {
		return rmUID;
	}
	public void setRmUID(String rmUID) {
		this.rmUID = rmUID;
	}
	public String getNermUID() {
		return nermUID;
	}
	public void setNermUID(String nermUID) {
		this.nermUID = nermUID;
	}
	public String getPhyPortrmUID() {
		return phyPortrmUID;
	}
	public void setPhyPortrmUID(String phyPortrmUID) {
		this.phyPortrmUID = phyPortrmUID;
	}
	public String getPhyPortParentCardrmUID() {
		return phyPortParentCardrmUID;
	}
	public void setPhyPortParentCardrmUID(String phyPortParentCardrmUID) {
		this.phyPortParentCardrmUID = phyPortParentCardrmUID;
	}
	public String getLogPortParentCardrmUID() {
		return logPortParentCardrmUID;
	}
	public void setLogPortParentCardrmUID(String logPortParentCardrmUID) {
		this.logPortParentCardrmUID = logPortParentCardrmUID;
	}
	
	
	

	
}
