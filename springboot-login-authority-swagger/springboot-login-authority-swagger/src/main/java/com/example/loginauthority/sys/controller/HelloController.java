package com.example.loginauthority.sys.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: HelloController
 * @description: TODO 类描述
 * @author:
 * @date: 2022/11/18
 **/
@RestController
public class HelloController {
    @GetMapping(value = "/user")
    public String getUser(){
        return "123456";
    }
    @ApiOperation("可以指定参数的API")
    @PostMapping("/param")
//    @PreAuthorize("hasAuthority('pms:product:create')")
    public String hello2(@ApiParam("用户名") String name){
        return "hello" + name;
    }
}