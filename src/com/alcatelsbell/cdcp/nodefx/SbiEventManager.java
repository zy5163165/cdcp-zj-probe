package com.alcatelsbell.cdcp.nodefx;

import com.alcatelsbell.cdcp.nodefx.nbi.netty.ChannelEventPusherManager;
import com.alcatelsbell.nms.util.SysProperty;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Author: Ronnie.Chen
 * Date: 2016/7/15
 * Time: 13:05
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class SbiEventManager {
    private Log logger = LogFactory.getLog(getClass());
    private static SbiEventManager ourInstance = new SbiEventManager();

    public static SbiEventManager getInstance() {
        return ourInstance;
    }

    private SbiEventManager() {
        final boolean eventToJms = SysProperty.getString("cdcp.sbi.event.jms","off").equalsIgnoreCase("on");
        final boolean eventToNetty = SysProperty.getString("cdcp.sbi.event.netty","off").equalsIgnoreCase("on");
        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        SBIEvent take = alarmQueue.take();
                        if (eventToJms)
                            MessageUtil.sendEmsEventMessage(take.getEmsDn(),take);
                        if (eventToNetty) {
                            ChannelEventPusherManager.getInstance().push(take);
                        }

                    } catch (Throwable e) {
                        logger.error(e, e);
                    }
                }
            }
        });
        consumer.start();
    }

    private LinkedBlockingQueue<SBIEvent> alarmQueue = new LinkedBlockingQueue(1000000);


    public LinkedBlockingQueue getQueue() {
        return alarmQueue;
    }
    public void offer(SBIEvent event) {
        alarmQueue.offer(event);
    }


}
