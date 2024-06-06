package com.xiao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xiao.mybaits.mapper")
public class SpringbootMysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMysqlApplication.class, args);
    }

}
