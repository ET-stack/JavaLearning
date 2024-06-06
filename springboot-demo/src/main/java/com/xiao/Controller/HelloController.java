package com.xiao.controller;/**
 * Created by 小飞 on 2019/7/31.
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 小飞
 * @Auther: 小飞
 * @Date: 2019/7/31 22:17
 * @Description:
 */

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
