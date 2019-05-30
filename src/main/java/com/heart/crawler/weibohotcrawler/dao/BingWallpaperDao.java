package com.heart.crawler.weibohotcrawler.dao;

import com.heart.crawler.weibohotcrawler.entity.BingWallpaper;
import org.springframework.stereotype.Repository;

@Repository
public interface BingWallpaperDao {

    int deleteByPrimaryKey(Integer id);

    int insert(BingWallpaper record);

    int insertSelective(BingWallpaper record);

    BingWallpaper selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BingWallpaper record);

    int updateByPrimaryKey(BingWallpaper record);
}