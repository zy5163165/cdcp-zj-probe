package com.alcatelsbell.cdcp.nodefx;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author: Ronnie.Chen
 * Date: 13-9-10
 * Time: 下午3:38
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class CdcpMessage implements Serializable {
    private String type;
    private String nodeDName;
    private String nodeName;
    private String ipAddress;
    private String workPath;
    private String physicalAddress;
    private int jmxmpPort;
    private int jmxHtmlPort;
    private ConcurrentHashMap attributes = new ConcurrentHashMap();
    private String serialId;
    private Serializable object;

    public CdcpMessage() {

    }
    public String getNodeDName() {
        return nodeDName;
    }

    public void setNodeDName(String nodeDName) {
        this.nodeDName = nodeDName;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getWorkPath() {
        return workPath;
    }

    public void setWorkPath(String workPath) {
        this.workPath = workPath;
    }

    public String getPhysicalAddress() {
        return physicalAddress;
    }

    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    public int getJmxmpPort() {
        return jmxmpPort;
    }

    public void setJmxmpPort(int jmxmpPort) {
        this.jmxmpPort = jmxmpPort;
    }

    public int getJmxHtmlPort() {
        return jmxHtmlPort;
    }

    public void setJmxHtmlPort(int jmxHtmlPort) {
        this.jmxHtmlPort = jmxHtmlPort;
    }

    public Object getAttribute(String key) {
        return attributes.get(key);
    }

    public void setAttribute(String key,Object value) {
        attributes.put(key,value);
    }

    public String getSerialId() {
        return serialId;
    }

    public void setSerialId(String serialId) {
        this.serialId = serialId;
    }

    public Serializable getObject() {
        return object;
    }

    public void setObject(Serializable object) {
        this.object = object;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CdcpMessage{" +
                "type='" + type + '\'' +
                ", nodeDName='" + nodeDName + '\'' +
                ", nodeName='" + nodeName + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", workPath='" + workPath + '\'' +
                ", physicalAddress='" + physicalAddress + '\'' +
                ", jmxmpPort=" + jmxmpPort +
                ", jmxHtmlPort=" + jmxHtmlPort +
                ", attributes=" + attributes +
                ", serialId='" + serialId + '\'' +
                ", object=" + object +
                '}';
    }
}
