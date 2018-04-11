package com.alcatelsbell.cdcp.nodefx.exception;

import com.alcatelsbell.cdcp.nodefx.NodeException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Author: Ronnie.Chen
 * Date: 2014/11/18
 * Time: 21:01
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class EmsDataIllegalException extends NodeException{
    private Log logger = LogFactory.getLog(getClass());
    public static final String EXCEPTION_CODE = "DATA_ILLEGAL:";
    public EmsDataIllegalException(String dataCode,Throwable e) {
        this(dataCode,e, "");
    }

    public EmsDataIllegalException(String dataCode,Throwable e,String msg) {
        super(EXCEPTION_CODE+dataCode,msg,e);
    }
}
