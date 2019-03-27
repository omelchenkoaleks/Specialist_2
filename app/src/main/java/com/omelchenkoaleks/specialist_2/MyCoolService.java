package com.omelchenkoaleks.specialist_2;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MyCoolService extends Service {
    private static final String TAG = "MyCoolService";
    public static final String EXTRA_DATA_SERVICE = "mData service";
    private int mCounter = 0;
    private Handler mHandler;
    private String mData;

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

    private void doSomething() {
        mCounter++;
        Log.d(TAG, "doSomething");

        showNotification();

        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                doSomething();
            }
        };

        mHandler.postDelayed(myRunnable, 5000);
    }

    private void showNotification() {
        Intent intent1 = new Intent(this, ShowTextActivity.class);
        intent1.putExtra(MainActivity.EXTRA_SEND_TEXT, "1: " + mData + " " + mCounter);
        PendingIntent pendingIntent1 = PendingIntent.getActivity(
                this, 1, intent1, PendingIntent.FLAG_UPDATE_CURRENT);

        Intent intent2 = new Intent(this, ShowTextActivity.class);
        intent2.putExtra(MainActivity.EXTRA_SEND_TEXT, "2: " + mData + " " + mCounter );
        PendingIntent pendingIntent2 = PendingIntent.getActivity(
                this, 2, intent2, PendingIntent.FLAG_UPDATE_CURRENT);

        Intent intent3 = new Intent(this, ShowTextActivity.class);
        intent3.putExtra(MainActivity.EXTRA_SEND_TEXT, "3: " + mData + " " + mCounter);
        PendingIntent pendingIntent3 = PendingIntent.getActivity(
                this, 3, intent3, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("Wow");
        builder.setContentText("" + mData + " " + mCounter);
        builder.setSmallIcon(android.R.drawable.stat_sys_warning);
        builder.setContentIntent(pendingIntent1);

        builder.addAction(android.R.drawable.sym_action_email, "Email", pendingIntent2);
        builder.addAction(android.R.drawable.sym_action_call, "Call", pendingIntent3);

        Notification notification = builder.build();
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(1, notification);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null && intent.hasExtra(EXTRA_DATA_SERVICE)) {
            mData = intent.getStringExtra(MyCoolService.EXTRA_DATA_SERVICE);
            Log.d(TAG, "mData: " + mCounter + " " + mData);
        }

        stopSelf(startId);

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroyService");
        mHandler.removeCallbacksAndMessages(null);
    }
}
