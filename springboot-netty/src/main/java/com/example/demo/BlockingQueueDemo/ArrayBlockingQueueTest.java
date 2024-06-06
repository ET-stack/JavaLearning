package com.example.demo.BlockingQueueDemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @className: ArrayBlockingQueueTest
 * @description: TODO 类描述
 * @author: {yitao@flyread.com.cn}
 * @date: 2022/8/25
 **/
public class ArrayBlockingQueueTest {
    private ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue(3);
    public void put(final String put) throws InterruptedException {
        System.out.println("设置开始");
        TimeUnit.SECONDS.sleep(1);
        arrayBlockingQueue.put(put);
        System.out.println("设置完成: " + put);
    }

    public void take() throws InterruptedException {
        System.out.println("获取开始");
        String take = arrayBlockingQueue.take();
        System.out.println("获取成功: " + take);
    }

    public static void main(String[] args) {
        final ArrayBlockingQueueTest queueTest = new ArrayBlockingQueueTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i = 0; i < 3; i++) {
                        queueTest.put(i+"T");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // 读取线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        queueTest.take();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
