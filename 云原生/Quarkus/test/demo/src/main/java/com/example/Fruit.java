package com.example;

/**
 * @className: Fruit
 * @description: TODO 类描述
 * @author: {yitao@flyread.com.cn}
 * @date: 2022/9/6
 **/
public class Fruit {

    public String name;
    public String description;

    public Fruit() {
    }

    public Fruit(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}