package com.xiao.controller;/**
 * Created by 小飞 on 2019/9/2.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: 小飞
 * @Date: 2019/9/2 10:13
 * @Description:
 */
@RestController
public class Hello {

    @RequestMapping("hello")
    public String hello() {
        return "hello";
    }
}
