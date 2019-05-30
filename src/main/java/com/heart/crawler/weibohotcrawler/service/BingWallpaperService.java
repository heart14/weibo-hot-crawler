package com.heart.crawler.weibohotcrawler.service;

import com.heart.crawler.weibohotcrawler.entity.BingWallpaper;

public interface BingWallpaperService {

    int deleteByPrimaryKey(Integer id);

    int insert(BingWallpaper record);

    int insertSelective(BingWallpaper record);

    BingWallpaper selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BingWallpaper record);

    int updateByPrimaryKey(BingWallpaper record);
}
