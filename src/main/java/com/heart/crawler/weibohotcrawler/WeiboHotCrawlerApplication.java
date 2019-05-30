package com.heart.crawler.weibohotcrawler;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.heart.crawler.weibohotcrawler.dao")
public class WeiboHotCrawlerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeiboHotCrawlerApplication.class, args);
    }

}

