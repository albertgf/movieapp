package com.albertgf.movieapp.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.albertgf.domain.model.MovieModelView;
import com.albertgf.movieapp.view.DetailItemView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by albertgf on 10/12/17.
 */

public class SimilarPagerAdapter extends PagerAdapter {
    private Context context;
    private List<MovieModelView> movies = new ArrayList<>();

    public SimilarPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        DetailItemView view = new DetailItemView(context);

        view.bindData(movies.get(position));

        collection.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return movies.get(position).getTitle();
    }

    public void addItem(MovieModelView movie) {
        movies.add(movie);
    }


}
