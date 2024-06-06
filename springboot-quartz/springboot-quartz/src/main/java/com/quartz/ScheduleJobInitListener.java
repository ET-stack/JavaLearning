package com.quartz;

import com.quartz.service.ScheduleJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @className: ScheduleJobInitListener
 * @description: TODO 类描述
 * @date: 2023/4/19
 **/
@Component
public class ScheduleJobInitListener implements CommandLineRunner {

    @Autowired
    private ScheduleJobService jobService;

    @Override
    public void run(String... strings) throws Exception {
        jobService.startJob();
    }
}