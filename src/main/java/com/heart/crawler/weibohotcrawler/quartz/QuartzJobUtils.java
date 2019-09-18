package com.heart.crawler.weibohotcrawler.quartz;

import com.heart.crawler.weibohotcrawler.entity.QuartzJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * @ClassName: QuartzJobUtils
 * @Description: 定时任务控制工具类
 * @Author: jayhe
 * @Date: 2019/9/18 14:46
 * @Version: v1.0
 */
@Component
public class QuartzJobUtils {

    @Autowired
    @Qualifier("scheduler")
    private Scheduler scheduler;

    /**
     * 新增任务
     *
     * @param quartzJob
     * @throws SchedulerException
     */
    public void addJob(QuartzJob quartzJob) throws SchedulerException {
        //创建JobDetail
        JobDetail jobDetail = JobBuilder.newJob(quartzJob.getJob()).withIdentity(quartzJob.getJobName(), quartzJob.getJobGroupName()).build();
        //创建触发器Trigger
        Trigger trigger;
        if (!StringUtils.isEmpty(quartzJob.getCronExpression())) {
            trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule(quartzJob.getCronExpression())).startNow().withIdentity(quartzJob.getTriggerName(), quartzJob.getTriggerGroupName()).build();
        } else {
            trigger = TriggerBuilder.newTrigger().startAt(new Date(quartzJob.getExecuteTime())).withIdentity(quartzJob.getTriggerName(), quartzJob.getTriggerGroupName()).build();
        }
        if (quartzJob.getJobParamsList() != null && quartzJob.getJobParamsList().size() > 0) {
            for (int i = 0; i < quartzJob.getJobParamsList().size(); i++) {
                jobDetail.getJobDataMap().put("p" + i, quartzJob.getJobParamsList().get(i));
            }
        }
        scheduler.scheduleJob(jobDetail, trigger);
        if (!scheduler.isShutdown()) {
            scheduler.start();
        }
    }

    /**
     * 移除任务
     *
     * @param quartzJob
     * @throws SchedulerException
     */
    public void removeJob(QuartzJob quartzJob) throws SchedulerException {
        TriggerKey triggerKey = TriggerKey.triggerKey(quartzJob.getTriggerName(), quartzJob.getTriggerGroupName());
        scheduler.pauseTrigger(triggerKey);
        scheduler.unscheduleJob(triggerKey);
        scheduler.deleteJob(JobKey.jobKey(quartzJob.getJobName(), quartzJob.getJobGroupName()));
    }

    /**
     * 立即执行任务
     *
     * @param quartzJob
     * @throws SchedulerException
     */
    public void startJobNow(QuartzJob quartzJob) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(quartzJob.getJobName());
        scheduler.triggerJob(jobKey);
    }

    /**
     * 暂停任务
     *
     * @param quartzJob
     * @throws SchedulerException
     */
    public void pauseJob(QuartzJob quartzJob) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(quartzJob.getJobName());
        scheduler.pauseJob(jobKey);
    }

    /**
     * 恢复任务
     *
     * @param quartzJob
     * @throws SchedulerException
     */
    public void resumeJob(QuartzJob quartzJob) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(quartzJob.getJobName());
        scheduler.resumeJob(jobKey);
    }
}
