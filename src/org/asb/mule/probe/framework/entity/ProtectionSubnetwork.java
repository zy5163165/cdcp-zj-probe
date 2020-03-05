package org.asb.mule.probe.framework.entity;

import com.alcatelsbell.nms.valueobject.BObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Author: Ronnie.Chen
 * Date: 14-7-15
 * Time: 上午11:11
 * rongrong.chen@alcatel-sbell.com.cn
 */
@Entity
@Table(name = "ProtectionSubnetwork")
public class ProtectionSubnetwork extends BObject {
     private String name;
    private String nativeEmsName;
    private String layerRate;
    private String psnType;
    private String psnLinks;
    private String additionalInfo;
    private String neIds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNativeEmsName() {
        return nativeEmsName;
    }

    public void setNativeEmsName(String nativeEmsName) {
        this.nativeEmsName = nativeEmsName;
    }

    public String getLayerRate() {
        return layerRate;
    }

    public void setLayerRate(String layerRate) {
        this.layerRate = layerRate;
    }

    public String getPsnType() {
        return psnType;
    }

    public void setPsnType(String psnType) {
        this.psnType = psnType;
    }

    public String getPsnLinks() {
        return psnLinks;
    }

    public void setPsnLinks(String psnLinks) {
        this.psnLinks = psnLinks;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getNeIds() {
        return neIds;
    }

    public void setNeIds(String neIds) {
        this.neIds = neIds;
    }
}
