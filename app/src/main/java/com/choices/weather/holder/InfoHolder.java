package com.choices.weather.holder;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;

import com.choices.weather.R;
import com.choices.weather.bean.Weather;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Choices on 2016/3/22.
 * email: zezeviyao@163.com
 */
public class InfoHolder extends BaseViewHolder<Weather> {

    @Bind(R.id.sunup_time)
    TextView sunupTime;
    @Bind(R.id.sunset_time)
    TextView sunsetTime;
    @Bind(R.id.hum)
    TextView hum;
    @Bind(R.id.pop)
    TextView pop;
    @Bind(R.id.spd)
    TextView nowSpd;
    @Bind(R.id.now_fl)
    TextView nowFl;
    @Bind(R.id.pcpn)
    TextView pcpn;
    @Bind(R.id.pres)
    TextView pres;
    @Bind(R.id.vis)
    TextView vis;
    @Bind(R.id.uv_brf)
    TextView uvBrf;

    public InfoHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBind(Weather weather) {
        Weather.DailyForecastEntity wdf = weather.dailyForecast.get(0);
        if (wdf != null) {
            sunupTime.setText(wdf.astro.sr); //日出
            sunsetTime.setText(wdf.astro.ss);//日落
            hum.setText(wdf.hum + "%");//湿度
            pop.setText(wdf.pop + "%");//降雨概率
            pcpn.setText(wdf.pcpn + "厘米");// 降雨量
            pres.setText(wdf.pres + "百帕");// 气压
            vis.setText(wdf.vis + "公里");//能见度
        }
        Weather.NowEntity now = weather.now;
        if (now != null) {
            nowSpd.setText(now.wind.dir + " " + now.wind.sc);
            nowFl.setText(now.fl);
        }
        uvBrf.setText(weather.suggestion.uv.brf);
    }
}
