package com.quartz.task;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @className: MyJob
 * @description: TODO 类描述
 * @date: 2023/4/19
 **/
public class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("定时任务开始"+now.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }
}