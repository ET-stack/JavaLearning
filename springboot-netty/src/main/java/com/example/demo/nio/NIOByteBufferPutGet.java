package com.example.demo.nio;

import java.nio.ByteBuffer;

/**
 * @author Yi
 * @date 2020/7/19 13:22
 */
public class NIOByteBufferPutGet {
    public static void main(String[] args) {

        //创建一个buffer
        ByteBuffer allocate = ByteBuffer.allocate(64);

        //类型化方式放入数据
        allocate.putInt(100);
        allocate.putLong(9);
        allocate.putChar('商');
        allocate.putShort((short) 2);

        //取出
        allocate.flip();
        System.out.println(allocate.getLong());
        System.out.println(allocate.getLong());
        System.out.println(allocate.getLong());
        System.out.println(allocate.getLong());

    }
}
