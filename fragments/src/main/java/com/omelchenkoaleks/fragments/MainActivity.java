package com.omelchenkoaleks.fragments;

import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    FrameLayout mFrameLayout;
    MyFragment mMyFragment;

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

        Log.d("happy", "MyActivity onStart " + hashCode());

        FragmentManager manager = getSupportFragmentManager();
        if (mFrameLayout.getChildCount() == 0) {
            // Если пусто, то добавляем фрагмент ...
            FragmentTransaction fragmentTransaction = manager.beginTransaction();

            mMyFragment = MyFragment.getInstance("put " + hashCode());

            fragmentTransaction.add(R.id.nest_fl, mMyFragment);
            fragmentTransaction.commit();
        } else {
            Log.d("happy", "already have the fragment");

            // Если не пусто, то берем оттуда фрагмент ...
            mMyFragment = (MyFragment) manager.findFragmentById(R.id.nest_fl);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Logger.logMe();

        mMyFragment.setMessage("added");
    }
}
