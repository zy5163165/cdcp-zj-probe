package com.alcatelsbell.cdcp.nodefx.nbi.netty;

import com.alcatelsbell.nms.common.SysUtil;
import com.alcatelsbell.nms.util.ObjectUtil;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Author: Ronnie.Chen
 * Date: 2016/7/27
 * Time: 9:06
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class ChannelEventPusher extends Thread {
    private Logger logger = LoggerFactory.getLogger(ChannelEventPusher.class);

    private ChannelHandlerContext channelHandlerContext = null;
    private LinkedBlockingQueue<NbiMessage> eventQueue = new LinkedBlockingQueue<NbiMessage>();

    private HashSet<String> emsNames = new HashSet<String>();
    private String requestMessageId;

    public String getRequestMessageId() {
        return requestMessageId;
    }

    public void setRequestMessageId(String requestMessageId) {
        this.requestMessageId = requestMessageId;
    }

    public ChannelEventPusher(String name, ChannelHandlerContext channelHandlerContext) {
        super(name);
        this.channelHandlerContext = channelHandlerContext;
    }


    public void addEmsName(String emsName) {
        emsNames.add(emsName);
    }

    public void offer(String emsName,NbiMessage message) {
        if (emsNames.isEmpty() || emsNames.contains(emsName))
            eventQueue.offer(message);
    }

    public boolean isConnected() {
        return channelHandlerContext.channel().isOpen();
        //return connected;
    }

    public void stopPusher() {
        this.interrupt();
    }

    int idx = 0;
    @Override
    public void run() {
        NbiMessage m = new NbiMessage(SysUtil.nextDN(),"command","");
        HashMap response = new HashMap();
        response.put("request_message_id",requestMessageId);
        response.put("result","ok");
        response.put("info","");

        m.getBody().put("response",response);
   //     m = (NbiMessage)ObjectUtil.readObjectByPath("d:\\message_1");
        channelHandlerContext.writeAndFlush(m);
        while (true) {
            NbiMessage message = null;
            try {
                message = eventQueue.take();
            } catch (InterruptedException e) {
            //    logger.info("interrupted .");
                break;
            }
            try {
                logger.info("write message : "+message);

                channelHandlerContext.writeAndFlush(message);
          //      ObjectUtil.saveObject("message_"+(idx++),message);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }

        logger.info(getName()+" pusher stopped .");


    }
}
