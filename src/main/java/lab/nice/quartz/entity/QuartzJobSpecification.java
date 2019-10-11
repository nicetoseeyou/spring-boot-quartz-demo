package lab.nice.quartz.entity;

import java.util.Map;
import java.util.Objects;

public class QuartzJobSpecification {
    private String jobId;
    private String jobType;
    private String jobName;
    private String jobGroup;
    private String jobDescription;
    private String cronExpression;
    private Map<String, Object> data;

    public QuartzJobSpecification() {
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(final String jobId) {
        this.jobId = jobId;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(final String jobType) {
        this.jobType = jobType;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(final String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(final String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(final String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(final String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(final Map<String, Object> data) {
        this.data = data;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final QuartzJobSpecification that = (QuartzJobSpecification) o;
        return Objects.equals(jobId, that.jobId) &&
                Objects.equals(jobType, that.jobType) &&
                Objects.equals(jobName, that.jobName) &&
                Objects.equals(jobGroup, that.jobGroup) &&
                Objects.equals(jobDescription, that.jobDescription) &&
                Objects.equals(cronExpression, that.cronExpression) &&
                Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobId, jobType, jobName, jobGroup, jobDescription, cronExpression, data);
    }

    @Override
    public String toString() {
        return "QuartzJobSpecification{" +
                "jobId='" + jobId + '\'' +
                ", jobType='" + jobType + '\'' +
                ", jobName='" + jobName + '\'' +
                ", jobGroup='" + jobGroup + '\'' +
                ", jobDescription='" + jobDescription + "\'" +
                ", cronExpression='" + cronExpression + '\'' +
                ", data=" + data +
                '}';
    }
}
