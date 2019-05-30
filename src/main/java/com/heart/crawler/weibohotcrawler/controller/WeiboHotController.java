package com.heart.crawler.weibohotcrawler.controller;

import com.heart.crawler.weibohotcrawler.entity.BingWallpaper;
import com.heart.crawler.weibohotcrawler.entity.QuartzJob;
import com.heart.crawler.weibohotcrawler.entity.WeiboHot;
import com.heart.crawler.weibohotcrawler.quartz.QuartzJobManager;
import com.heart.crawler.weibohotcrawler.service.BingWallpaperService;
import com.heart.crawler.weibohotcrawler.service.QuartzJobService;
import com.heart.crawler.weibohotcrawler.service.WeiboHotService;
import com.heart.crawler.weibohotcrawler.util.FileDownloadUtil;
import com.heart.crawler.weibohotcrawler.util.WeiboCrawlerUtil;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/weibo")
public class WeiboHotController {

    private Logger logger = LoggerFactory.getLogger(WeiboHotController.class);

    @Autowired
    private WeiboHotService weiboHotService;

    @Autowired
    private QuartzJobService quartzJobService;

    @Autowired
    private QuartzJobManager quartzJobManager;

    @Autowired
    private BingWallpaperService bingWallpaperService;

    @RequestMapping("/index")
    public ModelAndView indexPage() {
        return new ModelAndView("weibohot");
    }

    @RequestMapping("/quartz")
    public ModelAndView quartzManagePage() {
        return new ModelAndView("quartzmanage");
    }

    @RequestMapping("/hot")
    public List<WeiboHot> getWeiboHot() {
        List<WeiboHot> weiboHots = WeiboCrawlerUtil.weiboHotCrawler();
        if (weiboHots == null) {
            System.out.println("空空如也！");
            return null;
        }

        return weiboHots;
    }

    @RequestMapping("/bing/{pageNum}")
    public void downBingPaper(@PathVariable int pageNum) {
        List<BingWallpaper> bingWallpapers = WeiboCrawlerUtil.bingWallpaperCrawler(pageNum);
        List<String> urls = new ArrayList<>();
        for (BingWallpaper bingWallpaper : bingWallpapers) {
            bingWallpaperService.insert(bingWallpaper);
            urls.add(bingWallpaper.getDownloadUrl());
        }
        //FileDownloadUtil.batchDownload(urls);
    }

    /**
     * 查询所有定时任务
     *
     * @return
     */
    @RequestMapping("/getQuartzJob")
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


    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public void testtt(String param1, String param2, String param3) {
        logger.info("param1 : {}", param1);
        logger.info("param2 : {}", param2);
        logger.info("param3 : {}", param3);
    }
}
