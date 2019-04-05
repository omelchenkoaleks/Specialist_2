package com.omelchenkoaleks.serviceasynctasdthread;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

public class CalculateService_2 extends IntentService {
    private static final String EXTRA_SEND_NUMBER_SERVICE_2 = "send number";

    public static Intent getIntent(Context context, int num) {
        Intent intent = new Intent(context, CalculateService_2.class);
        intent.putExtra(EXTRA_SEND_NUMBER_SERVICE_2, num);
        return intent;
    }

    public CalculateService_2() {
        super("CalculateService_2");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d("happy", "CalculateService_2.onHandleIntent "
                + Thread.currentThread().getName()
                + " "
                + Thread.currentThread().getId());

        try {
            Thread.sleep(10000);
            if (intent != null && intent.hasExtra(EXTRA_SEND_NUMBER_SERVICE_2)) {
                int num = intent.getIntExtra(EXTRA_SEND_NUMBER_SERVICE_2, 0);
                Log.d("happy", "square " + (num * num));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
