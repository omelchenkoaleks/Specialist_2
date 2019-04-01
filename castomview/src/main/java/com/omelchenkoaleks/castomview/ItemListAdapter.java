package com.omelchenkoaleks.castomview;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

public class ItemListAdapter extends ArrayAdapter<String> {
    // данные для работы (хард-код)
    static final String[] values = new String[]{"Android", "iPhone", "WindowsMobile",
            "Blackberry", "WebOS", "Ubuntu", "Windows7", "Windows8", "Linux", "Windows10",
            "iPhone10", "AndroidX", "AndroidQ", "Web",};

    public ItemListAdapter(@NonNull Context context) {
        super(context, android.R.layout.simple_list_item_1, values);
    }
}
