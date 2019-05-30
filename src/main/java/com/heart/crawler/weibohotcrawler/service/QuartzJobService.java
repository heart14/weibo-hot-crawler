package com.heart.crawler.weibohotcrawler.service;

import com.heart.crawler.weibohotcrawler.entity.QuartzJob;

import java.util.List;

public interface QuartzJobService {

    int deleteByPrimaryKey(Integer jobId);

    int insert(QuartzJob record);

    int insertSelective(QuartzJob record);

    QuartzJob selectByPrimaryKey(Integer jobId);

    List<QuartzJob> selectAll();

    int updateByPrimaryKeySelective(QuartzJob record);

    int updateByPrimaryKey(QuartzJob record);
}
