package com.xiao.Service;/**
 * Created by 小飞 on 2019/8/2.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @Auther: 小飞
 * @Date: 2019/8/2 22:55
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(String name, Integer age) {
        jdbcTemplate.update("INSERT INTO user(name,age) values(?,?)", name, age);


    }

    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("DELETE FROM user WHERE name = ?", name);
    }

    @Override
    public Integer getAllUsers() {
        return jdbcTemplate.queryForObject("select count(1) from user", Integer.class);
    }

    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("DELETE from user");
    }
}
