package com.thread.demo.ThreadDemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Yi
 * @date 2020/7/30 16:35
 * 如下代码中的CallerTask类实现了Callable接口的call（）方法。
 * 在main函数内首先创建了一个FutrueTask对象（构造函数为CallerTask的实例）
 * ，然后使用创建的FutrueTask对象作为任务创建了一个线程并且启动它，最后通过futureTask.get（）等待任务执行完毕并返回结果。
 */
public class CallerTaskDemo {
    //创建任务类 类似于Runable
    public static class CallerTask implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "hello";
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //创建异步任务
        FutureTask futureTask = new FutureTask(new CallerTask());
        //启动线程
        new Thread(futureTask).start();
        try {
            ///等待任务执行完毕后，返回结果
            String result = (String) futureTask.get();
            System.out.println(result);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
/**
 * 总结
 * 使用继承方式的好处是方便传参，你可以在子类里面添加成员变量，通过set方法设置参数或者通过构造函数进行传递，而如果使用Runnable方式，则只能使用主线程里面被声明为final的变量。不好的地方是Java不支持多继承，如果继承了Thread类，那么子类不能再继承其他类，而Runable则没有这个限制。前两种方式都没办法拿到任务的返回结果，但是Futuretask方式可以
 */
