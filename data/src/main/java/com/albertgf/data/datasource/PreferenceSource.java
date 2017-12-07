package com.albertgf.data.datasource;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by albertgf on 4/11/17.
 */

public class PreferenceSource {

    private Context mContext;
    private SharedPreferences.Editor mEditor;

    private PreferenceSource(Context context) {
        mContext = context;
        mEditor = getEditor();
    }

    private SharedPreferences getPreferences() {
        return mContext.getSharedPreferences("com.albertgf.movieapp.sharedpreference", Context.MODE_PRIVATE);
    }

    private void saveInSharedPreferences(String key, String model) {
        mEditor.putString(key, model).commit();
    }

    private void saveInSharedPreferences(String key, boolean value) {
        mEditor.putBoolean(key, value).commit();
    }

    private void saveInSharedPreferences(String key, int value) {
        mEditor.putInt(key, value).commit();
    }

    private void saveInSharedPreferences(String key, double value) {
        mEditor.putFloat(key, (float) value).commit();
    }


    public static PreferenceSource getInstance(Context context) {
        return new PreferenceSource(context);
    }

    private SharedPreferences.Editor getEditor() {
        return getPreferences().edit();
    }
}
