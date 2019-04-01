package com.omelchenkoaleks.castomview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    PaneContainer mDualPaneContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDualPaneContainer = findViewById(R.id.container_dpc);
    }

    public PaneContainer getDualPaneContainer() {
        return mDualPaneContainer;
    }
}
