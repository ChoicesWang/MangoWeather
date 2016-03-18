package com.choices.weather;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;

import com.choices.weather.widget.HeaderLayout;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.appbar)
    AppBarLayout appbar;
    @Bind(R.id.header_layout)
    HeaderLayout headerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        appbar.addOnOffsetChangedListener(headerLayout);
    }
}
