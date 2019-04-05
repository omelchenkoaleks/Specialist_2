package com.omelchenkoaleks.serviceasynctasdthread;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText mNumberText;

    IntentFilter mIntentFilter;
    MyReceiver mReceiver;


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

        // все это нужно для получения данных из сервиса, которое организовываем ...
        mIntentFilter = new IntentFilter();
        mIntentFilter.addAction(CalculateService_2.EXTRA_SEND_SQUARE_SERVICE_ACTION);
        mReceiver = new MyReceiver();
        // НЕ ЗАБЫВАЕМ: что если есть registerReceiver, то должен быть и unregisterReceiver
        registerReceiver(mReceiver, mIntentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver(mReceiver);
    }

    private void sendCommand() {
        try {
            int number = Integer.valueOf(mNumberText.getText().toString());

            Intent intent = CalculateService_2.getIntent(this, number);
//            Intent intent = CalculatorService.getIntent(this, number);
            startService(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ПОЛУЧАЕМ: данные из сервиса ...
    public class MyReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("happy", "onReceive ");
            int square = intent.getIntExtra(CalculateService_2.EXTRA_SEND_NUMBER_SERVICE_2, 0);
            mNumberText.setText(String.valueOf(square));
        }
    }
}
