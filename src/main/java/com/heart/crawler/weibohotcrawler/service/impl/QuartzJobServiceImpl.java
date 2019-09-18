package com.heart.crawler.weibohotcrawler.service.impl;

import com.heart.crawler.weibohotcrawler.dao.QuartzJobDao;
import com.heart.crawler.weibohotcrawler.entity.QuartzJob;
import com.heart.crawler.weibohotcrawler.service.QuartzJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuartzJobServiceImpl implements QuartzJobService {

    @Autowired
    private QuartzJobDao quartzJobDao;

    @Override
    public int saveQuartzJob(QuartzJob quartzJob) {
        return quartzJobDao.insertQuartzJob(quartzJob);
    }

    @Override
    public int saveQuartzJobSelective(QuartzJob quartzJob) {
        return quartzJobDao.insertQuartzJobSelective(quartzJob);
    }

    @Override
    public int removeQuartzJobByPrimaryKey(Integer jobId) {
        return quartzJobDao.deleteQuartzJobByPrimaryKey(jobId);
    }

    @Override
    public int editQuartzJobByPrimaryKeySelective(QuartzJob quartzJob) {
        return quartzJobDao.updateQuartzJobByPrimaryKeySelective(quartzJob);
    }

    @Override
    public int editQuartzJobByPrimaryKey(QuartzJob quartzJob) {
        return quartzJobDao.updateQuartzJobByPrimaryKey(quartzJob);
    }

    @Override
    public QuartzJob findQuartzJobByPrimaryKey(Integer jobId) {
        return quartzJobDao.selectQuartzJobByPrimaryKey(jobId);
    }

    @Override
    public List<QuartzJob> findAllQuartzJob() {
        return quartzJobDao.selectAllQuartzJob();
    }
}
