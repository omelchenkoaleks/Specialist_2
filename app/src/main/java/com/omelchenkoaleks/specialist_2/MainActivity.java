package com.omelchenkoaleks.specialist_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_SEND_TEXT = "send text";
    EditText mEnterText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEnterText = findViewById(R.id.enter_text_et);
    }

    public void onClickSendText(View view) {
        String receiveText = mEnterText.getText().toString().trim();
        if (mEnterText.length() > 0) {
            Intent intent = new Intent(this, ShowTextActivity.class);
            intent.putExtra(EXTRA_SEND_TEXT, receiveText);
            startActivity(intent);
        }
        mEnterText.setText(null);
    }
}
