package com.alcatelsbell.cdcp.nodefx;

import com.alcatelsbell.cdcp.nodefx.exception.EmsConnectionFailureException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.asb.mule.probe.framework.util.FileLogger;

import java.util.TimerTask;

/**
 * Author: Ronnie.Chen
 * Date: 2014/11/23
 * Time: 12:48
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class KeepAliveConnectionHeartBeat  extends TimerTask {
    private FileLogger sbilog = null;
    private KeepAliveConnection connection = null;

    public KeepAliveConnectionHeartBeat(KeepAliveConnection corbaService, FileLogger sbilog) {
        this.connection = corbaService;
        this.sbilog = sbilog;
    }

    @Override
    public void run() {
    //    sbilog.info("emsSession.ping >>>");
        if (connection != null ) {
            if (!connection.heartbeat()) {
            //    sbilog.error(">>>emsSession.ping Failed.");
                synchronized (connection) {
                    while (!connection.reconnect()) {
                        try {
                            Thread.sleep(60000l);
                        } catch (InterruptedException e) {
                        }
                    //    sbilog.error(">>>reconnect failed ,try again");
                    }
                }


                try {
                    String emsDn = connection.getKey();
                    MessageUtil.sendEmsExceptionMessage(emsDn, EmsConnectionFailureException.EXCEPTION_CODE,"",true);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                //corbaService.linkFailure();
                // corbaService.disconnect();
            }
        }
    }
}
