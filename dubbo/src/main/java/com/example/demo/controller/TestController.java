package com.example.demo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.demo.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Yi
 * @date 2020/6/24 12:28
 */
@Controller
public class TestController {
    @Reference
    private TestService testService;

    @RequestMapping()
    public String hello() {
        return testService.test();
    }
}
