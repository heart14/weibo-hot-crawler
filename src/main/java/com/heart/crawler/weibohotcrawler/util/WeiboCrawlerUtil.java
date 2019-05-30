package com.heart.crawler.weibohotcrawler.util;

import com.heart.crawler.weibohotcrawler.entity.BingWallpaper;
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

    public static List<BingWallpaper> bingWallpaperCrawler(int pageNum) {

        try {
            Date download_date = new Date();
            List<BingWallpaper> bingWallpapers = new ArrayList<>();
            for (int i = 1; i <= pageNum; i++) {
                String url = "https://bing.ioliu.cn/?p=" + pageNum;
                if (i == 1) {
                    url = "https://bing.ioliu.cn/";
                }
                Document doc = Jsoup.parse(new URL(url), 10000);
                Elements item = doc.getElementsByClass("item");
                for (Element element : item) {
                    //访问地址
                    Elements mark = element.getElementsByClass("mark");
                    String image_url = mark.attr("href");
                    //下载地址

                    //标题
                    Elements h3 = element.getElementsByTag("h3");
                    String title = h3.text();
                    //位置
                    Elements location = element.getElementsByClass("location");
                    String imglocation = location.text();
                    //发布日期
                    Elements calendar = element.getElementsByClass("calendar");
                    String release_date = calendar.text();
                    //下载日期

                    BingWallpaper bingWallpaper = new BingWallpaper();
                    bingWallpaper.setTitle(title);
                    bingWallpaper.setLocation(imglocation);
                    bingWallpaper.setImageUrl("https://bing.ioliu.cn" + image_url);
                    bingWallpaper.setDownloadUrl("https://bing.ioliu.cn" + image_url.replace("=home_5", "=download"));
                    bingWallpaper.setReleaseDate(release_date);
                    bingWallpaper.setCreateDate(download_date);

                    bingWallpapers.add(bingWallpaper);
                }
            }
            return bingWallpapers;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
