package com.yi.Server;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Yi
 * @date 2020/6/14 13:57
 */
public class Customer {
    public static void main(String[] args) throws IOException, TimeoutException {
        new Provider().testSendMessage();
    }

    public void testSendMessage() throws IOException, TimeoutException {
        //创建连接mq的链接工厂对象
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //设置连接RabbitMQ的主机
        connectionFactory.setHost("127.0.0.1");
        //设置端口号
        connectionFactory.setPort(5672);
        //设置连接虚拟主机 /为默认主机
        connectionFactory.setVirtualHost("/");
        //设置访问虚拟主机的用户名和密码
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");

        //获取连接对象
        Connection connection = connectionFactory.newConnection();
        //获取连接中的通道对象
        Channel channel = connection.createChannel();
        //通道绑定对应的消息队列
        //参数1：队列名称 如果队列不存在自动创建
        //参数2：定义队列特性是否要实例化true为实例化，false为不持久化
        //参数3:exclusive 是否独占队列，true独占队列，false，不独占队列
        //参数4:autoDelete:是否消费完自动删除队列，true自动删除  false不自动删除
        //参数5:额外附加参数
        channel.queueDeclare("hello", false, false, false, null);
        //消费消息
        //参数1：消费队列的名称
        //参数2：开始消费的确认机制
        //参数3：消费消息时的回调对象
        //参数4：消息的具体内容
        channel.basicConsume("hello", true, new DefaultConsumer(channel) {
            //最后一个参数:消息队列中取出的消息
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("new String(body)" + new String(body));
            }
        });
        //关闭通道
//        channel.close();
        //关闭连接
//        connection.close();
    }
}
