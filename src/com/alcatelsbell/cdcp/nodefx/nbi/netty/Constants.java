package com.alcatelsbell.cdcp.nodefx.nbi.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: Ronnie.Chen
 * Date: 2016/7/27
 * Time: 11:46
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class Constants {

    public final static ByteBuf delimiter = Unpooled.copiedBuffer(new byte[]{(byte)255,(byte)255,(byte)255,(byte)255});
}
