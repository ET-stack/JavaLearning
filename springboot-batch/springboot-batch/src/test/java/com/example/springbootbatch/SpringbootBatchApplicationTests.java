import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ConsoleBatchConfig.class
        ,JobLauncherService.class
        ,ConsoleService.class
        ,CommonStepListener.class})
//@SpringBootTest(classes = {MainBootApplication.class,ConsoleBatchConfig.class})
@Slf4j
public class ConsoleJobTest {

    @Autowired
    private JobLauncherService jobLauncherService;

    @Autowired
    private Job consoleJob;

    @Test
    public void testConsoleJob() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        JobParameters jobParameters = JobUtil.makeJobParameters();
        Map<String, Object> stringObjectMap = jobLauncherService.startJob(consoleJob, jobParameters);
        Assert.assertEquals(ExitStatus.COMPLETED,stringObjectMap.get(SyncConstants.STR_RETURN_EXITSTATUS));
    }
}
