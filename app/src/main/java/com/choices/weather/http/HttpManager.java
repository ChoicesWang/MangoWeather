package com.choices.weather.http;

import com.choices.weather.BuildConfig;
import com.choices.weather.bean.Weather;
import com.choices.weather.bean.WeatherData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


/**
 * Created by Choices on 2016/3/21.
 * email: zezeviyao@163.com
 */
public class HttpManager {

    private static final String BASE_URL = "https://api.heweather.com/x3/";
    private static final String MY_KEY = "1378239410394cf7a03a2afdede02571";

    private static HttpManager mInstance;
    private static final Object mLock = new Object();

    private HeFengApi api;

    public static HttpManager ins() {
        synchronized (mLock) {
            if (mInstance == null) {
                mInstance = new HttpManager();
            }
            return mInstance;
        }
    }

    public HttpManager() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(BuildConfig.DEBUG ? interceptor : null)
                .build();
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        api = retrofit.create(HeFengApi.class);
    }

    public void getWeather(Subscriber<Weather> subscriber, String city) {
        api.getWeatherData(city, MY_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(new Func1<WeatherData, Boolean>() {
                    @Override
                    public Boolean call(WeatherData weatherData) {
                        return weatherData.mHeWeatherDataService.get(0).status.equals("ok");
                    }
                })
                .map(new Func1<WeatherData, Weather>() {
                    @Override
                    public Weather call(WeatherData weatherData) {
                        return weatherData.mHeWeatherDataService.get(0);
                    }
                })
                .subscribe(subscriber);
    }

}
