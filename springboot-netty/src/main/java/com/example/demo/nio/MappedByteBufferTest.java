package com.example.demo.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Yi
 * @date 2020/7/19 14:24
 * 说明 MappedByteBuffer  可让文件直接在内存(堆外内存)修改，操作系统不需要拷贝一次
 * <p>
 * 修改后不要在idea打开，应该在idea外面打开
 */
public class MappedByteBufferTest {

    public static void main(String[] args) throws IOException {

        RandomAccessFile rw = new RandomAccessFile("1.txt", "rw");

        //获取对应的文件通道
        FileChannel channel = rw.getChannel();
        MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
        mappedByteBuffer.put(0, (byte) 'H');
        mappedByteBuffer.put(3, (byte) '9');

        rw.close();

    }
}
