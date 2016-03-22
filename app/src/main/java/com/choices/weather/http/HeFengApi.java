package com.choices.weather.http;

import com.choices.weather.bean.WeatherData;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Choices on 2016/3/21.
 * email: zezeviyao@163.com
 */
public interface HeFengApi {

    @GET("weather")
    @Headers("Cache-Control: max-age=10800")
    Observable<WeatherData> getWeatherData(@Query("city") String city, @Query("key") String key);
}
