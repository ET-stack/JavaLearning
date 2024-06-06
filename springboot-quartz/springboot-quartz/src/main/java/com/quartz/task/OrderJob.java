package com.quartz.task;

import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @className: OrderJob
 * @description: TODO 类描述
 * @date: 2023/4/19
 **/

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class OrderJob implements Job {
    Logger log = LoggerFactory.getLogger(this.getClass());
    private static final String NUM_EXECUTIONS = "NumExecutions";

    @Override
    public void execute(JobExecutionContext context) {
        int executeCount = 0;
        JobKey jobKey = context.getJobDetail().getKey();
        JobDataMap map = context.getJobDetail().getJobDataMap();

        if (map.containsKey(NUM_EXECUTIONS)) {
            executeCount = Integer.valueOf(map.getString(NUM_EXECUTIONS));
        }
        executeCount++;
        map.put(NUM_EXECUTIONS, String.valueOf(executeCount));


        log.info("{}-处理逻辑-start：*** {}", jobKey, executeCount);
        log.info("{}-处理逻辑-end：*** {}", jobKey, executeCount);
    }
}
