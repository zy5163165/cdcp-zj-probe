package com.alcatelsbell.cdcp.nodefx.exception;

import com.alcatelsbell.cdcp.nodefx.NodeException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Author: Ronnie.Chen
 * Date: 2014/11/18
 * Time: 20:58
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class EmsFunctionInvokeException  extends NodeException {
    private Log logger = LogFactory.getLog(getClass());
    public static final String EXCEPTION_CODE = "FUNCTION_INVOKE:";
    public EmsFunctionInvokeException(String functionCode,Throwable e) {
        this(functionCode,e, "");
    }

    public EmsFunctionInvokeException(String functionCode,Throwable e,String msg) {
        super(EXCEPTION_CODE+functionCode,msg,e);
    }
}
