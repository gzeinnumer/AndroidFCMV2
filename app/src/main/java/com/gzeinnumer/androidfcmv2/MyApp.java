package com.gzeinnumer.androidfcmv2;

import android.app.Application;

import com.google.firebase.FirebaseApp;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //Initial Firebase disini
        FirebaseApp.initializeApp(this);
    }
}
