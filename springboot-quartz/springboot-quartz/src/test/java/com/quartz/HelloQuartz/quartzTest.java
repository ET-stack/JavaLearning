package com.quartz.HelloQuartz;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;

/**
 * @className: quartzTest
 * @description: TODO 类描述
 * @date: 2023/4/18
 **/
public class quartzTest {
    public static void main(String[] args) throws SchedulerException {
        SchedulerFactory schedulerFactory = new org.quartz.impl.StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
    }
}
