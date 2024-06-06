//package com.yi.Server;/**
// * Created by 小飞 on 2019/8/18.
// */
//
//import org.springframework.amqp.core.AmqpTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
///**
// * @Auther: 小飞
// * @Date: 2019/8/18 20:01
// * @Description:
// */
//@Component
//public class Sender {
//    @Autowired
//    private AmqpTemplate amqpTemplate;
//    public void send(){
//        String context = "hello"+new Date();
//        System.out.println("Sender:"+context);
//        this.amqpTemplate.convertAndSend("hello",context);
//    }
//}
