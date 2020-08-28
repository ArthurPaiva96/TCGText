package com.arthurpaiva96.tcgtext;

import android.app.Application;

import com.arthurpaiva96.tcgtext.ui.UtilTCGText;

public class TCGTextApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        UtilTCGText.downloadEnglishToPortugueseText(this);
    }
}
