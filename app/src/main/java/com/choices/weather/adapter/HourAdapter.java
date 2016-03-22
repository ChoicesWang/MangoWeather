package com.choices.weather.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.choices.weather.R;
import com.choices.weather.Util;
import com.choices.weather.bean.HourWeather;
import com.choices.weather.bean.Weather;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Choices on 2016/3/22.
 * email: zezeviyao@163.com
 */
public class HourAdapter extends RecyclerView.Adapter<HourAdapter.HourHolder> {

    private Weather mWeather;

    private ArrayList<HourWeather> hws;

    public HourAdapter(Weather mWeather) {
        this.mWeather = mWeather;

        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

        hws = new ArrayList<>(24);
        for (int i = 0; i < 24; i++) {
            HourWeather hourWeather = new HourWeather();
            if (i == 0) {
                hourWeather.hour = "现在";
            } else {
                int h24 = (hour + i) % 24;
                hourWeather.hour = h24 + "时";
            }

            if (hour + i <= 24) {
                hourWeather.temp = mWeather.now.tmp;
                hourWeather.image = Util.getDrawable(mWeather.dailyForecast.get(0).cond.codeD);
            } else {
                hourWeather.temp = mWeather.dailyForecast.get(1).tmp.max;
                hourWeather.image = Util.getDrawable(mWeather.dailyForecast.get(1).cond.codeD);
            }
            hws.add(hourWeather);
        }

    }

    @Override
    public HourHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater factory = LayoutInflater.from(parent.getContext());
        View root = factory.inflate(R.layout.hour_temp_item, parent, false);
        return new HourHolder(root);
    }

    @Override
    public void onBindViewHolder(HourHolder holder, int position) {
        HourWeather hw = hws.get(position);
        holder.time.setText(hw.hour);
        holder.temp.setText(hw.temp);
        holder.image.setImageResource(hw.image);
    }

    @Override
    public int getItemCount() {
        return hws != null ? hws.size() : 0;
    }


    public static class HourHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.time)
        public TextView time;
        @Bind(R.id.weather_image)
        public ImageView image;
        @Bind(R.id.weather_temp)
        public TextView temp;

        public HourHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
