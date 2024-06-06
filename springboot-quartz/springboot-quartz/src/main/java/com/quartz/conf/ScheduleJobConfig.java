package com.quartz.conf;

import com.quartz.task.OrderJob;
import org.quartz.*;
import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.annotation.Resource;

import java.util.concurrent.Executor;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @className: QuartzConfiguration
 * @description: TODO 类描述
 * @date: 2023/4/19
 **/

@Configuration
public class ScheduleJobConfig {

    @Resource(name = "taskExecutor")
    private Executor taskExecutor;

    @Bean("schedulerFactoryBean")
    public SchedulerFactoryBean createFactoryBean(JobFactory jobFactory){
        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
        factoryBean.setJobFactory(jobFactory);
        factoryBean.setTaskExecutor(taskExecutor);
        factoryBean.setOverwriteExistingJobs(true);
        return factoryBean;
    }
    //通过这个类对定时任务进行操作
    @Bean
    public Scheduler scheduler(@Qualifier("schedulerFactoryBean") SchedulerFactoryBean factoryBean) {
        return factoryBean.getScheduler();
    }
}
