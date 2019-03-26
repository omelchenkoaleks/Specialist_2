package com.omelchenkoaleks.specialist_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowTextActivity extends AppCompatActivity {
    private TextView mShowText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_text);

        mShowText = findViewById(R.id.show_text_tv);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(MainActivity.EXTRA_SEND_TEXT)) {
            String data = intent.getStringExtra(MainActivity.EXTRA_SEND_TEXT);
            mShowText.setText(data);
        }
    }
}
