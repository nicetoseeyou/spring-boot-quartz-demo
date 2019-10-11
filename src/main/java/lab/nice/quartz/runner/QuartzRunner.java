package lab.nice.quartz.runner;

import lab.nice.quartz.service.IJobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QuartzRunner implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(QuartzRunner.class);

    @Autowired
    private IJobService jobService;

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("Start Quartz application.");
        jobService.schedule("1");
        jobService.schedule("2");
    }
}
