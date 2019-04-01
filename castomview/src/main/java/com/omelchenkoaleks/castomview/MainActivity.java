package com.omelchenkoaleks.castomview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    DetailView mDetailView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDetailView = findViewById(R.id.detail_dv);
        mDetailView.showItem("воточки жжж ююю ...");
    }
}
