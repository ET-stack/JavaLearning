package com.thread.demo.ThreadDemo;

/**
 * @author Yi
 * @date 2020/7/30 16:23
 * 使用继承方式的好处是，在run（）方法内获取当前线程直接使用this就可以了，
 * 无须使用Thread.currentThread（）方法；
 * 不好的地方是Java不支持多继承，如果继承了Thread类，那么就不能再继承其他类
 */
public class ThreadDemo {
    //继承Thread类 并重写run方法
    public static class MyThread extends Thread {

        @Override
        public void run() {
            System.out.println("I am a child thread ");
        }
    }

    //需要注意的是，当创建完thread对象后该线程并没有被启动执行，直到调用了start方法后才真正启动了线程
    public static void main(String[] args) throws InterruptedException {
        //创建线程
        MyThread thread = new MyThread();
        //调用start方法后线程并没有马上执行而是处于就绪状态，这个就绪状态是指该线程已经获取了除CPU资源外的其他资源，等待获取CPU资源后才会真正处于运行状态。一旦run方法执行完毕，该线程就处于终止状态
        thread.start();
//       thread.run();
    }
}
