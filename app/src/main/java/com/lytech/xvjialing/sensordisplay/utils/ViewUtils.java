package com.lytech.xvjialing.sensordisplay.utils;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by xvjialing on 2017/8/23.
 */

public class ViewUtils {

    /**
     * 设置控件大小
     * @param view  控件
     * @param width 宽度，单位：像素
     * @param height 高度，单位：像素
     */
    public static void setViewSize(View view, int width, int height){
        ViewGroup.LayoutParams params = view.getLayoutParams();

        params.width = width;
        params.height = height;
        view.setLayoutParams(params);
    }

    /**
     * 设置控件宽度
     * @param view  控件
     * @param width 宽度 单位：像素
     */
    public  static void setViewWidth(View view,int width){
        ViewGroup.LayoutParams params=view.getLayoutParams();
        params.width=width;
        view.setLayoutParams(params);
    }
}
