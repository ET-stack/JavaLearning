package com.modules.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.modules.system.dto.input.UserRoleQueryPara;
import com.modules.system.entity.UserRole;

import java.util.List;

/**
 * <p>  系统管理 - 用户角色关联表  服务类 </p>
 *
 * @author:
 * @date: 2019-08-20
 */
public interface IUserRoleService extends IService<UserRole> {

    /**
     * 系统管理 - 用户角色关联表 列表分页
     *
     * @param page
     * @param filter
     * @return
     */
    void listPage(Page<UserRole> page, UserRoleQueryPara filter);

    /**
     * 保存系统管理 - 用户角色关联表
     *
     * @param input
     */
    boolean save(UserRole input);

    /**
     * 系统管理 - 用户角色关联表 列表
     *
     * @param filter
     * @return
     */
    List<UserRole> list(UserRoleQueryPara filter);

    /**
     * 保存角色相关联用户
     *
     * @param filter:
     * @return: void
     */
    void saveUserRole(UserRoleQueryPara filter);

}
