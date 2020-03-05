package org.asb.mule.probe.framework.entity;

import com.alcatelsbell.nms.valueobject.BObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashMap;

/**
 * Author: Ronnie.Chen
 * Date: 2016/7/13
 * Time: 9:58
 * rongrong.chen@alcatel-sbell.com.cn
 */
@Entity
@Table(name = "EMSINFO")
public class EmsInfo  extends BObject {
    private String name;
    private String emsVersion;
    private String desc;
    private String host;
    private String port;
    private String username;
    private String password;
    private String loader;
    private String type;
    private String protocol;
    private String additionalInfo;
    private String scheduleType;
    private String scheduleExpression;
    private String power = "on";
    private String path ;
    private String url ;
    private String domain;
    private HashMap properties = new HashMap();

    public HashMap getProperties() {
        return properties;
    }

    @Override
    public String toString() {
        return "EmsInfo{" +
                "name='" + name + '\'' +
                ", emsVersion='" + emsVersion + '\'' +
                ", desc='" + desc + '\'' +
                ", host='" + host + '\'' +
                ", port='" + port + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", loader='" + loader + '\'' +
                ", type='" + type + '\'' +
                ", protocol='" + protocol + '\'' +
                ", additionalInfo='" + additionalInfo + '\'' +
                ", scheduleType='" + scheduleType + '\'' +
                ", scheduleExpression='" + scheduleExpression + '\'' +
                ", power='" + power + '\'' +
                ", path='" + path + '\'' +
                ", url='" + url + '\'' +
                ", domain='" + domain + '\'' +
                ", properties=" + properties +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getScheduleType() {
        return scheduleType;
    }

    public void setScheduleType(String scheduleType) {
        this.scheduleType = scheduleType;
    }

    public String getScheduleExpression() {
        return scheduleExpression;
    }

    public void setScheduleExpression(String scheduleExpression) {
        this.scheduleExpression = scheduleExpression;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmsVersion() {
        return emsVersion;
    }

    public void setEmsVersion(String emsVersion) {
        this.emsVersion = emsVersion;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoader() {
        return loader;
    }

    public void setLoader(String loader) {
        this.loader = loader;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }
}
