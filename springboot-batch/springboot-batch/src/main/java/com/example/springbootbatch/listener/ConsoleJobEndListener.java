package com.example.springbootbatch.listener;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

/**
 * @className: JobExecutionListener
 * @description: TODO 任务监听器 用于监听任务执行前 执行后
 * @date: 2023/3/21
 **/
public class ConsoleJobEndListener extends JobExecutionListenerSupport {
    @Override
    public void beforeJob(JobExecution jobExecution) {

    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED){
            System.out.println("任务执行完了");
        }
    }
}
