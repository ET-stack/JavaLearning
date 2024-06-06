package com.demo.send;

import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class CustomMessageService {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    public void sendMessage() throws Exception {
        sendAsyncMessage();
    }

    private void sendAsyncMessage() throws Exception{
        rocketMQTemplate.asyncSend("topic-a", "测试同步消息", new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("发送同步消息成功--"+sendResult.toString()+"\n");
            }

            @Override
            public void onException(Throwable throwable) {
                System.out.println("发送同步消息失败");
                System.out.println(throwable.getMessage());
            }
        });
    }
}
