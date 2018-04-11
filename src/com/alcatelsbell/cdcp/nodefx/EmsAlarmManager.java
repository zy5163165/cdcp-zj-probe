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

/**
 *  @see  SbiEventManager
 */
@Deprecated
public class EmsAlarmManager {
    private Log logger = LogFactory.getLog(getClass());
    private static EmsAlarmManager ourInstance = new EmsAlarmManager();

    public static EmsAlarmManager getInstance() {
        return ourInstance;
    }

    private EmsAlarmManager() {
        final boolean eventToJms = SysProperty.getString("cdcp.sbi.event.jms","off").equalsIgnoreCase("on");
        final boolean eventToNetty = SysProperty.getString("cdcp.sbi.event.netty","off").equalsIgnoreCase("on");
        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Serializable take = alarmQueue.take();
                        if (eventToJms)
                            MessageUtil.sendEmsAlarmMessage(take);
                        if (eventToNetty) {
                            HashMap data = (HashMap)take;
                        //    ChannelEventPusherManager.getInstance().notifyAlarm((String)data.get("emsname"),(HashMap)data.get("alarm"));
                        }

                    } catch (Throwable e) {
                        logger.error(e, e);
                    }
                }
            }
        });
        consumer.start();
    }

    private LinkedBlockingQueue<Serializable> alarmQueue = new LinkedBlockingQueue(1000000);


    public LinkedBlockingQueue getQueue() {
        return alarmQueue;
    }
    public void offer(String emsname, Serializable alarm) {
        HashMap data = new HashMap();
        data.put("emsname",emsname);
        data.put("alarm",alarm);
        alarmQueue.offer(data);

    }


}
