package com.omelchenkoaleks.castomview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class DetailView extends LinearLayout implements PaneContainer {
    TextView itemView;

    public DetailView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        itemView = findViewById(R.id.info_tv);
    }

    @Override
    public void showItem(String item) {
        itemView.setText(item);
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }
}
