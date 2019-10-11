package lab.nice.quartz.service;

import lab.nice.quartz.entity.QuartzJobSpecification;

public interface IMockService {
    void echo(final String message);
    QuartzJobSpecification findQuartzJobSpecification(final String jobId);
}
