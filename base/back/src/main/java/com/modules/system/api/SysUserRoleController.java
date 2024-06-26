package com.modules.system.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.modules.system.dto.input.UserRoleQueryPara;
import com.modules.system.entity.UserRole;
import com.modules.system.service.IUserRoleService;
import com.modules.common.api.BaseController;
import com.modules.common.dto.output.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * <p> 系统管理 - 用户角色关联表  接口 </p>
 *
 */
@RestController
@RequestMapping("/api/system/userRole")
@Api(description = "系统管理 - 用户角色关联表 接口")
public class        SysUserRoleController extends BaseController {

    @Autowired
    IUserRoleService userRoleService;

    @PostMapping(value = "/listPage", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "获取系统管理 - 用户角色关联表 列表分页", httpMethod = "POST", response = ApiResult.class)
    public ApiResult listPage(@RequestBody UserRoleQueryPara filter) {
        Page<UserRole> page = new Page<>(filter.getPage(),filter.getLimit());
        userRoleService.listPage(page, filter);
        return ApiResult.ok("获取系统管理 - 用户角色关联表 列表分页成功", page);
    }

    @PostMapping(value = "/list", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "获取系统管理 - 用户角色关联表 列表", httpMethod = "POST", response = ApiResult.class)
    public ApiResult list(@RequestBody UserRoleQueryPara filter) {
        List<UserRole> result = userRoleService.list(filter);
        return ApiResult.ok("获取系统管理 - 用户角色关联表 列表成功",result);
    }

    @PostMapping(value = "/saveOrUpdate", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "保存或更新系统管理 - 用户角色关联表 ", httpMethod = "POST", response = ApiResult.class)
    public ApiResult saveOrUpdate(@RequestBody UserRole input) {
        boolean idFlag = userRoleService.save(input);
        return ApiResult.ok("保存系统管理 - 用户角色关联表 成功", idFlag);
    }

    @PostMapping(value = "/delete", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "删除系统管理 - 用户角色关联表 ", httpMethod = "POST", response = ApiResult.class)
    public ApiResult delete(@RequestBody UserRoleQueryPara input) {
        userRoleService.removeById(input.getId());
        return ApiResult.ok("删除系统管理 - 用户角色关联表 成功");
    }

    @PostMapping(value = "/detail", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "根据ID获取系统管理 - 用户角色关联表 信息", httpMethod = "POST", response = ApiResult.class)
    public ApiResult detail(@RequestBody UserRoleQueryPara input) {
        UserRole entity = userRoleService.getById(input.getId());
        return ApiResult.ok("获取用户角色关联信息成功", entity);
    }

    @PostMapping(value = "/saveUserRole", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "保存角色相关联用户", httpMethod = "POST", response = ApiResult.class)
    public ApiResult saveUserRole(@RequestBody UserRoleQueryPara input) {
        userRoleService.saveUserRole( input );
        return ApiResult.ok("保存角色相关联用户成功");
    }

}
