package com.example.controller;

import com.example.entity.SysAuth;
import com.example.entity.SysRole;
import com.example.entity.SysUser;
import com.example.service.SysUserService;
import com.example.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 管理员Contrller
 *
 * @author CL
 */
@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private SysUserService sysUserSerivce;

    /**
     * 查询用户信息
     *
     * @return
     */
    @PreAuthorize(value = "hasRole('ADMIN')")
    @RequestMapping(value = "/list")
    public ResponseUtils list() {
        List<SysUser> userList = sysUserSerivce.list();
        return ResponseUtils.success(userList);
    }

    /**
     * 查询用户角色
     *
     * @return
     */
    @PreAuthorize(value = "hasRole('ADMIN') or hasPermission('/user/role', 'sys:role:info')")
    @RequestMapping(value = "/role")
    public ResponseUtils role(Long id) {
        List<SysRole> roleList = sysUserSerivce.findRoleByUserId(id);
        return ResponseUtils.success(roleList);
    }

    /**
     * 查询用户权限
     *
     * @return
     */
    @PreAuthorize(value = "hasAnyRole('ADMIN', 'USER') and hasPermission('/user/auth', 'sys:auth:info')")
    @RequestMapping(value = "/auth")
    public ResponseUtils auth(Long id) {
        List<SysAuth> authList = sysUserSerivce.findAuthByUserId(id);
        return ResponseUtils.success(authList);
    }

}
