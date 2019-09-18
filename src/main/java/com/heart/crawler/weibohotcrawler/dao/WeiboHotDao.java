package com.heart.crawler.weibohotcrawler.dao;

import com.heart.crawler.weibohotcrawler.entity.WeiboHot;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeiboHotDao {

    int insert(WeiboHot record);

    int insertSelective(WeiboHot record);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeiboHot record);

    int updateByPrimaryKey(WeiboHot record);

    WeiboHot selectByPrimaryKey(Integer id);

    List<WeiboHot> selectAll();

}