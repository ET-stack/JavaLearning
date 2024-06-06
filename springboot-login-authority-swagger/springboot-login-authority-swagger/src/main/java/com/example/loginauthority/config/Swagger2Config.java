package com.example.loginauthority.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @className: Swagger2Config
 * @description: TODO 类描述
 * @author:
 * @date: 2022/11/18
 **/
@Configuration
@EnableSwagger2 // 开启Swagger2自动配置
public class Swagger2Config {

    @Bean
    public Docket UserApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("BusinessApi") // 分组
                .apiInfo(BusinessApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.ken.login.controller"))
                .paths(PathSelectors.ant("/business/**"))
                .build();
    }

    @Bean
    public Docket SystemApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("SystemApi") // 分组
                .apiInfo(SystemApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.loginauthority.sys.controller"))
                .paths(PathSelectors.ant("/system/**"))
                .build();
    }

    // 配置业务模块文档信息
    private ApiInfo BusinessApiInfo(){
        return new ApiInfoBuilder()
                .title("我的API文档") // 标题
                .description("本文档描述了业务相关的接口定义") // 描述
                .version("1.0") // 版本
                .contact(new Contact("联系人名字", "联系人访问链接", "联系人邮箱")) // 联系人信息
                .build();
    }

    // 配置系统文档信息
    private ApiInfo SystemApiInfo(){
        return new ApiInfoBuilder()
                .title("我的API文档") // 标题
                .description("本文档描述了系统相关的接口定义") // 描述
                .version("1.0") // 版本
                .contact(new Contact("联系人名字", "联系人访问链接", "联系人邮箱")) // 联系人信息
                .build();
    }

}

