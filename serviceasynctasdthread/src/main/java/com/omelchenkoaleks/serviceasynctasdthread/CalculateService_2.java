package com.omelchenkoaleks.serviceasynctasdthread;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

public class CalculateService_2 extends IntentService {
    public static final String EXTRA_SEND_NUMBER_SERVICE_2 = "send number";
    public static final String EXTRA_SEND_SQUARE_SERVICE_ACTION = "com.cool.intent.square.action";

    public static Intent getIntent(Context context, int num) {
        Intent intent = new Intent(context, CalculateService_2.class);
        intent.putExtra(EXTRA_SEND_NUMBER_SERVICE_2, num);
        return intent;
    }

    public CalculateService_2() {
        super("CalculateService_2");
    }

    /*
    этот сервис запускается, обрабатывает интент, а дальше, если есть еще интент на обработку, то
    и его тоже обрабатывает (по очереди), если нет - он себя завершает ...
     */
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
                int square = num * num;
                Log.d("happy", "square " + square);

                // ОТПРАВКА: передаем данные из сервиса ...
                Intent broadcast = new Intent();
                broadcast.setAction(EXTRA_SEND_SQUARE_SERVICE_ACTION);
                broadcast.putExtra(EXTRA_SEND_NUMBER_SERVICE_2, square);
                // передаем этот интент операционной системе, которая может найти его получателя ...
                sendBroadcast(broadcast);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
