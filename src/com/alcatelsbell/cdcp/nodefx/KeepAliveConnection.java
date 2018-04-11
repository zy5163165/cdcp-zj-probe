package com.alcatelsbell.cdcp.nodefx;

import org.asb.mule.probe.framework.util.FileLogger;

import java.util.Timer;

/**
 * Author: Ronnie.Chen
 * Date: 2014/11/23
 * Time: 10:23
 * rongrong.chen@alcatel-sbell.com.cn
 */
public abstract class KeepAliveConnection {
    private Thread inUseThread = null;
    private String key ;
    public KeepAliveConnection() {

    }


    public KeepAliveConnection(String key) {
        this.key = key;
    }

    public void setInUse() {
        inUseThread = Thread.currentThread();
    }

    public void setUnUse() {
        inUseThread = null;
    }

    public boolean isInUse() {
        return inUseThread != null;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public abstract boolean checkConnection() ;

    public abstract boolean heartbeat();
    public abstract boolean reconnect() ;
    public abstract boolean disconnect() ;
    public abstract boolean connect() ;

    Timer timer  = null;
    public void startHeartBeat(KeepAliveConnection connection) {

        if (timer == null) {
            timer = new Timer("HeartBeat-" + connection.getKey());
        }
        FileLogger sbilog = new FileLogger(connection.getKey()+"-heartbeat.log");
        sbilog.info("startHeartBeat>>"+connection.getKey());
        KeepAliveConnectionHeartBeat heartBeat = new KeepAliveConnectionHeartBeat(connection, sbilog);
        timer.scheduleAtFixedRate(heartBeat, 5000L, 30 * 1000L);
    }


}
