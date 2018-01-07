package com.maowei.learning.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * <p>注释</p>
 *
 * @author alexsong
 * @version $Id: TimeClientHandler.java, v 0.1 2018年01月07日 下午3:53:53 alexsong Exp $
 */
public class TimeClientHandler extends ChannelHandlerAdapter {

    private final ByteBuf firstMessage;

    public TimeClientHandler(){
        byte[] req = "QUERY TIME ORDER".getBytes();
        firstMessage = Unpooled.buffer(req.length);
        firstMessage.writeBytes(req);
    }

    public void channelActive(ChannelHandlerContext ctx){
        ctx.writeAndFlush(firstMessage);
    }
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception{
        ByteBuf buf = (ByteBuf)msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);

        String body = new String(req, "UTF-8");

        System.out.println("Now is : " + body);
    }

    public void exceptionCaught(ChannelHandlerContext ctx) throws Exception{
        ctx.close();
    }
}
