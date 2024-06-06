package com.yi.Server;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Yi
 * @date 2020/6/13 20:53
 */
public class Provider {
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
        //发布消息
        //参数1：交换机名称
        //参数2：队列名称
        //参数3：传递消息额外设置
        //参数4：消息的具体内容
        channel.basicPublish("", "hello", null, "hello rabbitmq".getBytes());
        //关闭通道
//        channel.close();
        //关闭连接
//        connection.close();
    }

}
