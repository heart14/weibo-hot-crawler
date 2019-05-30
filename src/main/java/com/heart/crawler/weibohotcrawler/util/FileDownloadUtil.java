package com.heart.crawler.weibohotcrawler.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class FileDownloadUtil {

    public static void batchDownload(List<String> list) {
        System.out.println("开始下载");
        for (String url : list) {
            File photo = new File("C:/Users/jayhe/Pictures/" + url.substring(29, url.indexOf("?")) + ".jpg");
            if (photo.exists()) {
                continue;
            }
            BufferedOutputStream bufferedOutputStream = null;
            try {
                HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setConnectTimeout(5 * 1000);
                connection.setReadTimeout(5 * 1000);
                int responseCode = connection.getResponseCode();
                if (responseCode != 200) {
                    System.out.println("ERROR");
                    continue;
                }
                InputStream inputStream = connection.getInputStream();
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(photo));
                int count;
                byte[] bytes = new byte[2048];
                while ((count = inputStream.read(bytes)) != -1) {
                    bufferedOutputStream.write(bytes, 0, count);
                }
                bufferedOutputStream.flush();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println("下载完毕");

    }
}
