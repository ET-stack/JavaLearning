package com.example.demo.NIOServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Yi
 * @date 2020/7/25 17:18
 */
public class NIOServer {
    public static void main(String[] args) throws IOException {

        //创建ServerSocketChannel ->ServerSocket
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        //得到一个Selecor 对象
        Selector selector = Selector.open();

        //绑定端口6666
        serverSocketChannel.socket().bind(new InetSocketAddress(6666));

        //设置为非阻塞
        serverSocketChannel.configureBlocking(false);

        //把serverSocketChannel 注册到 selector 关心事件为OP_ACCEPT
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        //循环等待客户端连接
        while (true) {
            if (selector.select(100) == 0) {
                // 判断为true 则为无事件
                System.out.println("服务器等待了1秒，无连接");
                continue;
            }
            //如果返回的 > 0 就获得相关的selectionKey集合
            //1.如果返回的 > 0  表示已经获得到关注的事件
            //2. selector.selectedKeys()返回关注事件的集合
            //通过selectionKey反向获取通道
            Set<SelectionKey> selectionKeySet = selector.selectedKeys();

            //使用迭代器遍历selectionKeySet
            Iterator<SelectionKey> keyIterable = selectionKeySet.iterator();

            while (keyIterable.hasNext()) {
                SelectionKey key = keyIterable.next();
                //根据Key 对应的通道发生的事件做相应的处理
                if (key.isAcceptable()) {
                    //如果有 客户端连接 就给该客户端生成一个新的socketChannel
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    //将socketChannel    注册到selector 关注事件为Read 同时给socketChannel
                    //关联一个Buffer
                    System.out.println("客户端连接成功 生成了一个socketChannel" + socketChannel.hashCode());

                    //没new 一个socketChannel 需要制定为非阻塞
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));

                }
                if (key.isReadable()) {
                    //发生 OP_Read  通道Key 反向获取到对应的Channel
                    SocketChannel channel = (SocketChannel) key.channel();
                    //获得该channel 关联的buffer
                    ByteBuffer byteBuffer = (ByteBuffer) key.attachment();
                    channel.read(byteBuffer);
                    System.out.println("from 客户端" + new String(byteBuffer.array()));
                }
                //手动从集合中移出当前的selectionKey ，防止重复操作
                keyIterable.remove();
            }
        }


    }
}
