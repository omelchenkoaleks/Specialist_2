package com.omelchenkoaleks.specialist_2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyCoolService extends Service {
    private static final String TAG = "MyCoolService";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreateService");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommandService");

        if (intent != null && intent.hasExtra(MainActivity.EXTRA_SEND_TEXT)) {
            String data = intent.getStringExtra(MainActivity.EXTRA_SEND_TEXT);
            Log.d(TAG, "data: " + data);
        }

        return START_STICKY;
//        return START_NOT_STICKY;
//        return START_REDELIVER_INTENT;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroyService");
    }
}
