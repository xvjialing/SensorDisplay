package com.lytech.xvjialing.sensordisplay.utils;

import android.graphics.Paint;
import android.widget.TextView;

/**
 * Created by xvjialing on 2017/8/21.
 */

public class TextUtils {

    public static void drawUnderLine(TextView textView){
        textView.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG ); //下划线
        textView.getPaint().setAntiAlias(true);//抗锯齿
    }
}
