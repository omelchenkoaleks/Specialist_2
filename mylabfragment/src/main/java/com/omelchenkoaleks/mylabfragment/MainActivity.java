package com.omelchenkoaleks.mylabfragment;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doSomethingLong() {
        try {
            Thread.sleep(30000); // это любая долгая операция
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void onClick(View view) {
        doSomethingLong();
    }
}
