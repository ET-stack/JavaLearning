package com.yi.service;

import com.fei.SayFacade;

/**
 * @author Yi
 * @date 2020/7/8 21:50
 */
@Service
public class SyaFacadeImpl implements SayFacade {

    @Override
    public String say(String context) {
        return "小肥羊对你说：" + context;
    }
}
