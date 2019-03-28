package com.omelchenkoaleks.browserdemo;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class AirplaneModeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent != null && !intent.getBooleanExtra("state", false))
        Log.d("happy", "onReceive");

        Intent google = new Intent(Intent.ACTION_VIEW);
        Uri uri = Uri.parse("http://google.com");
        google.setData(uri);

        PendingIntent pendingIntent = PendingIntent.getActivity(
                context, 1, google, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentTitle("google")
                .setContentText("to Google: ...")
                .setSmallIcon(android.R.drawable.btn_radio)
                .setContentIntent(pendingIntent);

        NotificationManagerCompat.from(context).notify(1, builder.build());
    }
}
