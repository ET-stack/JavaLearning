//package com.yi.Server;/**
// * Created by 小飞 on 2019/8/18.
// */
//
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
///**
// * @Auther: 小飞
// * @Date: 2019/8/18 20:03
// * @Description:
// */
//@Component
//@RabbitListener(queues = "hello")
//public class Receiver {
//    @RabbitHandler
//    public void process(String hello){
//        System.out.println("Receiver"+hello);
//    }
//}
