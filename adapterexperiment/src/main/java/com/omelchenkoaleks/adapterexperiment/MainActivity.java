package com.omelchenkoaleks.adapterexperiment;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ListView mListView;
    MyListAdapter mListAdapter;
    private String[] mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mData = Data.data;

        mListView = findViewById(R.id.list_lv);

        mListAdapter = new MyListAdapter();
        mListAdapter.setData(mData);

        mListView.setAdapter(mListAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String msg = "Clicked on " + position;

                String[] newData = new String[mData.length + 1];
                for (int i = 0; i < mData.length; i++) {
                    newData[i] = mData[i];
                }
                newData[newData.length - 1] = msg;

                mData = newData;
                mListAdapter.setData(mData);
            }
        });
    }
}
