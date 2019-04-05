package com.omelchenkoaleks.alarmmanager;

import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

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

    // все, что в этом методе происходит в (background thread) фоновом потоке ...
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        int num = intent.getIntExtra(NUM_E, -1);
        Log.d("happy", "onHandleIntent " + num);

        Intent uaIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                this, 2, uaIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        // используем для пробуждения - уведомление ...
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(android.R.drawable.ic_dialog_alert)
                        .setContentTitle("heloo")
                        .setContentText("got " + num)
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true); // флажок означает, что при нажатии на уведомление - оно исчезнет ...

        NotificationManagerCompat.from(this).notify(1, builder.build());
    }
}
