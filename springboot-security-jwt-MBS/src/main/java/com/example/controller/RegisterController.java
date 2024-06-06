package com.example.controller;

import com.example.entity.SysUser;
import com.example.entity.SysUserRole;
import com.example.service.SysUserRoleService;
import com.example.service.SysUserService;
import com.example.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注册用户实例Contrller
 *
 * @author CL
 */
@RestController
@RequestMapping(value = "/register")
public class RegisterController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysUserRoleService sysUserRoleService;

    /**
     * 注册普通用户
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @RequestMapping(value = "/user")
    public ResponseUtils user(String username, String password) {
        SysUser sysUser = new SysUser();
        sysUser.setUsername(username);
        sysUser.setPassword(bCryptPasswordEncoder.encode(password));
        sysUser.setStatus("0");
        sysUserService.save(sysUser);

        // 注册普通用户
        SysUserRole sysUserRole = new SysUserRole();
        sysUserRole.setUserId(sysUser.getId());
        sysUserRole.setRoleId(2L);
        sysUserRoleService.save(sysUserRole);

        return ResponseUtils.success(sysUser);
    }
}
