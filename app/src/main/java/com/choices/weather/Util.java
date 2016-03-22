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

    public static int getDrawable(String code) {
        switch (code) {
            case "100":
                return R.drawable.ic_1_sunny;
            case "101":
            case "102":
            case "103":
                return R.drawable.ic_1_cloudy;
            case "104":
                return R.drawable.ic_1_overcast;
            case "300":
            case "305":
            case "309":
                return R.drawable.ic_1_drizzle;
            case "301":
            case "306":
            case "310":
                return R.drawable.ic_1_moderate_rain;
            case "302":
            case "307":
            case "308":
            case "311":
            case "312":
            case "313":
                return R.drawable.ic_1_downpour;
            case "303":
                return R.drawable.ic_1_thunder_shower;
            case "304":
                return R.drawable.ic_1_hailstone;
            case "400":
            case "407":
                return R.drawable.ic_1_light_snow;
            case "401":
                return R.drawable.ic_1_moderate_snow;
            case "402":
            case "403":
                return R.drawable.ic_1_heavy_snow;
            case "404":
            case "405":
            case "406":
                return R.drawable.ic_1_sleet;
            case "500":
            case "501":
                return R.drawable.ic_1_fog;
            case "502":
                return R.drawable.ic_1_haze;
            case "503":
            case "504":
            case "506":
            case "507":
            case "508":
                return R.drawable.ic_1_duststorm;
            default:
                return R.drawable.main_large_weather_99;
        }
    }
}
