package com.example.demo.httpDemo;

import ch.qos.logback.core.rolling.helper.Compressor;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.sctp.nio.NioSctpServerChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpContentCompressor;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

import java.net.InetSocketAddress;

/**
 * @className: httpServer
 * @description: TODO 类描述
 * @date: 2023/1/10
 **/
public class HttpServer {
    public void start(int port)  {
        EventLoopGroup boosGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        ServerBootstrap b = new ServerBootstrap();
        b.group(boosGroup,workGroup).channel(NioServerSocketChannel.class).localAddress(new InetSocketAddress(port)).childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast("codec", new HttpServerCodec());
                    ch.pipeline().addLast("compressor",new HttpContentCompressor());
                    ch.pipeline().addLast("aggregator",new HttpObjectAggregator(65536));
                    ch.pipeline().addLast("handler",new HttpServerHander());

            }
        }).childOption(ChannelOption.SO_KEEPALIVE, true);

        ChannelFuture f = null;
        try {
            f = b.bind().sync();
            System.out.println("http 启动端口"+port);
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            workGroup.shutdownGracefully();

            boosGroup.shutdownGracefully();
        }

    }
    public static void main(String[] args) throws Exception {

        new HttpServer().start(8088);

    }
}
