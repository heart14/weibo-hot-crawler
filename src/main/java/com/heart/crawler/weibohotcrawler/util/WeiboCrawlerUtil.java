package com.heart.crawler.weibohotcrawler.util;

import com.heart.crawler.weibohotcrawler.entity.WeiboHot;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WeiboCrawlerUtil {

    /**
     * 获取指定URL页面内容 weibo
     *
     * @return
     */
    public static List<WeiboHot> weiboHotCrawler() {

        try {
            // 通过jsoup将对应url转为document
            Document doc = Jsoup.parse(new URL("https://s.weibo.com/top/summary?Refer=top_hot&topnav=1&wvr=6"), 10000);
            Elements trs = doc.getElementsByTag("tr");
            Date currentTime = new Date();
            List<WeiboHot> weiboHotList = new ArrayList<>();
            for (Element tr : trs) {
                if ("thead_tr".equals(tr.attr("class"))) {
                    continue;
                }
                Elements td01 = tr.getElementsByClass("td-01");
                String td01Text = "".equals(td01.text()) ? "0" : td01.text();

                Elements a = tr.getElementsByTag("a");
                String td02Href = a.attr("href");
                String td02Text = a.text();

                Elements span = tr.getElementsByTag("span");
                String td02SpanText = span.text();

                Elements td03 = tr.getElementsByClass("td-03");
                String td03Text = td03.text();

                if ("荐".equals(td03Text)) {
                    td02Href = a.attr("href_to");
                }
                if ("0".equals(td01Text)) {
                    td03Text = "社会主义好！";
                }

                WeiboHot WeiboHot = new WeiboHot().setRank(td01Text)
                        .setTitle(td02Text).setLinkUrl(td02Href).setHotNum(td02SpanText)
                        .setChannel(td03Text).setCrawlerDate(currentTime);
                weiboHotList.add(WeiboHot);
            }
            return weiboHotList;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
