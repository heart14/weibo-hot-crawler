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
 * @Description: TODO
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
     * 新增一个任务
     * @param quartzJob
     * @throws Exception
     */
    public void addJob(QuartzJob quartzJob) throws Exception {
            JobDetail jobDetail = JobBuilder.newJob(quartzJob.getJob()).withIdentity(quartzJob.getJobName(), quartzJob.getJobGroupName()).build();
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
     * 移除一个任务
     * @param quartzJob
     * @throws Exception
     */
    public void removeJob(QuartzJob quartzJob) throws Exception {
        TriggerKey triggerKey = TriggerKey.triggerKey(quartzJob.getTriggerName(), quartzJob.getTriggerGroupName());
        scheduler.pauseTrigger(triggerKey);
        scheduler.unscheduleJob(triggerKey);
        scheduler.deleteJob(JobKey.jobKey(quartzJob.getJobName(), quartzJob.getJobGroupName()));
    }
}
