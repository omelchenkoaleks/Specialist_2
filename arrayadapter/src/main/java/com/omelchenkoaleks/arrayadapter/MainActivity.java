package com.omelchenkoaleks.arrayadapter;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private Button mButton;

    static final String[] sData = new String[] { "one", "two", "three",};

    private ListAdapter mArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = findViewById(R.id.list_lv);
        mButton = findViewById(R.id.button_bt);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doButton();
            }
        });

        mArrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                sData
        );

        mListView.setAdapter(mArrayAdapter);
    }

    private void doButton() {
        // TODO:
    }
}
