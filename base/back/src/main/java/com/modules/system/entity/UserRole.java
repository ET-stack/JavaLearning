package com.modules.system.entity;

import com.baomidou.mybatisplus.annotation.*;
import java.io.Serializable;

import com.modules.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>  系统管理 - 用户角色关联表  </p>
 */
@Data
@ApiModel(description = "系统管理 - 用户角色关联表 ")
@TableName("t_sys_user_role")
public class UserRole extends BaseEntity<UserRole> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@ApiModelProperty(value = "主键")
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 用户ID
     */
	@ApiModelProperty(value = "用户ID")
	@TableField("user_id")
	private Integer userId;
    /**
     * 角色ID
     */
	@ApiModelProperty(value = "角色ID")
	@TableField("role_id")
	private Integer roleId;

	@Override
	public Serializable pkVal() {
		return this.id;
	}

}
