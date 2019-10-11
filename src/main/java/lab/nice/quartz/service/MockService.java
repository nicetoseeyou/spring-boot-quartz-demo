package lab.nice.quartz.service;

import lab.nice.quartz.entity.QuartzJobSpecification;
import lab.nice.quartz.job.HelloTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MockService implements IMockService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MockService.class);

    @Override
    public void echo(final String message) {
        LOGGER.info("Message: {}", message);
    }

    @Override
    public QuartzJobSpecification findQuartzJobSpecification(String jobId) {
        final QuartzJobSpecification specification = new QuartzJobSpecification();
        specification.setJobId(jobId);
        specification.setJobType(HelloTask.class.getName());
        specification.setJobName("default-demo-job-" + jobId);
        specification.setJobGroup("default-demo-job-group");
        specification.setJobDescription("default demo job in default job group");
        specification.setCronExpression("0/10 * * * * ?");
        final Map<String, Object> data = new HashMap<>();
        data.put("message", "greeting from " + specification.getJobName());
        specification.setData(data);
        return specification;
    }
}
