package com.heart.crawler.weibohotcrawler.service.impl;

import com.heart.crawler.weibohotcrawler.dao.BingWallpaperDao;
import com.heart.crawler.weibohotcrawler.entity.BingWallpaper;
import com.heart.crawler.weibohotcrawler.service.BingWallpaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BingWallpaperServiceImpl implements BingWallpaperService {

    @Autowired
    private BingWallpaperDao bingWallpaperDao;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return bingWallpaperDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(BingWallpaper record) {
        return bingWallpaperDao.insert(record);
    }

    @Override
    public int insertSelective(BingWallpaper record) {
        return bingWallpaperDao.insertSelective(record);
    }

    @Override
    public BingWallpaper selectByPrimaryKey(Integer id) {
        return bingWallpaperDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BingWallpaper record) {
        return bingWallpaperDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BingWallpaper record) {
        return bingWallpaperDao.updateByPrimaryKey(record);
    }
}
