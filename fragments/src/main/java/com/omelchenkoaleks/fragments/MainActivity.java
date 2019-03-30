package com.omelchenkoaleks.fragments;

import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    FrameLayout mFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.logMe();
        setContentView(R.layout.activity_main);

        mFrameLayout = findViewById(R.id.nest_fl);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Logger.logMe();

        if (mFrameLayout.getChildCount() == 0) {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = manager.beginTransaction();

            // Bundle как структура, которя может передавать данные (ключ/значение)
            // предлназначена для того, чтобы передавать их между разными компонентами ...
            Bundle bundleForFragment  = new Bundle();
            bundleForFragment .putString("parameter", "qqq");

            MyFragment myFragment = new MyFragment();
            myFragment.setArguments(bundleForFragment );

            fragmentTransaction.add(R.id.nest_fl, myFragment);
            fragmentTransaction.commit();
        } else {
            Log.d("happy", "already have the fragment");
        }
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
