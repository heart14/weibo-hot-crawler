package com.heart.crawler.weibohotcrawler.entity;

import org.quartz.Job;

import java.util.Date;
import java.util.List;

public class QuartzJob {

    /**
     * job id
     */
    private String jobId;

    /**
     * 任务名（唯一）
     */
    private String jobName;

    /**
     * 任务组名（可重复）
     */
    private String jobGroupName;

    /**
     * 触发器名（唯一）
     */
    private String triggerName;

    /**
     * 触发器组名（可重复）
     */
    private String triggerGroupName;

    /**
     * 任务参数
     */
    private String jobParams;

    /**
     * 任务执行时间
     */
    private long executeTime;

    /**
     * 任务执行cron表达式
     */
    private String cronExpression;

    /**
     * 任务并发状态
     */
    private int concurrent;

    /**
     * 任务bean name
     */
    private String beanName;

    /**
     * 任务method name
     */
    private String methodName;

    /**
     * 任务描述
     */
    private String description;

    /**
     * 任务执行状态
     */
    private int jobStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 任务类
     */
    private Class<? extends Job> job;

    /**
     * 任务参数
     */
    private List<String> jobParamsList;

    public String getJobId() {
        return jobId;
    }

    public QuartzJob setJobId(String jobId) {
        this.jobId = jobId;
        return this;
    }

    public String getJobName() {
        return jobName;
    }

    public QuartzJob setJobName(String jobName) {
        this.jobName = jobName;
        return this;
    }

    public String getJobGroupName() {
        return jobGroupName;
    }

    public QuartzJob setJobGroupName(String jobGroupName) {
        this.jobGroupName = jobGroupName;
        return this;
    }

    public String getTriggerName() {
        return triggerName;
    }

    public QuartzJob setTriggerName(String triggerName) {
        this.triggerName = triggerName;
        return this;
    }

    public String getTriggerGroupName() {
        return triggerGroupName;
    }

    public QuartzJob setTriggerGroupName(String triggerGroupName) {
        this.triggerGroupName = triggerGroupName;
        return this;
    }

    public List<String> getJobParamsList() {
        return jobParamsList;
    }

    public QuartzJob setJobParamsList(List<String> jobParamsList) {
        this.jobParamsList = jobParamsList;
        return this;
    }

    public String getJobParams() {
        return jobParams;
    }

    public QuartzJob setJobParams(String jobParams) {
        this.jobParams = jobParams;
        return this;
    }

    public long getExecuteTime() {
        return executeTime;
    }

    public QuartzJob setExecuteTime(long executeTime) {
        this.executeTime = executeTime;
        return this;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public QuartzJob setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
        return this;
    }

    public int getConcurrent() {
        return concurrent;
    }

    public QuartzJob setConcurrent(int concurrent) {
        this.concurrent = concurrent;
        return this;
    }

    public String getBeanName() {
        return beanName;
    }

    public QuartzJob setBeanName(String beanName) {
        this.beanName = beanName;
        return this;
    }

    public String getMethodName() {
        return methodName;
    }

    public QuartzJob setMethodName(String methodName) {
        this.methodName = methodName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public QuartzJob setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getJobStatus() {
        return jobStatus;
    }

    public QuartzJob setJobStatus(int jobStatus) {
        this.jobStatus = jobStatus;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public QuartzJob setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public QuartzJob setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Class<? extends Job> getJob() {
        return job;
    }

    public QuartzJob setJob(Class<? extends Job> job) {
        this.job = job;
        return this;
    }

    @Override
    public String toString() {
        return "QuartzJob{" +
                "jobId='" + jobId + '\'' +
                ", jobName='" + jobName + '\'' +
                ", jobGroupName='" + jobGroupName + '\'' +
                ", triggerName='" + triggerName + '\'' +
                ", triggerGroupName='" + triggerGroupName + '\'' +
                ", jobParams=" + jobParams +
                ", executeTime=" + executeTime +
                ", cronExpression='" + cronExpression + '\'' +
                ", concurrent=" + concurrent +
                ", beanName='" + beanName + '\'' +
                ", methodName='" + methodName + '\'' +
                ", description='" + description + '\'' +
                ", jobStatus=" + jobStatus +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
