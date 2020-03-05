package com.alcatelsbell.cdcp.nodefx.exception;

import com.alcatelsbell.cdcp.nodefx.NodeException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Author: Ronnie.Chen
 * Date: 2014/11/18
 * Time: 20:57
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class EmsLoginFailureException  extends NodeException {
    private Log logger = LogFactory.getLog(getClass());
    public static final String EXCEPTION_CODE = "LOGIN_FAILURE";
    public EmsLoginFailureException(Throwable e) {
        this(e, "");
    }

    public EmsLoginFailureException(Throwable e,String msg) {
        super(EXCEPTION_CODE,msg,e);
    }
}