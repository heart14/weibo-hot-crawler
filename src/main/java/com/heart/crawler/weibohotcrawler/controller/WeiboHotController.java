package com.heart.crawler.weibohotcrawler.controller;

import com.heart.crawler.weibohotcrawler.entity.WeiboHot;
import com.heart.crawler.weibohotcrawler.service.WeiboHotService;
import com.heart.crawler.weibohotcrawler.util.WeiboCrawlerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/weibo")
@Controller
public class WeiboHotController {

    private Logger logger = LoggerFactory.getLogger(WeiboHotController.class);

    @Autowired
    private WeiboHotService weiboHotService;

    @RequestMapping("/index")
    public ModelAndView indexPage() {
        return new ModelAndView("weibohot");
    }

    @RequestMapping("/hot")
    @ResponseBody
    public List<WeiboHot> getWeiboHot() {
        List<WeiboHot> weiboHots = WeiboCrawlerUtil.weiboHotCrawler();
        if (weiboHots == null) {
            System.out.println("空空如也！");
            return null;
        }
        return weiboHots;
    }

}
