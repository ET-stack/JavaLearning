package com.example.demo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @className: ObjectFormatTest
 * @description: TODO 类描述
 * @author: {yitao@flyread.com.cn}
 * @date: 2022/8/5
 **/
public class ObjectFormatTest {

    public static void main(String[] args) throws Exception {

        Map<String,String>  config = new HashMap<>();
        config.put("b.time","今天的日期是<a2:yyyy-MM-dd>");
        config.put("dbl","数值<a1>为123：<a3:###,##0.00>");
        AA aa = new AA();
        aa.setA1("a1");
        aa.setA2(new Date());
        aa.setA3(10.2);
        ObjectFormat format = new ObjectFormat(config);
        String objStr =  format.format(aa);
        System.out.println("返回后的值"+objStr);
//        "{b:{time:'今天的日期是2022-8-05'},dbl:'数值a1为：10.20''}"



    }
}
