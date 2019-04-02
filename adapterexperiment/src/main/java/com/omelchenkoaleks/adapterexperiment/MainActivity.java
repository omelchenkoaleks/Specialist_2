package com.omelchenkoaleks.adapterexperiment;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import static com.omelchenkoaleks.adapterexperiment.Data.data;

public class MainActivity extends AppCompatActivity {
    ListView mListView;
    MyListAdapter mListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = findViewById(R.id.list_lv);

        // создаем адаптер ...
        mListAdapter = new MyListAdapter();
        mListAdapter.setData(data);
        // передаем адаптер внутрь списка ...
        mListView.setAdapter(mListAdapter);
    }
}
