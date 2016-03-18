package com.choices.weather.widget;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.choices.weather.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Choices on 2016/3/18.
 * email: zezeviyao@163.com
 */
public class HeaderLayout extends FrameLayout implements AppBarLayout.OnOffsetChangedListener {

    private static final String TAG = "HeaderLayout";

    @Bind(R.id.city)
    TextView city;
    @Bind(R.id.weather)
    TextView weather;
    @Bind(R.id.city_info)
    LinearLayout cityInfo;
    @Bind(R.id.temp)
    TextView temp;
    @Bind(R.id.week)
    TextView week;
    @Bind(R.id.high)
    TextView high;
    @Bind(R.id.low)
    TextView low;
    @Bind(R.id.high_low)
    LinearLayout highLow;

    public HeaderLayout(Context context) {
        this(context, null);
    }

    public HeaderLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HeaderLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        inflate(context, R.layout.header_layout, this);
        ButterKnife.bind(this, this);
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        int absOffset = Math.abs(verticalOffset);
        float alpha = 1 - 2.34f * absOffset / getHeight();

        int cityOffset = (int) (absOffset - absOffset * 0.15);
        int tempOffset = (int) (absOffset - absOffset * 0.32);

        cityInfo.setTranslationY(cityOffset);
        temp.setTranslationY(tempOffset);

        temp.setAlpha(alpha);
        week.setAlpha(alpha);
        highLow.setAlpha(alpha);
    }
}