package com.alcatelsbell.cdcp.nodefx;

import com.alcatelsbell.nms.valueobject.sys.Ems;

import java.io.Serializable;
import java.net.URI;

/**
 * Author: Ronnie.Chen
 * Date: 14-5-9
 * Time: 下午1:06
 * rongrong.chen@alcatel-sbell.com.cn
 */
public interface EmsAdapterWithURISupport extends EmsAdapter {
    /**
     *
     * @param uri
     *
     * exp :  cdcp://HWU2000-HZ/resource/neinfo#12345
     * schema=cdcp
     * authority=HWU2000-HZ
     * path=/resource/neinfo
     * fragment=12345
     *
     * @return
     * @throws Exception
     */
    public Serializable obtain(Ems ems,URI uri) throws Exception;
    public Serializable obtain(Ems ems,String uri) throws Exception;
}
