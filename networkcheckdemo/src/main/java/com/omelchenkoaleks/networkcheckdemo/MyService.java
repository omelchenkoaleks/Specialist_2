package com.omelchenkoaleks.networkcheckdemo;

import android.app.Service;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;

import androidx.annotation.Nullable;

public class MyService extends Service {
    private ConnectivityManager mConnectivityManager;
    private PowerManager mPowerManager;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mConnectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        mPowerManager = (PowerManager) getSystemService(POWER_SERVICE);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (mConnectivityManager.getActiveNetworkInfo() != null &&
                mConnectivityManager.getActiveNetworkInfo().isConnected() &&
                (Build.VERSION.SDK_INT < Build.VERSION_CODES.P ||
                        !mPowerManager.isDeviceIdleMode() ||
                        mPowerManager.isIgnoringBatteryOptimizations(getPackageName()))) {
        }
        return START_STICKY;
    }
}
