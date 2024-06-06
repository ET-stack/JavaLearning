//package com.yi.Test;/**
// * Created by 小飞 on 2019/8/18.
// */
//
//import com.rabbitmq.client.ConnectionFactory;
//import org.springframework.amqp.rabbit.connection.Connection;
//import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
//
///**
// * @Auther: 小飞
// * @Date: 2019/8/18 21:22
// * @Description:
// */
//
//public class producer {
//    private final static String QUEUE_NAME = "hello";
//    public static void main(String[] argv)
//            throws java.io.IOException {
//        ConnectionFactory factory = new ConnectionFactory();
//        factory.setHost("localhost");
//        Connection connection = null;
//        RabbitProperties.Cache.Channel channel = null;
//        try {
//            connection = factory.newConnection();
//            channel = connection.createChannel();
//            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
//            String message = "Hello Rabbit222!";
//            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
//            System.out.println(" [x] Sent '" + message + "'");
//        } catch (TimeoutException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                channel.close();
//            } catch (TimeoutException e) {
//                e.printStackTrace();
//            }
//            connection.close();
//        }
//    }
//}
