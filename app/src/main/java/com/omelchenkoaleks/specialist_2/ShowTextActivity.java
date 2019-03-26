package com.omelchenkoaleks.specialist_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowTextActivity extends AppCompatActivity {
    TextView mShowText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_text);

        mShowText = findViewById(R.id.show_text_tv);

        Intent intent = getIntent();
        String getText = intent.getStringExtra(MainActivity.EXTRA_SEND_TEXT);
        mShowText.setText(getText);
    }
}
