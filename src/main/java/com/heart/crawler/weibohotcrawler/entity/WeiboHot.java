package com.heart.crawler.weibohotcrawler.entity;

import java.util.Date;

public class WeiboHot {

    /**
     * id
     */
    private Integer id;

    /**
     * 热搜排行
     */
    private String rank;

    /**
     * 搜索指数
     */
    private String hotNum;

    /**
     * 热搜关键词
     */
    private String title;

    /**
     * 热搜详情页地址
     */
    private String linkUrl;

    /**
     * 热搜分类 新 沸 热 爆 荐 等
     */
    private String channel;

    /**
     * 抓取时间
     */
    private Date crawlerDate;

    // get set

    public Integer getId() {
        return id;
    }

    public WeiboHot setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getRank() {
        return rank;
    }

    public WeiboHot setRank(String rank) {
        this.rank = rank;
        return this;
    }

    public String getHotNum() {
        return hotNum;
    }

    public WeiboHot setHotNum(String hotNum) {
        this.hotNum = hotNum;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public WeiboHot setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public WeiboHot setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
        return this;
    }

    public String getChannel() {
        return channel;
    }

    public WeiboHot setChannel(String channel) {
        this.channel = channel;
        return this;
    }

    public Date getCrawlerDate() {
        return crawlerDate;
    }

    public WeiboHot setCrawlerDate(Date crawlerDate) {
        this.crawlerDate = crawlerDate;
        return this;
    }

    @Override
    public String toString() {
        return "\nWeiboHot{" +
                "id=" + id +
                ", rank='" + rank + '\'' +
                ", hotNum='" + hotNum + '\'' +
                ", title='" + title + '\'' +
                ", linkUrl='" + linkUrl + '\'' +
                ", channel='" + channel + '\'' +
                ", crawlerDate='" + crawlerDate + '\'' +
                '}';
    }
}
