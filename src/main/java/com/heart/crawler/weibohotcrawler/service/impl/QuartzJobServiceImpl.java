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
    public int deleteByPrimaryKey(Integer jobId) {
        return quartzJobDao.deleteByPrimaryKey(jobId);
    }

    @Override
    public int insert(QuartzJob record) {
        return quartzJobDao.insert(record);
    }

    @Override
    public int insertSelective(QuartzJob record) {
        return quartzJobDao.insertSelective(record);
    }

    @Override
    public QuartzJob selectByPrimaryKey(Integer jobId) {
        return quartzJobDao.selectByPrimaryKey(jobId);
    }

    @Override
    public List<QuartzJob> selectAll() {
        return quartzJobDao.selectAll();
    }

    @Override
    public int updateByPrimaryKeySelective(QuartzJob record) {
        return quartzJobDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(QuartzJob record) {
        return quartzJobDao.updateByPrimaryKey(record);
    }
}
