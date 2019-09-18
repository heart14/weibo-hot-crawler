package com.heart.crawler.weibohotcrawler.controller;

import com.heart.crawler.weibohotcrawler.entity.QuartzJob;
import com.heart.crawler.weibohotcrawler.job.WeiboHotJob;
import com.heart.crawler.weibohotcrawler.quartz.QuartzJobUtils;
import com.heart.crawler.weibohotcrawler.service.QuartzJobService;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping("/quartz")
@Controller
public class QuartzController {

    public static final Logger logger = LoggerFactory.getLogger(QuartzController.class);

    @Autowired
    private QuartzJobService quartzJobService;

    @Autowired
    private QuartzJobUtils quartzJobUtils;

    @RequestMapping("/index")
    public ModelAndView quartzManagePage() {
        return new ModelAndView("quartzmanage");
    }


    /**
     * 查询所有定时任务
     *
     * @return
     */
    @RequestMapping("/getQuartzJob")
    @ResponseBody
    public List<QuartzJob> getQuartzJob() {
        return quartzJobService.findAllQuartzJob();
    }


    /**
     * 新增定时任务
     *
     * @param
     */
    @RequestMapping("/add/{a}")
    @ResponseBody
    public String addQuartzJob(@PathVariable("a") int a) {
        QuartzJob quartzJob = new QuartzJob();
        quartzJob.setJobId("quartzJob0000" + a);
        quartzJob.setJobName("quartzJob:name:" + a);
        quartzJob.setJobGroupName("quartzJob:group:name:" + a);
        quartzJob.setTriggerName("quartzJob:trigger:name:" + a);
        quartzJob.setTriggerGroupName("quartzJob:trigger:group:name:" + a);
        quartzJob.setJob(WeiboHotJob.class);
        quartzJob.setBeanName(WeiboHotJob.class.getName());
        quartzJob.setMethodName("execute");
        if (a == 1) {
            quartzJob.setExecuteTime(System.currentTimeMillis());
        } else {
            quartzJob.setCronExpression("*/1 * * * * ?");
        }
        quartzJob.setDescription("测试定时任务");
        quartzJob.setCreateTime(new Date());

        List<String> paramList = new ArrayList<>();
        paramList.add("quartz-" + a);
        paramList.add("test-" + a);
        paramList.add("params-" + a);
        quartzJob.setJobParamsList(paramList);

        try {
            quartzJobUtils.addJob(quartzJob);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

        return "ok";
    }

    /**
     * 移除定时任务
     */
    @RequestMapping("/remove/{a}")
    @ResponseBody
    public String removeQuartzJob(@PathVariable("a") int a) {

        QuartzJob quartzJob = new QuartzJob();
        quartzJob.setJobId("quartzJob0000" + a);
        quartzJob.setJobName("quartzJob:name:" + a);
        quartzJob.setJobGroupName("quartzJob:group:name:" + a);
        quartzJob.setTriggerName("quartzJob:trigger:name:" + a);
        quartzJob.setTriggerGroupName("quartzJob:trigger:group:name:" + a);
        quartzJob.setJob(WeiboHotJob.class);
        quartzJob.setBeanName(WeiboHotJob.class.getName());
        quartzJob.setMethodName("execute");
        quartzJob.setCronExpression("*/1 * * * * ?");
        quartzJob.setDescription("测试定时任务");
        quartzJob.setCreateTime(new Date());

        List<String> paramList = new ArrayList<>();
        paramList.add("quartz-" + a);
        paramList.add("test-" + a);
        paramList.add("params-" + a);
        quartzJob.setJobParamsList(paramList);

        try {
            quartzJobUtils.removeJob(quartzJob);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

        return "ok";
    }

    /**
     * 开始定时任务
     *
     * @param jobId
     */
    @RequestMapping("/startQuartzJob")
    public void startQuartzJob(int jobId) {
    }
}
