package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.SysAuth;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统权限Dao
 *
 * @author CL
 */
@Mapper
public interface SysAuthDao extends BaseMapper<SysAuth> {

}
