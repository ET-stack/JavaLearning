package com.example.demo.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Yi
 * @date 2020/7/18 17:00
 */
public class NIOFileChannel02 {

    public static void main(String[] args) throws IOException {

        File file = new File("D:\\NIOfile.txt");

        FileInputStream fileInputStream = new FileInputStream(file);

        //创建通道
        FileChannel fileChannel = fileInputStream.getChannel();

        //创建缓存区
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());

        //将通道的数据读入到buffer中

        fileChannel.read(byteBuffer);

        System.out.println(new String(byteBuffer.array()));

        fileInputStream.close();


    }
}
