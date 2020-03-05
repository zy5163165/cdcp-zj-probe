package org.asb.mule.probe.framework.entity;

import com.alcatelsbell.nms.valueobject.BObject;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Author: Ronnie.Chen
 * Date: 13-7-29
 * Time: 下午4:48
 * rongrong.chen@alcatel-sbell.com.cn
 */
@Entity
@Table(name = "TopoNode")
public class TopoNode extends BObject{
    private String name;
    private String parent;
    private String nativeemsname;
    private String position;
    private String additionalInfo;

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getNativeemsname() {
        return nativeemsname;
    }

    public void setNativeemsname(String nativeemsname) {
        this.nativeemsname = nativeemsname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
