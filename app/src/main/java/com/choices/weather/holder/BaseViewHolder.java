package com.choices.weather.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Choices on 2016/3/21.
 * email: zezeviyao@163.com
 */
public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void onBind(T object);
}
