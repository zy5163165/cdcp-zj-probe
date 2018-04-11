package com.alcatelsbell.cdcp.nodefx;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Author: Ronnie.Chen
 * Date: 13-9-11
 * Time: 下午2:11
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class FtpInfo implements Serializable {
    public static final String TYPE_FTP = "FTP";
    public static final String TYPE_SFTP = "SFTP";

    private String username;
    private String password;
    private String host;
    private int port;
    private String remoteFilePath;
    private String fileName;
    private String type;
    private HashMap<String,String> attributes = new HashMap<String, String>();

    public HashMap<String, String> getAttributes() {
        return attributes;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getRemoteFilePath() {
        return remoteFilePath;
    }

    public void setRemoteFilePath(String remoteFilePath) {
        this.remoteFilePath = remoteFilePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public FtpInfo(String username, String password, String host, int port, String remoteFilePath, String fileName) {
        this.username = username;
        this.password = password;
        this.host = host;
        this.port = port;
        this.remoteFilePath = remoteFilePath;
        this.fileName = fileName;
    }


    @Override
    public String toString() {
        return "FtpInfo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", host='" + host + '\'' +
                ", port=" + port +
                ", remoteFilePath='" + remoteFilePath + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
