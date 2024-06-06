package com.example.demo.bufferDemo;

import java.nio.ByteBuffer;

/**
 * @author Yi
 * @date 2020/7/30 10:26
 */
public class BufferSliceDemo {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);

        //缓存区的数据 0~-9
        for (int i = 0; i < byteBuffer.capacity(); i++) {
            byteBuffer.put((byte) i);
        }
        //创建子缓冲区
        byteBuffer.position(3);
        byteBuffer.limit(7);
        ByteBuffer slice = byteBuffer.slice();
        //改变子缓冲区的内容
        for (int i = 0; i < slice.capacity(); i++) {
            byte b = slice.get(i);
            b *= 10;
            slice.put(i, b);
        }
        byteBuffer.position(0);
        byteBuffer.limit(byteBuffer.capacity());
        while (byteBuffer.remaining() > 0) {
            System.out.println(byteBuffer.get());
        }
    }
}
