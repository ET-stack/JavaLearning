package com.xiao.mybatis.mapper;

import com.xiao.pojo.UserBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by 小飞 on 2019/8/4.
 */
@Mapper
public interface UserMapper {
    /**
     * 根据名字查找用户
     *
     * @param name
     * @return
     */
    @Select("select * from user where name = #{name}")
    UserBean findUserByName(@Param("name") String name);

    /**
     * 查找所有用户
     *
     * @return
     */
    @Select("select * from user")
    List<UserBean> findAllUser();

    /**
     * 插入用户信息
     *
     * @param name
     * @param age
     * @param money
     */
    @Insert("insert into user(name,age,money) values (#{name},#{age},#{money})")
    void insertUser(@Param("name") String name, @Param("age") Integer age, @Param("money") Double money);

    /**
     * 根据id更新用户信息
     *
     * @param name
     * @param age
     * @param money
     * @param id
     */
    @Update("update user set name = #{name},age = #{age},money = #{money} where id = #{id}")
    void updateUser(@Param("name") String name, @Param("age") Integer age, @Param("money") Double money, @Param("id")
            int id);

    /**
     * 根据id删除用户信息
     *
     * @param id
     */
    @Delete("delete from user where id = #{id}")
    void deleteUser(@Param("id") int id);
}
