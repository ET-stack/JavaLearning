package com.xiao.Service;/**
 * Created by 小飞 on 2019/8/2.
 */

/**
 * @Auther: 小飞
 * @Date: 2019/8/2 22:54
 * @Description:
 */

public interface UserService {

    /**
     * 新增一个用户
     *
     * @param name
     * @param age
     */
    void create(String name, Integer age);

    /**
     * 根据name删除一个用户高
     *
     * @param name
     */
    void deleteByName(String name);

    /**
     * 获取用户总量
     */
    Integer getAllUsers();

    /**
     * 删除所有用户
     */
    void deleteAllUsers();

}
