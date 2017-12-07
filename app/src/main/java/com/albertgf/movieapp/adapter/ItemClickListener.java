package com.albertgf.movieapp.adapter;

import android.support.annotation.NonNull;
import android.view.View;

/**
 * Created by albertgf on 5/11/17.
 */

public interface ItemClickListener<T> {
    void onItemClick(@NonNull T item, @NonNull DefaultViewHolder<T> viewHolder, @NonNull View view);
}