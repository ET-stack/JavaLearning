package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.SysAuth;
import com.example.entity.SysRole;
import com.example.entity.SysUser;

import java.util.List;

/**
 * 系统用户Service
 *
 * @author CL
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 根据用户名称查询用户信息
     *
     * @param username 用户名称
     * @return
     */
    SysUser findUserByUserName(String username);

    /**
     * 根据用户ID查询角色
     *
     * @param userId 用户ID
     * @return
     */
    List<SysRole> findRoleByUserId(Long userId);

    /**
     * 根据用户ID查询权限
     *
     * @param userId 用户ID
     * @return
     */
    List<SysAuth> findAuthByUserId(Long userId);

}
