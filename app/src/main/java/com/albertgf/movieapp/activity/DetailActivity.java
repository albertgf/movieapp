package com.albertgf.movieapp.activity;

import android.content.Context;
import android.content.Intent;

/**
 * Created by albertgf on 9/12/17.
 */

public class DetailActivity extends BaseActivity{

    public static Intent getCallingIntent(Context context, String model, String transitionName) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra("model", model);
        intent.putExtra("transition", transitionName);

        return intent;
    }
}
