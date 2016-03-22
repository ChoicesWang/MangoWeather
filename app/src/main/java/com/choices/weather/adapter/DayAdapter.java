package com.choices.weather.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.choices.weather.R;
import com.choices.weather.bean.Weather;
import com.choices.weather.holder.BaseViewHolder;
import com.choices.weather.holder.DayHolder;
import com.choices.weather.holder.DescHolder;
import com.choices.weather.holder.InfoHolder;

/**
 * Created by Choices on 2016/3/21.
 * email: zezeviyao@163.com
 */
public class DayAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private static final int TYPE_DAY = 0;
    private static final int TYPE_DESC = 1;
    private static final int TYPE_INFO = 2;

    private Weather weather;

    public DayAdapter(Weather weather) {
        this.weather = weather;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater factory = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case TYPE_DAY:
                return new DayHolder(factory.inflate(R.layout.day_temp_item, parent, false));
            case TYPE_DESC:
                return new DescHolder(factory.inflate(R.layout.desc_temp_item, parent, false));
            case TYPE_INFO:
                return new InfoHolder(factory.inflate(R.layout.info_temp_item, parent, false));
            default:
                throw new IllegalArgumentException("DayAdapter view type is error  tyep = " + viewType);
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (holder instanceof DayHolder) {
            DayHolder dayHolder = (DayHolder) holder;
            dayHolder.onBind(weather.dailyForecast.get(position));
        } else if (holder instanceof DescHolder) {
            DescHolder descHolder = (DescHolder) holder;
            descHolder.onBind(weather);
        } else if (holder instanceof InfoHolder) {
            InfoHolder infoHolder = (InfoHolder) holder;
            infoHolder.onBind(weather);
        }
    }

    @Override
    public int getItemCount() {
        if (weather == null) return 0;
        return weather.dailyForecast.size() + 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount() - 1) {
            return TYPE_INFO;
        } else if (position == getItemCount() - 2) {
            return TYPE_DESC;
        } else {
            return TYPE_DAY;
        }
    }

}
