package com.reptile;

import java.util.function.Function;

/**
 * @className: FunctionClass
 * @description: TODO 类描述
 * @author:
 * @date: 2023/1/6
 **/
public class FunctionClass  implements Function<Integer,String> {
    public String apply(Integer s){
        return Integer.toString(s);
    }
}
