package com.stevenbenack.todoit.Utils;

import android.app.Application;

import net.danlew.android.joda.JodaTimeAndroid;

public class todoit extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        JodaTimeAndroid.init(this);
    }
}
