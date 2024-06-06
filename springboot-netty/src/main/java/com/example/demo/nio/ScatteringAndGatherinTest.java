package com.example.demo.nio;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * @author Yi
 * @date 2020/7/21 21:59
 * Scattering将数据写入到buffer时可以采用buffer数组，依次写入 【分散】
 * Gathering 从buffer读取数据时可以采用buffer数组，依次读
 */
public class ScatteringAndGatherinTest {

    public static void main(String[] args) throws IOException {

        //使用 ServerSockerChannel 和socketChannel 网络
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(7000);

        //绑定端口到socket 并启动
        serverSocketChannel.bind(inetSocketAddress);

        //创建buffer数组
        ByteBuffer[] byteBuffer = new ByteBuffer[2];
        byteBuffer[0] = ByteBuffer.allocate(5);
        byteBuffer[1] = ByteBuffer.allocate(3);

        //等待客户端连接
        SocketChannel socketChannel = serverSocketChannel.accept();

        //假定从客户端接收8个字节
        int messageLength = 8;

        //循环的次数
        while (true) {
            int byteRead = 0;
            while (byteRead < messageLength) {
                long read = socketChannel.read(byteBuffer);
                byteRead += read;
                //累计读取的字节数
                System.out.println("byteRead=" + byteRead);
                //使用流打印
                Arrays.asList(byteBuffer).stream().map(buffer -> "position" + buffer.position() + ",limit = " + buffer.limit()).forEach(System.out::println);

                //将所有的buffer进行flip
                Arrays.asList(byteBuffer).forEach(byteBuffer1 -> byteBuffer1.flip());

                //将数据读出显示到客户端
                long byteWrite = 0;
                while (byteWrite < messageLength) {
                    long write = socketChannel.write(byteBuffer);
                    byteWrite += write;

                }
                //将所有的buffer进行clear
                Arrays.asList(byteBuffer).forEach(byteBuffer1 -> {
                    byteBuffer1.clear();
                });
                System.out.println("byteRead =" + byteRead + "byteWrite =" + byteWrite + "messageLength=" + messageLength);
            }
        }


    }

}
