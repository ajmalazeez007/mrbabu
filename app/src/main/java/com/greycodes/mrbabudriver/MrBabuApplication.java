package com.greycodes.mrbabudriver;

import android.app.Application;
import android.graphics.Typeface;

/**
 * Created by ajmal on 9/7/15.
 */
public class MrBabuApplication extends Application {
    private static final String CANARO_EXTRA_BOLD_PATH = "fonts/canaro_extra_bold.otf";
    public static Typeface canaroExtraBold;
    @Override
    public void onCreate() {
        super.onCreate();
        initTypeface();
    }
    private void initTypeface() {
        canaroExtraBold = Typeface.createFromAsset(getAssets(), CANARO_EXTRA_BOLD_PATH);

    }
}
