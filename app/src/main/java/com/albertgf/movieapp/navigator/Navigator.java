package com.albertgf.movieapp.navigator;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.view.View;

import com.albertgf.movieapp.activity.DetailActivity;

/**
 * Created by albertgf on 4/11/17.
 */

public class Navigator {
    public void navigateToDetail(Activity context, View view, String model) {
        if (context != null) {
            Intent intentToLaunch = DetailActivity.getCallingIntent(context, ViewCompat.getTransitionName(view),
                    model);
            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    context,
                    view,
                    ViewCompat.getTransitionName(view));

            context.startActivity(intentToLaunch, options.toBundle());
        }
    }
}
