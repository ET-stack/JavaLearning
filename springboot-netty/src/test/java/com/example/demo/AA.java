package com.example.demo;

import java.util.Date;
import java.util.List;

/**
 * @className: AA
 * @description: TODO 类描述
 * @author: {yitao@flyread.com.cn}
 * @date: 2022/8/5
 **/
public class AA {
    private List<String> stringList;

    private String a1;

    private Date a2;


    private Double  a3;

    public Date getA2() {
        return a2;
    }

    public void setA2(Date a2) {
        this.a2 = a2;
    }

    public Double getA3() {
        return a3;
    }

    public void setA3(Double a3) {
        this.a3 = a3;
    }

    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }
}
