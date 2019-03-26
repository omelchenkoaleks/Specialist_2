package com.omelchenkoaleks.specialist_2;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import java.util.concurrent.RunnableFuture;

import androidx.annotation.Nullable;

public class MyCoolService extends Service {
    private static final String TAG = "MyCoolService";
    public static final String EXTRA_DATA_SERVICE = "data service";
    private int mCounter = 0;
    private Handler mHandler;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreateService");

        mHandler = new Handler();

        doSomething();
    }

    /**
     * Полезный патерн, если нужно что-то делать в заданом промежутке ...
     * Например, показать время через четкие интервалы ...
     */
    private void doSomething() {
        Log.d(TAG, "doSomething");

        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "my runnable");
            }
        };

        mHandler.postDelayed(myRunnable, 2000);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mCounter++;

        if (intent != null && intent.hasExtra(EXTRA_DATA_SERVICE)) {
            String data = intent.getStringExtra(MyCoolService.EXTRA_DATA_SERVICE);
            Log.d(TAG, "data: " + mCounter + " " + data);
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
