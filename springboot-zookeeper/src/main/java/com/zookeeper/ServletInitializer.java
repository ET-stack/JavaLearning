package com.zookeeper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringbootZookeeperApplication.class);
    }

    class hello {
        @Value("${server.port}")
        private String serverPort;

        @RequestMapping(value = "/zk")
        public String paymentZk() {
            return "springcloud with zookeeper: " + serverPort + "\t" + UUID.randomUUID().toString();
        }
    }
}
