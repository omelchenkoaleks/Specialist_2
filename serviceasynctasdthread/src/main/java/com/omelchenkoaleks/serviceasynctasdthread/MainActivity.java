package com.omelchenkoaleks.serviceasynctasdthread;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText mNumberText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNumberText = findViewById(R.id.number_et);


        Button sendTextButton = findViewById(R.id.button_bt);
        sendTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendCommand();
            }
        });
    }

    private void sendCommand() {
        try {
            int number = Integer.valueOf(mNumberText.getText().toString());
            Intent intent = CalculatorService.getIntent(this, number);
            startService(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
