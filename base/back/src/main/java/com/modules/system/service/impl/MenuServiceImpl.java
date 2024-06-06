package com.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.modules.system.dto.input.MenuQueryPara;
import com.modules.system.entity.Menu;
import com.modules.system.mapper.MenuMapper;
import com.modules.system.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * <p> 系统管理-菜单表  服务实现类 </p>
 *
 * @author:
 * @date: 2019-08-19
 */
@Service
@Transactional
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Autowired
    MenuMapper menuMapper;

    @Override
    public List <Menu> listTreeMenu() {
        return menuMapper.selectList(null);
    }

    @Override
    public void listPage(Page<Menu> page, MenuQueryPara filter) {
        page.setRecords(menuMapper.selectMenus(page, filter));
    }

    @Override
    public List<Menu> list(MenuQueryPara filter) {
        return menuMapper.selectMenus(filter);
    }

    @Override
    public boolean save(Menu para) {
        return Optional.of(menuMapper.updateById(para)).orElse(menuMapper.insert(para)) != 0;
    }

}
