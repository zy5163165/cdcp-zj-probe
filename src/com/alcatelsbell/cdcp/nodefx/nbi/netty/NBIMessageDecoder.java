package com.alcatelsbell.cdcp.nodefx.nbi.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

/**
 * Author: Ronnie.Chen
 * Date: 2016/7/27
 * Time: 12:16
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class NBIMessageDecoder extends ByteToMessageDecoder {
    private Logger logger = LoggerFactory.getLogger(NBIMessageDecoder.class);

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (byteBuf.readableBytes() > 0) {
            int length = byteBuf.readableBytes();
            System.out.println("i = " + length);


            length = byteBuf.readInt();
            System.out.println("length = " + length);
//
            byte[] bs = new byte[length];
            byteBuf.readBytes(bs);

            try {
                NbiMessage message = NbiMessage.parse(bs);
                list.add(message);
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}
