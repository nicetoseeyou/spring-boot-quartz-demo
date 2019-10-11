package lab.nice.quartz.util;


import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.TriggerBuilder;

import java.util.Map;

public final class QuartzUtility {
    private QuartzUtility() {

    }

    public static JobDetail createJobDetails(final Class<? extends Job> jobType, final String jobName,
                                             final String jobGroup, final String jobDescription,
                                             final Map data) {
        return JobBuilder.newJob()
                .ofType(jobType)
                .withIdentity(jobName, jobGroup)
                .withDescription(jobDescription)
                .usingJobData(new JobDataMap(data))
                .build();
    }

    public static CronTrigger createTrigger(final String triggerName, final String triggerGroup,
                                            final String cronExpression) {
        return TriggerBuilder.newTrigger()
                .withIdentity(triggerName, triggerGroup)
                .withSchedule(cronScheduleBuilder(cronExpression))
                .build();
    }

    public static CronScheduleBuilder cronScheduleBuilder(final String cronExpression) {
        return CronScheduleBuilder.cronSchedule(cronExpression);
    }
}
