package com.choices.weather;

import com.choices.weather.bean.WeatherData;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Choices on 2016/3/21.
 * email: zezeviyao@163.com
 */
public interface HeFengApi {

    @GET("weather")
    Observable<WeatherData> getWeatherData(@Query("city") String city, @Query("key") String key);
}
