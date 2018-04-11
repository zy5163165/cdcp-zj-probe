package com.alcatelsbell.cdcp.nodefx;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.Serializable;

/**
 * Author: Ronnie.Chen
 * Date: 14-3-12
 * Time: 下午3:54
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class ObjectInfo implements Serializable {
    private String token;

    public ObjectInfo(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "ObjectInfo{" +
                "token='" + token + '\'' +
                '}';
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
