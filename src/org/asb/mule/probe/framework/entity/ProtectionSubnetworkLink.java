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
@Table(name = "ProtectionSubnetworkLink")
public class ProtectionSubnetworkLink extends BObject {
    private String protectionSubnetworkDn;
    private String srcTp;
    private String sinkTp;
    private String vc4List;

    public String getProtectionSubnetworkDn() {
        return protectionSubnetworkDn;
    }

    public void setProtectionSubnetworkDn(String protectionSubnetworkDn) {
        this.protectionSubnetworkDn = protectionSubnetworkDn;
    }

    public String getSrcTp() {
        return srcTp;
    }

    public void setSrcTp(String srcTp) {
        this.srcTp = srcTp;
    }

    public String getSinkTp() {
        return sinkTp;
    }

    public void setSinkTp(String sinkTp) {
        this.sinkTp = sinkTp;
    }

    public String getVc4List() {
        return vc4List;
    }

    public void setVc4List(String vc4List) {
        this.vc4List = vc4List;
    }
}
