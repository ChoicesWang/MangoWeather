package com.choices.weather;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;

import com.choices.weather.adapter.DayAdapter;
import com.choices.weather.adapter.HourAdapter;
import com.choices.weather.bean.Weather;
import com.choices.weather.http.HttpManager;
import com.choices.weather.widget.HeaderLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.appbar)
    AppBarLayout appbar;
    @Bind(R.id.header_layout)
    HeaderLayout headerLayout;

    @Bind(R.id.hour_temp)
    RecyclerView hourRecyclerView;
    @Bind(R.id.day_temp)
    RecyclerView dayRecyclerView;

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

        HttpManager.ins(this.getApplication()).getWeather(mSubscriber, "北京");
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
            dayRecyclerView.setAdapter(new DayAdapter(weatherData));
            hourRecyclerView.setAdapter(new HourAdapter(weatherData));
        }
    };
}
