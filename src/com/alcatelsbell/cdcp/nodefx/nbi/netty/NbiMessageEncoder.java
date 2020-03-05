package com.alcatelsbell.cdcp.nodefx.nbi.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: Ronnie.Chen
 * Date: 2016/7/27
 * Time: 9:11
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class NbiMessageEncoder extends MessageToByteEncoder {
    private Logger logger = LoggerFactory.getLogger(NbiMessageEncoder.class);
    byte[] delimiter = {-1,-1,-1,-1};
    byte[] delimiterTail =  (new byte[]{(byte)10,(byte)10,(byte)13,(byte)13});
    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
        if (msg instanceof NbiMessage) {
            out.writeBytes(delimiter);
            byte[] data = ((NbiMessage) msg).toJsonBytes();
            logger.info("data="+new String(data,"utf-8"));
            out.writeInt(data.length+8);
            out.writeBytes(data);
            out.writeBytes(delimiterTail);
        }
    }
}
