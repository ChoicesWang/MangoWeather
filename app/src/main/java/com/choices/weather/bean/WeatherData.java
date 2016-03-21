package com.choices.weather.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Choices on 2016/3/21.
 * email: zezeviyao@163.com
 */
public class WeatherData {

    //@Expose 该实例不会被序列化

    @SerializedName("HeWeather data service 3.0")
    @Expose
    public List<Weather> mHeWeatherDataService = new ArrayList<>();
}
