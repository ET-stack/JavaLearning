package com.example.loginauthority;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.loginauthority.sys.mapper")
public class LoginAuthoritySwaggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginAuthoritySwaggerApplication.class, args);
    }

}
