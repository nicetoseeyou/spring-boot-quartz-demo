package lab.nice.quartz.config;

import lab.nice.quartz.common.AutowiringSpringBeanJobFactory;
import org.quartz.spi.JobFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.util.Properties;

@Configuration
public class QuartzConfiguration {
    @Bean
    public JobFactory jobFactory(final ApplicationContext applicationContext) {
        final AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
        jobFactory.setApplicationContext(applicationContext);
        return jobFactory;
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(final JobFactory jobFactory) {
        final SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setOverwriteExistingJobs(true);
        schedulerFactoryBean.setJobFactory(jobFactory);
        final Properties quartzProp = new Properties();
        quartzProp.setProperty("org.quartz.scheduler.instanceName", "Demo");
        quartzProp.setProperty("org.quartz.scheduler.instanceId", "1");
        quartzProp.setProperty("org.quartz.scheduler.skipUpdateCheck", "true");
        quartzProp.setProperty("org.quartz.scheduler.threadName", "QWorker");
        quartzProp.setProperty("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
        quartzProp.setProperty("org.quartz.threadPool.threadCount", "3");
        quartzProp.setProperty("org.quartz.threadPool.threadPriority", "5");
        quartzProp.setProperty("org.quartz.jobStore.misfireThreshold", "60000");
        quartzProp.setProperty("org.quartz.jobStore.class", "org.quartz.simpl.RAMJobStore");
        schedulerFactoryBean.setQuartzProperties(quartzProp);
        return schedulerFactoryBean;
    }
}
