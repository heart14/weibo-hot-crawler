package com.heart.crawler.weibohotcrawler.service;

import com.heart.crawler.weibohotcrawler.entity.WeiboHot;

import java.util.List;

public interface WeiboHotService {

    int deleteByPrimaryKey(Integer id);

    int insert(WeiboHot record);

    int insertSelective(WeiboHot record);

    WeiboHot selectByPrimaryKey(Integer id);

    List<WeiboHot> selectAll();

    int updateByPrimaryKeySelective(WeiboHot record);

    int updateByPrimaryKey(WeiboHot record);
}
