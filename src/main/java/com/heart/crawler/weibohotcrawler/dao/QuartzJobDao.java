package com.heart.crawler.weibohotcrawler.dao;

import com.heart.crawler.weibohotcrawler.entity.QuartzJob;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuartzJobDao {
    int deleteByPrimaryKey(Integer jobId);

    int insert(QuartzJob record);

    int insertSelective(QuartzJob record);

    QuartzJob selectByPrimaryKey(Integer jobId);

    List<QuartzJob> selectAll();

    int updateByPrimaryKeySelective(QuartzJob record);

    int updateByPrimaryKey(QuartzJob record);
}