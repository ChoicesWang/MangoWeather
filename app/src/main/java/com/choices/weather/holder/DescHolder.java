package com.choices.weather.holder;

import android.view.View;
import android.widget.TextView;

import com.choices.weather.R;
import com.choices.weather.bean.Weather;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Choices on 2016/3/21.
 * email: zezeviyao@163.com
 */
public class DescHolder extends BaseViewHolder<Weather> {

    @Bind(R.id.desc_temp)
    TextView descTemp;

    public DescHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void onBind(Weather weather) {
        String desc = "今天" + weather.suggestion.comf.txt
                + "最近几天" + weather.suggestion.flu.txt;
        descTemp.setText(desc);
    }
}
