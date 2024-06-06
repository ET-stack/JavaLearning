package com.example.demo.bufferDemo;

import java.nio.IntBuffer;

/**
 * @author Yi
 * @date 2020/7/30 9:54
 */
public class IntBufferDemo {

    public static void main(String[] args) {
        //分配新的int缓冲区 参数为缓冲区容量
        //新缓冲区的当前位置将为0 其界限为容量，底层实现数组偏移量为0
        IntBuffer intBuffer = IntBuffer.allocate(8);
        for (int i = 0; i < intBuffer.capacity(); i++) {
            int j = 2 * (i + 1);
            //给定整数写入缓冲区 当前位置递增
            intBuffer.put(j);
        }
        //重设此缓冲区  将限制位置设为当前位置
        //然后将当前位置设置为0
        intBuffer.flip();
        while (intBuffer.hasRemaining()) {
            int j = intBuffer.get();
            System.out.println(j + "");
        }
    }
}
