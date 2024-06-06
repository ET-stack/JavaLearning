package com.xiao.mybatis.controller;/**
 * Created by 小飞 on 2019/8/4.
 */

import com.xiao.mybatis.service.UserService;
import com.xiao.pojo.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: 小飞
 * @Date: 2019/8/4 20:49
 * @Description:
 */

@RestController
@RequestMapping("/user")
public class UserControllerMybatis {
    @Autowired
    private UserService service;

    @RequestMapping("query")
    public UserBean queryByName() {
        return service.selectUserByName("xiaofei");

    }

    @RequestMapping("queryAll")
    public List<UserBean> queryByAll() {
        return service.selectAllUser();
    }

    @RequestMapping("insert")
    public void testInsert() {
        service.InsertUser();
    }

    @RequestMapping("changemoney")
    public void changemoney() {
        service.changemoney();
    }

    @RequestMapping("delete")
    public String testDelete() {
        service.deleteUser(5);
        return "delete OK";
    }


}
