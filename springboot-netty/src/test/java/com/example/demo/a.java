package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.HashMap;

/**
 * @className: a
 * @description: TODO 类描述
 * @author: {yitao@flyread.com.cn}
 * @date: 2022/8/5
 **/
public class a {
    public static void main(String[] args) {
//        ObjectMapper mapper = new ObjectMapper();
//        ObjectNode a1 = mapper.createObjectNode();
//        ObjectNode time = mapper.createObjectNode();
//        ObjectNode b1 = mapper.createObjectNode();
//        a1.put("b",b1);
//        time.put("time","2019-12-33");
//        b1.put("b1",time);
//        a1.put("db1","fwjrewr");
//        System.out.println(a1);

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode root  = mapper.createObjectNode();
        ObjectNode root1  = mapper.createObjectNode();

        root.put("a1",root1);

        for (int i = 0;i < 3;i++){
            root1  = mapper.createObjectNode();
            root1.put("a2",root1);
        }
        root.put("a1",root1);
        System.out.println(root);

    }
}
