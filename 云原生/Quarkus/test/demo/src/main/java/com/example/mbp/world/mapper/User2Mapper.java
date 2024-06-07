package com.example.mbp.world.mapper;

import com.example.mbp.user.entity.User;
import io.quarkiverse.mybatis.runtime.meta.MapperDataSource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @className: UserMapper
 * @description: TODO 类描述
 * @author: {yitao@flyread.com.cn}
 * @date: 2022/9/8
 **/
@Mapper
public interface User2Mapper {

    @Select("SELECT * FROM user")
    List<User> list();
}
