package com.albertgf.movieapp.adapter;

/**
 * Created by albertgf on 5/11/17.
 */

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public abstract class DefaultViewHolder<R> extends RecyclerView.ViewHolder {


    public DefaultViewHolder(View itemView) {
        super(itemView);
    }

    public DefaultViewHolder(@NonNull Context context, @LayoutRes int layoutRes,
                             @NonNull ViewGroup parent) {
        super(LayoutInflater.from(context).inflate(layoutRes, parent, false));
    }

    public abstract void bindData(@NonNull R data);

    public boolean isClickable() {
        return true;
    }
}
