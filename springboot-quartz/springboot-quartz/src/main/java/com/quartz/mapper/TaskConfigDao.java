package com.quartz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.quartz.model.TaskConfigEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @className: TaskConfigDao
 * @description: TODO 类描述
 * @date: 2023/4/19
 **/

@Mapper
public interface TaskConfigDao extends BaseMapper<TaskConfigEntity> {

}