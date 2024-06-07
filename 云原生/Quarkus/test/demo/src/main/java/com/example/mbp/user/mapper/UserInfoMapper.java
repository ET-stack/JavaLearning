package com.example.mbp.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mbp.user.entity.UserInfoEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户信息 Mapper
 *
 * @author abing
 * @date 2022/5/20
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfoEntity> {
}
