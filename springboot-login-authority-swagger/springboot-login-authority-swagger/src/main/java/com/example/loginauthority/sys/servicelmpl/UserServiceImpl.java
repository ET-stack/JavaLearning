package com.example.loginauthority.sys.servicelmpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.loginauthority.sys.common.ResultData;
import com.example.loginauthority.sys.mapper.UserMapper;
import com.example.loginauthority.sys.model.User;
import com.example.loginauthority.sys.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @className: UserServiceImpl
 * @description: TODO 类描述
 * @author: T
 * @date: 2022/11/18
 **/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public Object insert(User user) {

        // valid
        if (user == null) {
            return ResultData.fail("必要参数缺失");
        }

        userMapper.insert(user);
        return ResultData.success();
    }


    @Override
    public Object delete(int id) {
        int ret = userMapper.deleteById(id);
        return ret>0?ResultData.success():ResultData.fail();
    }


    @Override
    public Object update(User user) {
        int ret = userMapper.updateById(user);
        return ret>0?ResultData.success():ResultData.fail();
    }


    @Override
    public User load(int id) {
        return userMapper.selectById(id);
    }


    @Override
    public Map<String,Object> pageList(int offset, int pagesize) {
        QueryWrapper<User> wrapper = new QueryWrapper();

        Page<User> page = new Page<>(offset,pagesize);

        //IPage<User> userIPage = userMapper.selectPage(page, wrapper);

        IPage<User> UserIPage = userMapper.selectPage(page, wrapper);

        List<User> userList = UserIPage.getRecords();


        // result
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("pageList", userList);
        result.put("totalCount", UserIPage.getTotal());
        result.put("pageCount",UserIPage.getPages());

        return result;
    }

}
