package com.heart.crawler.weibohotcrawler.controller;

import com.heart.crawler.weibohotcrawler.entity.QuartzJob;
import com.heart.crawler.weibohotcrawler.quartz.QuartzJobManager;
import com.heart.crawler.weibohotcrawler.service.QuartzJobService;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/quartz")
@Controller
public class QuartzController {

    public static final Logger logger = LoggerFactory.getLogger(QuartzController.class);

    @Autowired
    private QuartzJobService quartzJobService;

    @Autowired
    private QuartzJobManager quartzJobManager;

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
        return quartzJobService.selectAll();
    }


    /**
     * 新增定时任务
     *
     * @param
     */
    @RequestMapping("/addQuartzJob")
    public void addQuartzJob(int jobId) {
        QuartzJob quartzJob = quartzJobService.selectByPrimaryKey(jobId);
        jobId = jobId + 1;
        quartzJob.setJobId(String.valueOf(jobId));
        logger.info("新增定时任务 : " + quartzJob.toString());
        int insert = quartzJobService.insert(quartzJob);
        try {
            quartzJobManager.addJob(quartzJob);
        } catch (SchedulerException e) {
            logger.error("新增定时任务失败 : {}", e.getMessage());
            return;
        } catch (ClassNotFoundException e) {
            logger.error("新增定时任务失败 : {}", e.getMessage());
            return;
        } catch (IllegalAccessException e) {
            logger.error("新增定时任务失败 : {}", e.getMessage());
            return;
        } catch (InstantiationException e) {
            logger.error("新增定时任务失败 : {}", e.getMessage());
            return;
        }
        logger.info("新增定时任务 : " + (insert == 1 ? "成功" : "失败"));
    }

    /**
     * 移除定时任务
     *
     * @param jobId
     */
    @RequestMapping("/removeQuartzJob")
    public void removeQuartzJob(int jobId) {
        logger.info("移除定时任务 : jobId = " + jobId);
        int deleteByPrimaryKey = quartzJobService.deleteByPrimaryKey(jobId);
        try {
            quartzJobManager.deleteJob(quartzJobService.selectByPrimaryKey(jobId));
        } catch (SchedulerException e) {
            logger.error("移除定时任务失败 : {}", e.getMessage());
            return;
        }
        logger.info("移除定时任务 : " + (deleteByPrimaryKey == 1 ? "成功" : "失败"));
    }

    /**
     * 开始定时任务
     *
     * @param jobId
     */
    @RequestMapping("/startQuartzJob")
    public void startQuartzJob(int jobId) {
        logger.info("开始定时任务 : jobId = " + jobId);
        QuartzJob quartzJob = quartzJobService.selectByPrimaryKey(jobId);
        if (quartzJob == null) {
            logger.info("开始定时任务 : 失败！任务不存在。");
            return;
        }
        try {
            quartzJobManager.runAJobNow(quartzJob);
        } catch (SchedulerException e) {
            logger.error("开始定时任务失败 : {}", e.getMessage());
            return;
        }
        logger.info("开始定时任务 : 成功！");
    }
}
