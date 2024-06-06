package com.example.demo.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * 这是一个初始化器 channel注册后 会执行里面的相应的初始化方法
 */
public class HelloServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        //通过SocketChannel 去获得对应的管道
        ChannelPipeline channelPipeline = socketChannel.pipeline();
        //通过管道 添加Handler
        //当请求到服务器 我们需要做编码 响应到客户端做编码
        channelPipeline.addLast("HttpServerCodec", new HttpServerCodec());
        //添加自定义的助手类 返回“hello netty”
        channelPipeline.addLast("customHandler", new CustomHandler());
    }
}
