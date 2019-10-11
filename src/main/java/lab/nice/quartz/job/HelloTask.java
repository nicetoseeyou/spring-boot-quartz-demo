package lab.nice.quartz.job;

import lab.nice.quartz.service.IMockService;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class HelloTask implements Job {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloTask.class);

    @Autowired
    private IMockService mockService;

    @Override
    public void execute(final JobExecutionContext jobExecutionContext) throws JobExecutionException {
        final JobDataMap jobDataMap = jobExecutionContext.getMergedJobDataMap();
        mockService.echo(jobDataMap.getString("message"));
    }
}
