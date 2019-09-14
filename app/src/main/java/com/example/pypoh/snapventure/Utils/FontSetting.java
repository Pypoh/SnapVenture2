package com.example.pypoh.snapventure.Utils;

import android.app.Application;
import android.graphics.Typeface;


public class FontSetting extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FontsOverride.setDefaultFont(this, "DEFAULT", "fonts/segoeui.ttf");
        FontsOverride.setDefaultFont(this, "MONOSPACE", "fonts/segoeui.ttf");
        FontsOverride.setDefaultFont(this, "SERIF", "fonts/segoeui.ttf");
        FontsOverride.setDefaultFont(this, "SANS_SERIF", "fonts/segoeui.ttf");
    }
}
