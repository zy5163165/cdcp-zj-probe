package com.alcatelsbell.cdcp.nodefx;

import com.alcatelsbell.nms.common.SysUtil;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Author: Ronnie.Chen
 * Date: 14-3-12
 * Time: 上午10:24
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class SBIEvent implements Serializable {
    private static final long serialVersionUID = -1187811066494970339L;
    private String serial = null;


    private String emsDn = null;
    private String deviceDn = null;
    private String type = null;
    private String sourceType = null;

    public static final String TYPE_ALARM = "ALARM";
    public static final String TYPE_NOTIFICATION = "NOTIFICATION";
    public static final String TYPE_EXCEPTION = "EXCEPTION";
    public static final String SOURCE_TYPE_EMS = "SOURCE_TYPE_EMS";
    public static final String SOURCE_TYPE_NODE = "SOURCE_TYPE_NODE";

    private HashMap dataMap = new HashMap();
    public SBIEvent(String emsDn,String deviceDn) {
        serial = SysUtil.nextDN();
        this.emsDn = emsDn;
        this.deviceDn = deviceDn;
    }

    public SBIEvent(String emsDn, String deviceDn, String type, String sourceType, HashMap dataMap) {
        this.emsDn = emsDn;
        this.deviceDn = deviceDn;
        this.type = type;
        this.sourceType = sourceType;
        this.dataMap = dataMap;
    }

    public SBIEvent() {

    }
    public HashMap getDataMap() {
        return dataMap;
    }

    public String getDeviceDn() {
        return deviceDn;
    }

    public void setDeviceDn(String deviceDn) {
        this.deviceDn = deviceDn;
    }

    public void setDataMap(HashMap dataMap) {
        this.dataMap = dataMap;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getEmsDn() {
        return emsDn;
    }

    public void setEmsDn(String emsDn) {
        this.emsDn = emsDn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    @Override
    public String toString() {
        return "SBIEvent{" +
                "serial='" + serial + '\'' +
                ", emsDn='" + emsDn + '\'' +
                ", deviceDn='" + deviceDn + '\'' +
                ", type='" + type + '\'' +
                ", sourceType='" + sourceType + '\'' +
                ", dataMap=" + dataMap +
                '}';
    }
}
