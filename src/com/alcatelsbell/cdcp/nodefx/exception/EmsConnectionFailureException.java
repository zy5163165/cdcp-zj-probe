package com.alcatelsbell.cdcp.nodefx.exception;

import com.alcatelsbell.cdcp.nodefx.NodeException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Author: Ronnie.Chen
 * Date: 2014/11/18
 * Time: 20:53
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class EmsConnectionFailureException extends NodeException {
    public static final String EXCEPTION_CODE = "CONNECT_FAILURE";
    private Log logger = LogFactory.getLog(getClass());
    public EmsConnectionFailureException(Throwable e) {
        this(e, "");
    }

    public EmsConnectionFailureException(Throwable e,String msg) {
        super(EXCEPTION_CODE,msg,e);
        this.setExceptionDetail(msg);
    }

}
