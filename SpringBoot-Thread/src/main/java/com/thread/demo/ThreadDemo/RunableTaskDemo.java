package com.thread.demo.ThreadDemo;

/**
 * @author Yi
 * @date 2020/7/30 16:33
 * 实现Runnable接口的run方法方式
 * 两个线程共用一个task代码逻辑，如果需要，可以给RunableTask添加参数进行任务区分。
 * 另外，RunableTask可以继承其他类。
 * 但是上面介绍的两种方式都有一个缺点，就是任务没有返回值
 */
public class RunableTaskDemo {
    public static class RunableTask implements Runnable {

        @Override
        public void run() {
            System.out.println("I am a child thread");
        }
    }

    public static void main(String[] args) {
        RunableTask runableTask = new RunableTask();
        new Thread(runableTask).start();
        new Thread(runableTask).start();
    }
}
