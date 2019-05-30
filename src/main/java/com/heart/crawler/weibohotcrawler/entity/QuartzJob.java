package com.heart.crawler.weibohotcrawler.entity;

public class QuartzJob {

    public static final Integer STATUS_RUNNING = 1;
    public static final Integer STATUS_NOT_RUNNING = 0;
    public static final Integer CONCURRENT_IS = 1;
    public static final Integer CONCURRENT_NOT = 0;

    private String jobId;
    /**
     * cron 表达式
     */
    private String cronExpression;
    /**
     * 任务调用的方法名
     */
    private String methodName;
    /**
     * 任务是否有状态
     */
    private Integer isConcurrent;
    /**
     * 描述
     */
    private String description;
    /**
     * 任务执行时调用哪个类的方法 包名+类名，完全限定名
     */
    private String beanName;
    /**
     * 触发器名称
     */
    private String triggerName;

    /**
     * 任务状态
     */
    private Integer jobStatus;
    /**
     * ???
     */
    private String springBean;
    /**
     * 任务名
     */
    private String jobName;

    //setter&getter
    public String getJobId() {
        return jobId;
    }

    public QuartzJob setJobId(String jobId) {
        this.jobId = jobId;
        return this;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public QuartzJob setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
        return this;
    }

    public String getMethodName() {
        return methodName;
    }

    public QuartzJob setMethodName(String methodName) {
        this.methodName = methodName;
        return this;
    }

    public Integer getIsConcurrent() {
        return isConcurrent;
    }

    public QuartzJob setIsConcurrent(Integer isConcurrent) {
        this.isConcurrent = isConcurrent;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public QuartzJob setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getBeanName() {
        return beanName;
    }

    public QuartzJob setBeanName(String beanName) {
        this.beanName = beanName;
        return this;
    }

    public String getTriggerName() {
        return triggerName;
    }

    public QuartzJob setTriggerName(String triggerName) {
        this.triggerName = triggerName;
        return this;
    }

    public Integer getJobStatus() {
        return jobStatus;
    }

    public QuartzJob setJobStatus(Integer jobStatus) {
        this.jobStatus = jobStatus;
        return this;
    }

    public String getSpringBean() {
        return springBean;
    }

    public QuartzJob setSpringBean(String springBean) {
        this.springBean = springBean;
        return this;
    }

    public String getJobName() {
        return jobName;
    }

    public QuartzJob setJobName(String jobName) {
        this.jobName = jobName;
        return this;
    }

    @Override
    public String toString() {
        return "QuartzJob{" +
                "jobId='" + jobId + '\'' +
                ", cronExpression='" + cronExpression + '\'' +
                ", methodName='" + methodName + '\'' +
                ", isConcurrent=" + isConcurrent +
                ", description='" + description + '\'' +
                ", beanName='" + beanName + '\'' +
                ", triggerName='" + triggerName + '\'' +
                ", jobStatus=" + jobStatus +
                ", springBean='" + springBean + '\'' +
                ", jobName='" + jobName + '\'' +
                '}';
    }
}
