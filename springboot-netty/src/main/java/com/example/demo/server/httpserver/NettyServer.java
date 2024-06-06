package com.example.demo.server.httpserver;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author zzz
 */
public class NettyServer {
    public static void main(String[] args) throws InterruptedException {
        new NettyServer().bing(7777);
    }

    private void bing(int i) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup childGroup = new NioEventLoopGroup();
        ServerBootstrap s = new ServerBootstrap();
        s.group(bossGroup, childGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 128)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childHandler(new MyChannelInitializer());
        ChannelFuture f = s.bind(i).sync();
        f.channel().closeFuture().sync();
        childGroup.shutdownGracefully();
        bossGroup.shutdownGracefully();
    }
}
