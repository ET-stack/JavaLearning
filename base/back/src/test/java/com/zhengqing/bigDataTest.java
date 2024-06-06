package com.zhengqing;

import com.modules.system.entity.SysLog;
import com.modules.system.mapper.LogMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.crypto.Data;

/**
 * @className: bigDataTest
 * @description: TODO 类描述
 * @author: {yitao@flyread.com.cn}
 * @date: 2022/7/27
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class bigDataTest {
    @Autowired
    LogMapper logMapper;

    @Test
    public void  wirteData(){
        for (int i = 0;i < 10000000;i++){
            SysLog sysLog = new SysLog();
            sysLog.setName("test"+i);
            sysLog.setStatus(1);
            sysLog.setUsername("testUser"+i+"-"+Math.random());

            logMapper.insert(sysLog);
        }
    }

}
