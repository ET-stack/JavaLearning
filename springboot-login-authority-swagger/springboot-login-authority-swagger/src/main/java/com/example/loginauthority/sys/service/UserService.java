package com.example.loginauthority.sys.service;

import com.example.loginauthority.sys.model.User;

import java.util.Map;

/**
 * @className: User
 * @description: TODO 类描述
 * @author: T
 * @date: 2022/11/18
 **/
public interface UserService {

    /**
     * 新增
     */
    public Object insert(User user);

    /**
     * 删除
     */
    public Object delete(int id);

    /**
     * 更新
     */
    public Object update(User user);

    /**
     * 根据主键 id 查询
     */
    public User load(int id);

    /**
     * 分页查询
     */
    public Map<String,Object> pageList(int offset, int pagesize);
}
