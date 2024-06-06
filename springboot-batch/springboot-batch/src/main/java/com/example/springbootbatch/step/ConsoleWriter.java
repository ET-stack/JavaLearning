package com.example.springbootbatch.step;


import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * @className: ItemWriter
 * @description: TODO 类描述
 * @date: 2023/3/21
 **/
public class ConsoleWriter implements ItemWriter<String> {
    @Override
    public void write(List<? extends String> list) throws Exception {
        for (String s :list){
            System.out.println("写入日志"+s);
        }
    }
}
