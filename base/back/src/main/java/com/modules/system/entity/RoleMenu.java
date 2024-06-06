package com.modules.system.entity;

import com.baomidou.mybatisplus.annotation.*;
import java.io.Serializable;

import com.modules.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>  系统管理 - 角色-菜单关联表  </p>
 */
@Data
@ApiModel(description = "系统管理 - 角色-菜单关联表 ")
@TableName("t_sys_role_menu")
public class RoleMenu extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@ApiModelProperty(value = "主键")
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 角色ID
     */
	@ApiModelProperty(value = "角色ID")
	@TableField("role_id")
	private Integer roleId;
    /**
     * 菜单ID
     */
	@ApiModelProperty(value = "菜单ID")
	@TableField("menu_id")
	private Integer menuId;

	@Override
	public Serializable pkVal() {
		return this.id;
	}

}
