package com.omelchenkoaleks.castomview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ItemListView extends ListView {
    ItemListAdapter mItemListAdapter;

    public ItemListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        mItemListAdapter = new ItemListAdapter(getContext());
        setAdapter(mItemListAdapter);

        setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = mItemListAdapter.getItem(position);
                /*
                какждое вью может получить контекст, активити тоже своего рода контектс -
                мы можем привести контектс к нашему активити и получить активити таким образом ...
                 */
                MainActivity activity = (MainActivity) getContext();
                PaneContainer container = activity.getDualPaneContainer();
                container.showItem(item);
            }
        });
    }
}
