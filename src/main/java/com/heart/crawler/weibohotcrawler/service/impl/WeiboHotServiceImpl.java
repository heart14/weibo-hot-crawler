package com.heart.crawler.weibohotcrawler.service.impl;

import com.heart.crawler.weibohotcrawler.dao.WeiboHotDao;
import com.heart.crawler.weibohotcrawler.entity.WeiboHot;
import com.heart.crawler.weibohotcrawler.service.WeiboHotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeiboHotServiceImpl implements WeiboHotService {

    @Autowired
    private WeiboHotDao weiboHotDao;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return weiboHotDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(WeiboHot record) {
        return weiboHotDao.insert(record);
    }

    @Override
    public int insertSelective(WeiboHot record) {
        return weiboHotDao.insertSelective(record);
    }

    @Override
    public WeiboHot selectByPrimaryKey(Integer id) {
        return weiboHotDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(WeiboHot record) {
        return weiboHotDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<WeiboHot> selectAll() {
        return weiboHotDao.selectAll();
    }

    @Override
    public int updateByPrimaryKey(WeiboHot record) {
        return weiboHotDao.updateByPrimaryKey(record);
    }
}
