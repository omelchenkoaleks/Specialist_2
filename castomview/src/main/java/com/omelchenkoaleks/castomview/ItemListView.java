package com.omelchenkoaleks.castomview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

public class ItemListView extends ListView {
    ItemListAdapter mItemListAdapter;

    public ItemListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        // context внутри View получается с помощью getContext() ...
        mItemListAdapter = new ItemListAdapter(getContext());
        setAdapter(mItemListAdapter);
    }
}
