package com.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.modules.system.dto.input.UserRoleQueryPara;
import com.modules.system.entity.UserRole;
import com.modules.system.mapper.UserRoleMapper;
import com.modules.system.service.IUserRoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * <p> 系统管理 - 用户角色关联表  服务实现类 </p>
 *
 * @author:
 * @date: 2019-08-20
 */
@Service
@Transactional
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

    @Autowired
    UserRoleMapper userRoleMapper;

    @Override
    public void listPage(Page<UserRole> page, UserRoleQueryPara filter) {
        page.setRecords(userRoleMapper.selectUserRoles(page, filter));
    }

    @Override
    public List<UserRole> list(UserRoleQueryPara filter) {
        return userRoleMapper.selectUserRoles(filter);
    }

    @Override
    public boolean save(UserRole para) {
        return Optional.of(userRoleMapper.updateById(para)).orElse(userRoleMapper.insert(para)) != 0;
    }

    @Override
    public void saveUserRole(UserRoleQueryPara para) {
        Integer roleId = para.getRoleId();
        String userIds = para.getUserIds();
        userRoleMapper.deleteByRoleId( roleId );
        if( StringUtils.isNotBlank( userIds ) ){
            String[] userIdArrays = userIds.split( "," );
            if( userIdArrays.length > 0 ){
                for (String userId : userIdArrays) {
                    UserRole userRole = new UserRole();
                    userRole.setRoleId( roleId );
                    userRole.setUserId( Integer.parseInt( userId ) );
                    userRoleMapper.insert( userRole );
                }
            }
        }
    }

}
