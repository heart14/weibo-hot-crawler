package com.heart.crawler.weibohotcrawler.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class StringUtil {

    private static String LONG_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static String SHORT_PATTERN = "yyyy-MM-dd";

    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    public static String formatDatetoLongString(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(LONG_PATTERN);
        return simpleDateFormat.format(date);
    }

    public static String formatDatetoShortString(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SHORT_PATTERN);
        return simpleDateFormat.format(date);
    }

}
