package com.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.modules.system.service.ILogService;
import com.modules.system.entity.SysLog;
import com.modules.system.dto.input.LogQueryPara;
import com.modules.system.mapper.LogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * <p> 系统管理 - 日志表 服务实现类 </p>
 *
 */
@Service
@Transactional
public class LogServiceImpl extends ServiceImpl<LogMapper, SysLog> implements ILogService {

    @Autowired
    LogMapper logMapper;

    @Override
    public void listPage(Page<SysLog> page, LogQueryPara para) {
        List<SysLog> result = logMapper.selectLogs(page, para);
        result.forEach( e->{
            if (e.getUserId()==0){
                e.setUsername("非法人员");
            }
        });
        page.setRecords(result);
    }

    @Override
    public List<SysLog> list(LogQueryPara para) {
        return logMapper.selectLogs(para);
    }

    @Override
    public boolean save(SysLog para) {
        return Optional.of(logMapper.updateById(para)).orElse(logMapper.insert(para)) != 0;
    }

}
