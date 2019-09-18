package com.heart.crawler.weibohotcrawler.service;

import com.heart.crawler.weibohotcrawler.entity.QuartzJob;

import java.util.List;

public interface QuartzJobService {

    int saveQuartzJob(QuartzJob quartzJob);

    int saveQuartzJobSelective(QuartzJob quartzJob);

    int removeQuartzJobByPrimaryKey(Integer jobId);

    int editQuartzJobByPrimaryKeySelective(QuartzJob quartzJob);

    int editQuartzJobByPrimaryKey(QuartzJob quartzJob);

    QuartzJob findQuartzJobByPrimaryKey(Integer jobId);

    List<QuartzJob> findAllQuartzJob();
}
