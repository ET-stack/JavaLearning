package com.example.demo.service;


import com.alibaba.dubbo.config.annotation.Service;

/**
 * @author Yi
 * @date 2020/6/24 9:20
 */
@Service
public class TestServiceImpl implements TestService {

    @Override
    public String test() {
        return "Hello Wolrd";
    }
}