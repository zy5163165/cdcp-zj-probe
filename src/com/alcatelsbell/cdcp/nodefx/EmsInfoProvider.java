package com.alcatelsbell.cdcp.nodefx;

import org.asb.mule.probe.framework.entity.EmsInfo;

import java.util.List;

/**
 * Author: Ronnie.Chen
 * Date: 2016/7/14
 * Time: 9:05
 * rongrong.chen@alcatel-sbell.com.cn
 */
public interface EmsInfoProvider {
    public List<EmsInfo> provide();
}
