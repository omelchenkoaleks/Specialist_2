package com.omelchenkoaleks.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Logger.logMe();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Logger.logMe();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Logger.logMe();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Logger.logMe();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Logger.logMe();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.logMe();
    }
}
