package com.omelchenkoaleks.alarmmanager;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

public class EventService extends IntentService {
    public static final String NUM_E = "num";

    public static Intent getStartIntent(Context context, int num) {
        Intent intent = new Intent(context, EventService.class);
        intent.putExtra(NUM_E, num);
        return intent;
    }

    public EventService() {
        super("EventService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d("happy", "onHandleIntent " + intent.getIntExtra(NUM_E, -1));
    }
}
