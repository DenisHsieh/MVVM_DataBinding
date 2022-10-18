package com.example.mvvmarchitectureapp.model;

import android.os.Handler;

public class DataModel {
    public void retrieveData(final onDataReadyCallback callback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                callback.onDataReady("New Data");
            }
        }, 1500);
    }

    public interface onDataReadyCallback {
        void onDataReady(String data);
    }
}
