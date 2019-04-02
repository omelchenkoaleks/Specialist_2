package com.omelchenkoaleks.castomview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class DualPaneContainer extends LinearLayout implements PaneContainer {
    DetailView mDetailView;

    public DualPaneContainer(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        mDetailView = findViewById(R.id.detail_dv);
        mDetailView.showItem("воточки жжж ююю ...");
    }

    @Override
    public void showItem(String item) {
        mDetailView.showItem(item);
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }
}
