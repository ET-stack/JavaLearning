package com.example.demo.groupchat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * @author Yi
 * @date 2020/7/27 21:01
 */
public class GroupChatServer {
    //定义属性
    private Selector selector;
    private ServerSocketChannel listenChannel;
    private static final int PORT = 6667;
    //构造器
    //初始化工作

    public GroupChatServer(Selector selector, ServerSocketChannel listenChannel) {


        try {
            //得到选择器
            selector = Selector.open();
            //ServerSocketChannel
            listenChannel = ServerSocketChannel.open();
            //绑定端口
            listenChannel.socket().bind(new InetSocketAddress(PORT));
            //设置非阻塞模式
            listenChannel.configureBlocking(false);
            //将该listenChannel 注册到Selector
            listenChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void listen() {
        try {
            while (true) {
                int count = selector.select(2000);
                if (count > 0) {
                    //有事件处理
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        //监听是否有接入事件
                        if (key.isAcceptable()) {
                            SocketChannel socketChannel = listenChannel.accept();
                            //将sc 注册到select
                            socketChannel.register(selector, SelectionKey.OP_READ);
                            socketChannel.configureBlocking(false);
                            //提示
                            System.out.println(socketChannel.getRemoteAddress() + "上线了");
                        }
                        if (key.isReadable()) {
                            //如果有写入的事件发生
                            //通过key反向获取对应的Channel
                            SocketChannel channel = (SocketChannel) key.channel();
                            //获得到该Channel关联的buffer
                            ByteBuffer byteBuffer = (ByteBuffer) key.attachment();
                            channel.read(byteBuffer);
                            System.out.println("from 客户端" + new String(byteBuffer.array()));
                        }
                        //手动移出当前selectorKey 防止重复操作
                        iterator.remove();
                    }
                } else {
                    System.out.println("等待....");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendInfoToOtherClients(String msg, SocketChannel self) throws IOException {
        System.out.println("服务器转发消息中.....");
        //遍历所有注册到Selector SocketChannel 并排除自己
        for (SelectionKey key : selector.selectedKeys()) {
            Channel targetChannel = key.channel();
            //排除自己
            if (targetChannel instanceof SocketChannel && targetChannel != self) {

                // 转型
                SocketChannel dest = (SocketChannel) targetChannel;
                //将msg存储到buffer
                ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
                //将buffer数据写入通道
                dest.write(buffer);
            }
        }


    }

    public static void main(String[] args) {


    }
}
