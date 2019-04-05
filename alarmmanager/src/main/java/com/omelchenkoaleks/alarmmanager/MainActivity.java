package com.omelchenkoaleks.alarmmanager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.concurrent.TimeUnit;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    AlarmManager mAlarmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        // ТЕПЕРЬ делаем так, чтобы сервис запустился через какое-то нужное нам время ...
        mAlarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent = EventService.getStartIntent(this, 125);
        PendingIntent pendingIntent = PendingIntent.getService(
                this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        long targetTime = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(15);
        mAlarmManager.set(AlarmManager.RTC, targetTime, pendingIntent);
    }
}
