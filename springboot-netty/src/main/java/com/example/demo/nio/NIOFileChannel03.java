package com.example.demo.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Yi
 * @date 2020/7/18 17:29
 */
public class NIOFileChannel03 {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("1.txt");

        FileChannel fileInputStreamChannelRead = fileInputStream.getChannel();


        FileOutputStream fileOutputStream = new FileOutputStream("2.txt");

        FileChannel fileInputStreamChannelWrite = fileOutputStream.getChannel();

        ByteBuffer allocate = ByteBuffer.allocate(512);

        while (true) {
            //重置标志位
            allocate.clear();
            //清空buffer
            int read = fileInputStreamChannelRead.read(allocate);
            if (read == -1) {
                break;
            }
            allocate.flip();
            fileInputStreamChannelWrite.write(allocate);

        }
        fileInputStream.close();
        fileOutputStream.close();

    }
}
