package com.example.demo.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * @author Yi
 * @date 2020/7/18 23:47
 */
public class NIOFileChannel04 {
    public static void main(String[] args) throws IOException {

        //创建相关流
        FileInputStream fileInputStream = new FileInputStream("home.png");

        FileOutputStream fileOutputStream = new FileOutputStream("homeCopy.jpg");

        //获取输入输出流的Channel
        FileChannel sourceCh = fileInputStream.getChannel();

        FileChannel destch = fileOutputStream.getChannel();

        destch.transferFrom(sourceCh, 0, sourceCh.size());
        sourceCh.close();
        destch.close();
        fileInputStream.close();
        fileOutputStream.close();


    }

}
