/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.alcatelsbell.cdcp.nodefx.nbi.netty.client;

import com.alcatelsbell.cdcp.nodefx.nbi.netty.NbiMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Handler implementation for the object echo client.  It initiates the
 * ping-pong traffic between the object echo client and server by sending the
 * first message to the server.
 */
public class NbiClientHandler extends ChannelInboundHandlerAdapter {

    private final List<Integer> firstMessage;
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * Creates a client-side handler.
     */
    public NbiClientHandler() {
        firstMessage = new ArrayList<Integer>(NbiClient.SIZE);
        for (int i = 0; i < NbiClient.SIZE; i ++) {
            firstMessage.add(Integer.valueOf(i));
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        // Send the first message if this handler is a client-side handler.
 //       ctx.writeAndFlush(firstMessage);
//        System.out.println("flush : "+json);
        NbiMessage msg = new NbiMessage("-1", "Receive_Alarm", "test_client");
       // msg.getBody().put("EmsName","");
        ctx.writeAndFlush(msg);
        logger.info("send message : "+msg);
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        logger.info("channelRead:"+msg);
        // Echo back the received object to the server.
        //ctx.write(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
