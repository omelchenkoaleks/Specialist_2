package com.omelchenkoaleks.mylabservicethread;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null && intent.hasExtra(MainActivity.EXTRA_TEXT)) {
            int number = intent.getIntExtra(MainActivity.EXTRA_TEXT, 0);
            Log.d("happy", "" + number);
            System.out.println(number);
        }

        return START_NOT_STICKY;
    }
}
