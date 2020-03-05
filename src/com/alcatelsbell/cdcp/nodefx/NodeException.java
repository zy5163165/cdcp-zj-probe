package com.alcatelsbell.cdcp.nodefx;

import javax.xml.soap.Node;

/**
 * Author: Ronnie.Chen
 * Date: 13-9-1
 * Time: 下午6:09
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class NodeException extends Exception {
    private String exceptionCode;
    private String exceptionDetail;

    public NodeException(String msg, Throwable e) {
        super(msg,e);
    }

    public NodeException(String exceptionCode,String msg,Throwable e) {
        this(msg,e);
        this.exceptionCode = exceptionCode;
    }


    public NodeException(String msg) {
        super(msg);
    }
    public NodeException(Throwable msg) {
        super(msg);
    }

    public String getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(String exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    public String getExceptionDetail() {
        return exceptionDetail;
    }

    public void setExceptionDetail(String exceptionDetail) {
        this.exceptionDetail = exceptionDetail;
    }
}
