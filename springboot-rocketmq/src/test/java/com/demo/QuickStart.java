package com.demo;

import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.producer.DefaultMQProducer;

public class QuickStart {
    public static void main(String[] args) {
        DefaultMQPullConsumer consumer = new DefaultMQPullConsumer("group_name_4");
        consumer.setNamesrvAddr("127.0.0.1:9876");

    }
}
