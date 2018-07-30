package org.asb.mule.probe.framework.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.alcatelsbell.nms.valueobject.BObject;

@Entity
@Table(name = "PRT")

public class PRT extends BObject {
	
	String rmUID;
	String nermUID;
	String cardrmUID;
	String holderrmUID;
	String portNo;
	String nativeName;
	String physicalOrLogical;
	String signalType;
	String portRate;
	String direction;
	String waveNum;
	String portType;
	
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
	public String getCardrmUID() {
		return cardrmUID;
	}
	public void setCardrmUID(String cardrmUID) {
		this.cardrmUID = cardrmUID;
	}
	public String getHolderrmUID() {
		return holderrmUID;
	}
	public void setHolderrmUID(String holderrmUID) {
		this.holderrmUID = holderrmUID;
	}
	public String getPortNo() {
		return portNo;
	}
	public void setPortNo(String portNo) {
		this.portNo = portNo;
	}
	public String getNativeName() {
		return nativeName;
	}
	public void setNativeName(String nativeName) {
		this.nativeName = nativeName;
	}
	public String getPhysicalOrLogical() {
		return physicalOrLogical;
	}
	public void setPhysicalOrLogical(String physicalOrLogical) {
		this.physicalOrLogical = physicalOrLogical;
	}
	public String getSignalType() {
		return signalType;
	}
	public void setSignalType(String signalType) {
		this.signalType = signalType;
	}
	public String getPortRate() {
		return portRate;
	}
	public void setPortRate(String portRate) {
		this.portRate = portRate;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getWaveNum() {
		return waveNum;
	}
	public void setWaveNum(String waveNum) {
		this.waveNum = waveNum;
	}
	public String getPortType() {
		return portType;
	}
	public void setPortType(String portType) {
		this.portType = portType;
	}
	
	
}
