package com.reptile;

/**
 * @className: a
 * @description: TODO 类描述
 * @author:
 * @date: 2023/7/6
 **/
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Example {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance(); // 获取当前时间
        int minutesToAdd = 30; // 增加的分钟数
        calendar.add(Calendar.MINUTE, minutesToAdd); // 在当前时间上增加指定的分钟数
        Date newDate = calendar.getTime(); // 获取修改后的时间
        System.out.println(newDate.after( new Date()));
        System.out.println(newDate); // 输出新的日期时间
    }
}