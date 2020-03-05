package com.alcatelsbell.cdcp.nodefx.nbi.netty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

/**
 * Author: Ronnie.Chen
 * Date: 2016/7/27
 * Time: 10:29
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class ServerTester {
    private Logger logger = LoggerFactory.getLogger(ServerTester.class);

    public static void main(final String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            public void run() {
                try {
                    CdcpNettyServer.main(args);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(runnable).start();

        int count = 0;
        while (true) {
            Thread.sleep(1000l);
            HashMap alarm = new HashMap();
//            alarm.put("alarmid","alarm:"+(count++));
//            alarm.put("alarmname","fatalalarm");
//            ChannelEventPusherManager.getInstance().push("emsname",alarm);
        }
    }
}
