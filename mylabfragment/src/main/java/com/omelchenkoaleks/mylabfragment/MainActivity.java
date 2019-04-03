package com.omelchenkoaleks.mylabfragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Handler mHandler;
    Button mButton_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton_2 = findViewById(R.id.button_2_bt);

        /*
        с помощью Handler мы поставили в очередь UI-потока еще одну задачу и Looper выполнил ее
         */
        mHandler = new Handler();
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                System.out.println("I`m in Runnable!");
            }
        });
    }

    public void doSomethingLong() {
        try {
            System.out.println("long operation starts");

            Thread.sleep(5000); // это любая долгая операция
            mButton_2.setText("done");

            System.out.println("long operation stops");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void onClick(View view) {
        WorkerThread t1 = new WorkerThread();
        t1.start();
    }

    public class WorkerThread extends Thread {
        @Override
        public void run() {
            doSomethingLong();
        }
    }
}
