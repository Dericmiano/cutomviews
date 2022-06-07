package com.example.mycoursewithfragments.utils;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Display;

public class SCreenUtility {
    private Activity activity;
    private float dpWidth;
    private float dpHeight;

    public SCreenUtility(Activity activity) {
        this.activity = activity;

        Display display = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);
        float density = activity.getResources().getDisplayMetrics().density;

        dpHeight = outMetrics.heightPixels / density;
        dpWidth = outMetrics.widthPixels / density;



    }

    public float getDpHeight() {
        return dpHeight;
    }

    public float getDpWidth() {
        return dpWidth;
    }
}
