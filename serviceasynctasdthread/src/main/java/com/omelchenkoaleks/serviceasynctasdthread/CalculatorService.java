package com.omelchenkoaleks.serviceasynctasdthread;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class CalculatorService extends Service {
    public static final String EXTRA_SEND_NUMBER = "number";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public static Intent getIntent(Context context, int num) {
        Intent intent = new Intent(context, CalculatorService.class);
        intent.putExtra(EXTRA_SEND_NUMBER, num);
        return intent;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null && intent.hasExtra(EXTRA_SEND_NUMBER)) {
            int number = intent.getIntExtra(EXTRA_SEND_NUMBER, 0);
            System.out.println(number);
            CalculateTask calculateTask = new CalculateTask(number);
            calculateTask.execute();
        }

        /*
            флаг передается операционной системе, чтобы она знала как запускать сервис снова,
            в случае, если его нужно будет исключить из памяти ... этот флаг означает,
            что в этом случае сервис не нужно запускать заново ...
         */
        return START_NOT_STICKY;
    }
}
