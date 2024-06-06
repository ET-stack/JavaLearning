package com.example.demo.httpDemo;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;

import java.nio.charset.StandardCharsets;

/**
 * @className: HttpServerHander
 * @description: TODO 类描述
 * @date: 2023/1/10
 **/
public class HttpServerHander extends SimpleChannelInboundHandler<FullHttpRequest> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, FullHttpRequest msg) throws Exception {
        String content = String.format("http 请求来源,url: %s, method: %S,content: %s",msg.uri(),msg.method(),msg.content().toString(StandardCharsets.UTF_8));
        FullHttpResponse response = new DefaultFullHttpResponse(
                HttpVersion.HTTP_1_1, HttpResponseStatus.OK, Unpooled.wrappedBuffer(content.getBytes())
        );
        channelHandlerContext.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);

    }
}
