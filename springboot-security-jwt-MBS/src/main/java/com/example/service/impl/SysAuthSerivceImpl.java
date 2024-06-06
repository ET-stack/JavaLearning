package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.SysAuthDao;
import com.example.entity.SysAuth;
import com.example.service.SysAuthService;
import org.springframework.stereotype.Service;

/**
 * 系统权限Service实现
 *
 * @author CL
 */
@Service
public class SysAuthSerivceImpl extends ServiceImpl<SysAuthDao, SysAuth> implements SysAuthService {

}
