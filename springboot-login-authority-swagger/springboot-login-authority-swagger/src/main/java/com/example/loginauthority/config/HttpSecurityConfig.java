package com.example.loginauthority.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @className: SpringSecurityConfig
 * @description: TODO 类描述
 * @author:
 * @date: 2022/11/18
 *  /**
 *      * anyRequest          |   匹配所有请求路径
 *      * access              |   SpringEl表达式结果为true时可以访问
 *      * anonymous           |   匿名可以访问
 *      * denyAll             |   用户不能访问
 *      * fullyAuthenticated  |   用户完全认证可以访问（非remember-me下自动登录）
 *      * hasAnyAuthority     |   如果有参数，参数表示权限，则其中任何一个权限可以访问
 *      * hasAnyRole          |   如果有参数，参数表示角色，则其中任何一个角色可以访问
 *      * hasAuthority        |   如果有参数，参数表示权限，则其权限可以访问
 *      * hasIpAddress        |   如果有参数，参数表示IP地址，如果用户IP和参数匹配，则可以访问
 *      * hasRole             |   如果有参数，参数表示角色，则其角色可以访问
 *      * permitAll           |   用户可以任意访问
 *      * rememberMe          |   允许通过remember-me登录的用户访问
 *      * authenticated       |   用户登录后可访问
 *
 **/
@EnableWebSecurity
public class HttpSecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //按顺序过滤
        return http
                .authorizeRequests(authorize -> authorize
                        .antMatchers("/swagger-ui.html").permitAll()
                                .antMatchers("/webjars/**").permitAll()
                                .antMatchers("/swagger-resources/**").permitAll()
                                .antMatchers("/v2/*").permitAll()
                                .antMatchers("/csrf").permitAll()
                                .anyRequest().authenticated()
                )
                .build();
    }
}