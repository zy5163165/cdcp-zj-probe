package org.asb.mule.probe.framework.entity;

import com.alcatelsbell.nms.valueobject.BObject;

import javax.persistence.MappedSuperclass;

/**
 * Author: Ronnie.Chen
 * Date: 13-7-29
 * Time: 下午3:17
 * rongrong.chen@alcatel-sbell.com.cn
 */
@MappedSuperclass
public class EMSObject extends BObject {
    private Long sid;

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }
}
