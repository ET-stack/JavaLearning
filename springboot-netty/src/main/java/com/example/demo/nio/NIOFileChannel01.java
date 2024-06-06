package com.example.demo.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Yi
 * @date 2020/7/18 16:38
 */
public class NIOFileChannel01 {

    private static ByteBuffer byteBuffer;

    public static void main(String[] args) throws IOException {
        String str = "hello Netty";
        //创建输入流 ->Channel
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\NIOfile.txt");

        // 通过FileOutputStream 获得对应的FileChannel
        //这个FileChannel 真实类型是FileChannelImpl
        FileChannel channel = fileOutputStream.getChannel();

        //创建一个缓冲区 ByteBuffer

        byteBuffer = ByteBuffer.allocate(1024);

        //将str放入byteBuffer
        byteBuffer.put(str.getBytes());

        //对buffer进行flip
        byteBuffer.flip();

        //将buffer 数据写入到filechannel
        channel.write(byteBuffer);

        //关闭最底层的文件流
        fileOutputStream.close();


    }
}
