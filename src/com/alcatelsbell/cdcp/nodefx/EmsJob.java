package com.alcatelsbell.cdcp.nodefx;

import com.alcatelsbell.nms.valueobject.sys.Ems;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Author: Ronnie.Chen
 * Date: 13-9-10
 * Time: 下午3:05
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class EmsJob implements Serializable {
    private Ems ems;
    private String serial;
    private HashMap dataMap = new HashMap();
    private String jobType = JOB_TYPE_SYNC_EMS;
    public static final String JOB_TYPE_SYNC_EMS = "SYNC_EMS";
    public static final String JOB_TYPE_SYNC_DEVICE = "SYNC_DEVICE";
    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Ems getEms() {
        return ems;
    }

    public void setEms(Ems ems) {
        this.ems = ems;
    }

    public HashMap getDataMap() {
        return dataMap;
    }

    public void setDataMap(HashMap dataMap) {
        this.dataMap = dataMap;
    }

    @Override
    public String toString() {
        return "EmsJob{" +
                "ems=" + ems.getDn() +
                ", serial='" + serial + '\'' +
                ", dataMap=" + dataMap +
                ", jobType='" + jobType + '\'' +
                '}';
    }
}
