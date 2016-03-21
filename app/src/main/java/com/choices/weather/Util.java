package com.choices.weather;

import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Choices on 2016/3/21.
 * email: zezeviyao@163.com
 */
public class Util {
    private static final String TAG = "Util";

    public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) w = 0;
        return weekDays[w];
    }

    public static String getWeekOfDate(String dateStr) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.SIMPLIFIED_CHINESE);
        String week = "未知";
        try {
            week = getWeekOfDate(dateFormat.parse(dateStr));
        } catch (ParseException e) {
            if (BuildConfig.DEBUG) Log.e(TAG, "getWeekOfDate: " + e.getMessage());
        }
        return week;
    }
}
