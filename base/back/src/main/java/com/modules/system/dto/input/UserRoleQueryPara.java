package com.modules.system.dto.input;

import com.modules.common.dto.input.BasePageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 系统管理 - 用户角色关联表 查询参数
 */
@Data
@ApiModel(description = "系统管理 - 用户角色关联表 查询参数")
public class UserRoleQueryPara extends BasePageQuery{
    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "角色ID")
    private Integer roleId;
    @ApiModelProperty(value = "用户ids")
    private String userIds;
}
