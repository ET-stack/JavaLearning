package com.example.controller;

import com.example.config.SysUserDetails;
import com.example.entity.SysUser;
import com.example.service.SysUserService;
import com.example.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 普通用户Contrller
 *
 * @author CL
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private SysUserService sysUserSerivce;

    /**
     * 查询用户信息
     *
     * @return
     */
    @PreAuthorize(value = "hasPermission('/user/info', 'm:user:info')")
    @RequestMapping(value = "/info")
    public ResponseUtils info() {
        SysUserDetails sysUserDetails = (SysUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        SysUser sysUser = sysUserSerivce.getById(sysUserDetails.getId());
        return ResponseUtils.success(sysUser);
    }

}
