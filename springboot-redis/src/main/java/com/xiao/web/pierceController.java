package com.xiao.web;

import com.xiao.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class pierceController {
    @Autowired
    RedisUtils redisUtils;

    @GetMapping("/redisList")
    public void RedisList() {
        redisUtils.set("test", "test");
    }
}
