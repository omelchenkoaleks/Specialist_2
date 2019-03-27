package com.omelchenkoaleks.specialist_2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * задача этого компонента: быстро запуститься, что-то выполнить и завершиться ...
 */
public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent coolIntent = new Intent(context, MyCoolService.class);
        coolIntent.putExtra(MyCoolService.EXTRA_DATA_SERVICE, "from broadcast receiver");
        context.startService(coolIntent);
    }
}
