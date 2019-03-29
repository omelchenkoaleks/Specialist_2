package com.omelchenkoaleks.fragments;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    private FrameLayout mNestFrameLayout;
    private FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.logMe();
        setContentView(R.layout.activity_main);

        mNestFrameLayout = findViewById(R.id.nest_fl);

        // получаем менеджер
        FragmentManager manager = getSupportFragmentManager();
        // начинаем транзакцию
        mFragmentTransaction = manager.beginTransaction();
        // между началом транзакции и завершение транзакции выполняем какие-то действия
        mFragmentTransaction.add(R.id.nest_fl, new MyFragment());
        // завершаем транзакцию
        mFragmentTransaction.commit();
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
