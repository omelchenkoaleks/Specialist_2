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

        /*
        так мы получаем ссылку на нужного наследника, который находится во вьюгрупп FrameLayout -
        он под индексом 0 - в нашем случае вернется наш список (ItemListView) ...

        конечно: можно было найти элемент и с помощью findViewById - как привычно ))) ...
         */
        listView = getChildAt(0);
    }

    @Override
    public void showItem(String item) {
        removeViewAt(0);
        View.inflate(getContext(), R.layout.detail, this);
        DetailView detailView = (DetailView) getChildAt(0);
        detailView.showItem(item);
    }
}
