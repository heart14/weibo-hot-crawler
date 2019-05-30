package com.heart.crawler.weibohotcrawler.quartz;

import com.heart.crawler.weibohotcrawler.entity.WeiboHot;
import com.heart.crawler.weibohotcrawler.service.WeiboHotService;
import com.heart.crawler.weibohotcrawler.util.StringUtil;
import com.heart.crawler.weibohotcrawler.util.WeiboCrawlerUtil;
import org.quartz.Job;
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
        List<WeiboHot> weiboHots = WeiboCrawlerUtil.weiboHotCrawler();
        if (weiboHots != null) {
            logger.info("定时任务执行 : 获取当前微博热搜内容SUCCESS! " + StringUtil.formatDatetoLongString(new Date()));
            for (WeiboHot weiboHot : weiboHots) {
                weiboHotService.insert(weiboHot);
            }
        }
    }
}
