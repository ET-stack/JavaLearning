package com.example.demo.bufferDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Yi
 * @date 2020/7/30 10:06
 */
public class BufferFileDemo {
    public static void main(String[] args) throws IOException {
        //使用文件I/O处理
        FileInputStream fin = new FileInputStream("1.txt");
        //创建文件的操作管道
        FileChannel fc = fin.getChannel();
        //分配一个10个大小的缓冲区 其实就是分配一个10个大小的Byte数组
        ByteBuffer buffer = ByteBuffer.allocate(10);
        output("初始化", buffer);
        //读入数据
        fc.read(buffer);
        output("调用read()", buffer);
        //准备操作之前，先锁定操作范围
        buffer.flip();
        output("调用flip()", buffer);
        //判断有没有可读数据
        while (buffer.remaining() > 0) {
            byte b = buffer.get();
            System.out.println(b);
        }
        output("调用get()", buffer);
        //解锁清除
        buffer.clear();
        output("调用clear()", buffer);
        //关闭管道
        fin.close();
    }

    //把缓存区的实时状态打印出来
    public static void output(String step, Buffer buffer) {
        System.out.println(step + ":");
        //容量 数组大小
        System.out.println("capacity :" + buffer.capacity());
        //当前操作数据的位置，也可以叫做游标
        System.out.println("position" + buffer.position());
        //锁定值 flip 数据操作范围索引只能在position- limit之间
        System.out.println("limit:" + buffer.limit());
        System.out.println();
    }
}
