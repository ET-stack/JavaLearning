package com.xiao.mybatis.service;/**
 * Created by 小飞 on 2019/8/4.
 */

import com.xiao.mybatis.mapper.UserMapper;
import com.xiao.pojo.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: 小飞
 * @Date: 2019/8/4 20:10
 * @Description:
 */

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 根据名字查用户
     */
    public UserBean selectUserByName(String name) {
        return userMapper.findUserByName(name);
    }

    /**
     * 查找所有用户
     */
    public List<UserBean> selectAllUser() {
        return userMapper.findAllUser();
    }

    /**
     * 插入一条用户信息
     */
    public void InsertUser() {
        userMapper.insertUser("xiaofei", 22, 3000.0);
        userMapper.insertUser("xiaotian", 18, 1000.0);
    }

    /**
     * 根据id删除一条信息
     *
     * @param id
     */

    public void deleteUser(int id) {
        userMapper.deleteUser(id);
    }

    public void changemoney() {
        userMapper.updateUser("xiaofei", 22, 2000.0, 5);
        int temp = 1 / 0;
        userMapper.updateUser("xiaotian", 18, 4000.0, 6);
    }
}
