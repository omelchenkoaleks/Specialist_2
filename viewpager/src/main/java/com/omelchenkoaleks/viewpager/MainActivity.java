package com.omelchenkoaleks.viewpager;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {
    ViewPager mViewPager;
    MyPagesAdapter mMyPagesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = findViewById(R.id.pager_vp);

        mMyPagesAdapter = new MyPagesAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mMyPagesAdapter);
    }
}
