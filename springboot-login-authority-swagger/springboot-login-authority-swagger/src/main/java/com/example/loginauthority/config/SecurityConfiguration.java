package com.example.loginauthority.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

/**
 * @className: SecurityConfiguration
 * @description: TODO 类描述
 * @author: 
 * @date: 2022/11/18
 **/
@Configuration
public class SecurityConfiguration {

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        // 仅仅作为演示
        return (web) -> web.ignoring().antMatchers("/ignore1", "/ignore2");
    }

}
