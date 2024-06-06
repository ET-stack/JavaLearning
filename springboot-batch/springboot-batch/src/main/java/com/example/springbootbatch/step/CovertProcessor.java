package com.example.springbootbatch.step;


import org.springframework.batch.item.ItemProcessor;

/**
 * @className: CovertProcessor
 * @description: TODO 类描述
 * @date: 2023/3/21
 **/
public class CovertProcessor  implements ItemProcessor<String,String> {

    @Override
    public String process(String s) throws Exception {
        //处理业务逻辑  -->service
         String data = s.toLowerCase();
        return data;
    }
}
