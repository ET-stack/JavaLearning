package com.reptile.webservice;

import javax.jws.WebService;

@WebService
public class HelloServiceImpl implements HelloServiceInterface {

    public String sayHello(People people) {
        System.out.print("hello:" + people.getName() + "年龄：" + people.getAge());
        return "200";
    }

}