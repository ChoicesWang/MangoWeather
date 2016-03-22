package com.choices.weather.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.choices.weather.R;
import com.choices.weather.Util;
import com.choices.weather.bean.Weather;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Choices on 2016/3/21.
 * email: zezeviyao@163.com
 */
public class DayHolder extends BaseViewHolder<Weather.DailyForecastEntity> {

    @Bind(R.id.x_week)
    TextView xWeek;
    @Bind(R.id.x_image)
    ImageView xImage;
    @Bind(R.id.x_high)
    TextView xHigh;
    @Bind(R.id.x_low)
    TextView xLow;

    public DayHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void onBind(Weather.DailyForecastEntity day) {
        xWeek.setText(Util.getWeekOfDate(day.date));
        xHigh.setText(day.tmp.max);
        xLow.setText(day.tmp.min);
    }
}
