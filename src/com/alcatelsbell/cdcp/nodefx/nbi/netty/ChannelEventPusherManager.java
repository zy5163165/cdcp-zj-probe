package com.alcatelsbell.cdcp.nodefx.nbi.netty;

import com.alcatelsbell.cdcp.nodefx.SBIEvent;
import com.alcatelsbell.nms.common.SysUtil;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

/**
 * Author: Ronnie.Chen
 * Date: 2016/7/26
 * Time: 15:40
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class ChannelEventPusherManager {
    private Logger logger = LoggerFactory.getLogger(ChannelEventPusherManager.class);

    private static ChannelEventPusherManager ourInstance = new ChannelEventPusherManager();

    public static ChannelEventPusherManager getInstance() {
        return ourInstance;
    }

    private ChannelEventPusherManager() {
    }

    private Hashtable<String,ChannelEventPusher> pushers = new Hashtable<String, ChannelEventPusher>();
    public void handleMessage(ChannelHandlerContext ctx,NbiMessage message) {
         if (message.getMessage_type().equals("command")) {
             String channelId = ctx.channel().id().asLongText();
             ChannelEventPusher pusher = pushers.get(channelId);
             if (pusher == null) {
                 synchronized (pushers) {
                     pusher = pushers.get(channelId);
                     if (pusher == null) {
                         pusher = new ChannelEventPusher("Pusher:"+ctx.channel().toString(),ctx);

                         HashMap request = (HashMap)message.getBody().get("request");
                         if (request != null) {
                             List<String> ems_names = (List) (request.get("ems"));
                             if (ems_names != null) {
                                 for (String emsName : ems_names) {
                                     pusher.addEmsName(emsName);
                                     logger.info("emsname +=" + emsName);
                                 }

                             }
                         }
                         pusher.setRequestMessageId(message.getMessage_id());
                         pushers.put(channelId,pusher);
                         logger.info("pusher: start !");
                         pusher.start();
                     }
                 }
             }
         }
    }


    public synchronized void push(SBIEvent sbiEvent) {
        logger.info("pushed sbievent : "+sbiEvent);
        NbiMessage message = new NbiMessage(SysUtil.nextDN(),sbiEvent.getType(),null);
//        String kk = "alarm";
//        if (sbiEvent.getType() == "event")
//            kk = "event";

        message.getBody().put(sbiEvent.getType(),sbiEvent.getDataMap());
        message.getBody().put("ems",sbiEvent.getEmsDn());
    //    message.getBody().put("ems_name",sbiEvent.getEmsDn());

        Set<String> keys = pushers.keySet();
        for (String key : keys) {
            ChannelEventPusher pusher = pushers.get(key);
            if (!pusher.isConnected()) {
                pusher.stopPusher();
                pushers.remove(key);
                logger.info("remove channel : "+key);
            } else {
                pusher.offer(sbiEvent.getEmsDn(),message);
                logger.info("pusher out ! : "+message);
            }
        }
    }

}
