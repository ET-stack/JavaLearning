package com.xiao;

import com.xiao.Service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMysqlApplicationTests {
    @Autowired
    private UserService userService;


    @Test
    public void contextLoads() {
        //清空所有表
        userService.deleteAllUsers();
        Assert.assertEquals(0, userService.getAllUsers().intValue());
    }

    @Test
    public void test() {
        for (int i = 0; i < 10; i++) {
            userService.create("a" + i, i);
        }
        Assert.assertEquals(10, userService.getAllUsers().intValue());
    }

    //测试UserController RESTful方法


}
