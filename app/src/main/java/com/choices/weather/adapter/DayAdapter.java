package com.choices.weather.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.choices.weather.R;
import com.choices.weather.bean.Weather;
import com.choices.weather.holder.BaseViewHolder;
import com.choices.weather.holder.DayTempHolder;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Choices on 2016/3/21.
 * email: zezeviyao@163.com
 */
public class DayAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private ArrayList<Weather.DailyForecastEntity> data;

    public DayAdapter(ArrayList<Weather.DailyForecastEntity> data) {
        this.data = data;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater factory = LayoutInflater.from(parent.getContext());
        View root = factory.inflate(R.layout.day_temp_item, parent, false);
        return new DayTempHolder(root);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (holder instanceof DayTempHolder) {
            ((DayTempHolder) holder).onBind(data.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

}
