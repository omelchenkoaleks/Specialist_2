package com.omelchenkoaleks.specialist_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_SEND_TEXT = "send text";
    private EditText mEnterText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEnterText = findViewById(R.id.enter_text_et);
        Button sendTextButton = findViewById(R.id.send_text_bt);

        sendTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClick();
            }
        });
    }

    private void doClick() {
        String sendText = mEnterText.getText().toString().trim();
        if (sendText.length() > 0) {
            Intent intent = new Intent(this, ShowTextActivity.class);
            intent.putExtra(EXTRA_SEND_TEXT, sendText);
            startActivity(intent);
        }
        mEnterText.setText(null);
    }
}
