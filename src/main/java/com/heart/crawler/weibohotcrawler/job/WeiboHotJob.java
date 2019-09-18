package com.heart.crawler.weibohotcrawler.job;

import com.heart.crawler.weibohotcrawler.entity.WeiboHot;
import com.heart.crawler.weibohotcrawler.service.WeiboHotService;
import com.heart.crawler.weibohotcrawler.util.StringUtil;
import com.heart.crawler.weibohotcrawler.util.WeiboCrawlerUtil;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class WeiboHotJob implements Job {

    private Logger logger = LoggerFactory.getLogger(WeiboHotJob.class);

    @Autowired
    private WeiboHotService weiboHotService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("定时任务开始执行 :{}", StringUtil.formatDatetoLongString(new Date()));

        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        String p0 = (String) jobDataMap.get("p0");
        String p1 = (String) jobDataMap.get("p1");
        String p2 = (String) jobDataMap.get("p2");
        logger.info("PARAMS :{}, {}, {}", p0, p1, p2);

        List<WeiboHot> weiboHots = WeiboCrawlerUtil.weiboHotCrawler();
        if (weiboHots != null) {
            logger.info("获取当前微博热搜内容 :SUCCESS! ");
            for (WeiboHot weiboHot : weiboHots) {
                weiboHotService.insert(weiboHot);
            }
        }
    }
}
