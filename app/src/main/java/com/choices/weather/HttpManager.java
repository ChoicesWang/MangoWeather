package com.choices.weather;

import com.choices.weather.bean.WeatherData;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
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

    public static HttpManager getInstance() {
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
                .addInterceptor(interceptor)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(HeFengApi.class);
    }

    public void getWeather(Subscriber<WeatherData> subscriber, String city) {
        api.getWeatherData(city, MY_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

}
