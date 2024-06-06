package com.example.springbootbatch.step;


import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.io.Serializable;

/**
 * @className: StringReader
 * @description: TODO 类描述
 * @date: 2023/3/21
 **/
public class StringReader implements ItemReader<String> {
    private String [] messages = {"aaa","bbb","ccc","ddd"};
    private Integer count = 0;

    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
      if (count < messages.length){
          String message = messages[count];
          return message;
      }else {
          count = 0;
      }
   return  null;
    }
}
