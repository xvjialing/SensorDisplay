package com.lytech.xvjialing.sensordisplay.app;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by xvjialing on 2017/8/24.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }
}
