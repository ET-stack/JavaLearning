//package com.yi.Test;/**
// * Created by 小飞 on 2019/8/18.
// */
//
//import com.rabbitmq.client.AMQP;
//import com.rabbitmq.client.Consumer;
//import com.rabbitmq.client.DefaultConsumer;
//import com.rabbitmq.client.Envelope;
//import org.springframework.amqp.rabbit.connection.Connection;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//
//import java.io.IOException;
//import java.util.concurrent.TimeoutException;
//
///**
// * @Auther: 小飞
// * @Date: 2019/8/18 21:23
// * @Description:
// */
//
//public class consumer {
//    private final static String QUEUE_NAME = "hello";
//    public static void main(String[] args) throws Exception {
//        ConnectionFactory factory = new ConnectionFactory();
//        factory.setHost("localhost");
//        Connection connection = null;
//        try {
//            connection = factory.newConnection();
//        } catch (TimeoutException e) {
//            e.printStackTrace();
//        }
//        Channel channel = connection.createChannel();
//        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
//        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
//        Consumer consumer = new DefaultConsumer(channel) {
//            @Override
//            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
//                    throws IOException {
//                String message = new String(body, "UTF-8");
//                System.out.println(" [x] Received '" + message + "'");
//            }
//        };
//        channel.basicConsume(QUEUE_NAME, true, consumer);
//    }
//}
