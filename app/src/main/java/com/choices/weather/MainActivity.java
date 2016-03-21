package com.choices.weather;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.choices.weather.bean.Weather;
import com.choices.weather.widget.HeaderLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.appbar)
    AppBarLayout appbar;
    @Bind(R.id.header_layout)
    HeaderLayout headerLayout;
    @Bind(R.id.root)
    CoordinatorLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        appbar.addOnOffsetChangedListener(headerLayout);

        HttpManager.ins().getWeather(mSubscriber, "北京");
    }

    private Subscriber<Weather> mSubscriber = new Subscriber<Weather>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(Weather weatherData) {
            headerLayout.setWeatherData(weatherData);
            root.setBackgroundResource(R.color.weather_100);
        }
    };
}
