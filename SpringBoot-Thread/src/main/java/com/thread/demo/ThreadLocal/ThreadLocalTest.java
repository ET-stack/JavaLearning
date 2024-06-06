package com.thread.demo.ThreadLocal;

/**
 * ThreadLocal，每个线程都有自己的本地变量
 * 实现原理set get 第一次调用就创建当前线程的对应的ThreadLocalMap
 */
public class ThreadLocalTest {
   //print函数
    static void print(String str){
        System.out.println(str+":"+localVariable.get());
    }
    static ThreadLocal<String> localVariable = new ThreadLocal<>();

    public static void main(String[] args) {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
            localVariable.set("本地变量1的值");
            print("threadOne");
            System.out.println("打印"+":"+localVariable.get());
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                localVariable.set("本地变量2的值");
                print("threadTwo");
                System.out.println("打印"+":"+localVariable.get());
            }
        });
        threadOne.start();
        threadTwo.start();
    }
}
