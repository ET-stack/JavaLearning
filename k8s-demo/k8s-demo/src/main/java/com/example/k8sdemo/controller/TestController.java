package com.example.k8sdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: TestController
 * @description: TODO 类描述
 * @date: 2024/4/23
 **/
@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "test1";
    }
}
