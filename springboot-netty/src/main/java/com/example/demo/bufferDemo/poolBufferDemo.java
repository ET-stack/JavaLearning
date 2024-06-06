package com.example.demo.bufferDemo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;

import java.nio.ByteBuffer;

/**
 * @author Yi
 * @date 2020/7/30 14:32
 * 采用内存池分配器创建直接缓冲区
 */
public class poolBufferDemo {
    public static void main(String[] args) {
        final byte[] CONTENT = new byte[1024];
        int loop = 18000000;
        long startTime = System.currentTimeMillis();
        ByteBuf poolBuffer = null;
        for (int i = 0; i < loop; i++) {
            poolBuffer = PooledByteBufAllocator.DEFAULT.directBuffer(1024);
            poolBuffer.writeBytes(CONTENT);
            poolBuffer.release();

        }
        long endTime = System.currentTimeMillis();
        System.out.println("内存池分配缓冲区耗时" + (endTime - startTime) + "ms");
    }
}
