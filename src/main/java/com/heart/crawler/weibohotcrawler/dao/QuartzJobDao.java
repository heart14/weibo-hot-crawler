package com.heart.crawler.weibohotcrawler.dao;

import com.heart.crawler.weibohotcrawler.entity.QuartzJob;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuartzJobDao {

    int insertQuartzJob(QuartzJob quartzJob);

    int insertQuartzJobSelective(QuartzJob quartzJob);

    int deleteQuartzJobByPrimaryKey(Integer jobId);

    int updateQuartzJobByPrimaryKeySelective(QuartzJob quartzJob);

    int updateQuartzJobByPrimaryKey(QuartzJob quartzJob);

    QuartzJob selectQuartzJobByPrimaryKey(Integer jobId);

    List<QuartzJob> selectAllQuartzJob();

}