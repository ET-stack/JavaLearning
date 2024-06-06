package com.example.kafka;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * @className: ApplicationTests
 * @description: TODO 类描述
 * @author: {yitao@flyread.com.cn}
 * @date: 2022/8/31
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationTests.class)
@EmbeddedKafka(count = 4,ports = {9092,9093,9094,9095})
public class ApplicationTests {
    @Test
    public void contextLoads()throws IOException {
        System.in.read();
    }
}