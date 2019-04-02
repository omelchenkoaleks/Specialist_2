package com.omelchenkoaleks.castomview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SinglePaneContainer extends FrameLayout implements PaneContainer {
    View listView;

    public SinglePaneContainer(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        listView = getChildAt(0);
    }

    @Override
    public void showItem(String item) {
        if (isListAttached()) {
            removeViewAt(0);
            View.inflate(getContext(), R.layout.detail, this);
        }
        DetailView detailView = (DetailView) getChildAt(0);
        detailView.showItem(item);
    }

    // обрабатываем кнопку back ...
    @Override
    public boolean onBackPressed() {
        if (isListAttached()) return false;

        removeViewAt(0);
        addView(listView);
        return true;
    }

    private boolean isListAttached() {
        return listView.getParent() != null;
    }
}
