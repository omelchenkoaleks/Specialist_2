package com.omelchenkoaleks.specialist_2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyCoolService extends Service {
    private static final String TAG = "MyCoolService";
    public static final String EXTRA_DATA_SERVICE = "data service";

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

        if (intent != null && intent.hasExtra(EXTRA_DATA_SERVICE)) {
            String data = intent.getStringExtra(MyCoolService.EXTRA_DATA_SERVICE);
            Log.d(TAG, "data: " + data);
        }

        stopSelf(startId);

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
