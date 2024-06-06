package com.demo;

import com.demo.send.CustomMessageService;
import com.demo.send.SyncMessageConsumer;
import com.sun.xml.internal.ws.api.message.Message;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    CustomMessageService customMessageService;
    @Autowired
    SyncMessageConsumer syncMessageConsumer;
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Test
    void contextLoads() throws Exception {
//        customMessageService.sendMessage();
//        syncMessageConsumer.onMessage("topic-a");

        SendResult result= rocketMQTemplate.syncSend("springboot-topic:tag","这是一条同步消息",10000);
        System.out.println(result);
    }

}
