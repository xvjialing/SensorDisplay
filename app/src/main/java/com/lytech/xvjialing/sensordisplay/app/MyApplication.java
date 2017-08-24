package com.lytech.xvjialing.sensordisplay.app;

import android.app.Application;
import android.util.DisplayMetrics;

import com.baidu.mapapi.SDKInitializer;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by xvjialing on 2017/8/24.
 */

public class MyApplication extends Application {

    public static int screenWidth = 0;

    public static int screenHeight = 0;

    @Override
    public void onCreate() {
        super.onCreate();
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        //注意该方法要再setContentView方法之前实现
        SDKInitializer.initialize(getApplicationContext());

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }

    /**
     * 获取屏幕尺寸
     */
    private void getScreenSize() {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        screenHeight = dm.heightPixels;
        screenWidth = dm.widthPixels;
    }
}
