package lab.nice.quartz.service;

import lab.nice.quartz.entity.QuartzJobSpecification;
import lab.nice.quartz.job.HelloTask;
import lab.nice.quartz.util.QuartzUtility;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

@Service
public class JobService implements IJobService {
    private static final Logger LOGGER = LoggerFactory.getLogger(JobService.class);

    @Autowired
    private IMockService mockService;
    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    @Override
    public boolean schedule(String jobId) {
        final QuartzJobSpecification specification = mockService.findQuartzJobSpecification(jobId);
        final JobDetail jobDetail = QuartzUtility.createJobDetails(HelloTask.class,
                specification.getJobName(), specification.getJobGroup(),
                specification.getJobDescription(), specification.getData());
        final Trigger trigger = QuartzUtility.createTrigger(
                specification.getJobName()+"-trigger",
                "default-demo-trigger-group",
                specification.getCronExpression()
        );
        final Scheduler scheduler = schedulerFactoryBean.getScheduler();
        try {
            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();
            return true;
        } catch (SchedulerException e) {
            LOGGER.error("Failed to schedule Job[jobid={}]", jobId, e);
            return false;
        }
    }
}
