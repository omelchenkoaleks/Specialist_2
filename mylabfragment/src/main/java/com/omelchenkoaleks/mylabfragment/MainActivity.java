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
            System.out.println("long operation starts");
            Thread.sleep(5000); // это любая долгая операция
            System.out.println("long operation stops");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void onClick(View view) {
        WorkerThread t1 = new WorkerThread();
        t1.start();
    }

    /*
    теперь вместо того, чтобы запускать долгую операцию из обработчика событий,
    мы ее выселили непосредственно в отдельный поток Thread ...

    ТЕПЕРЬ: главный поток приложения освобожден от долгой операции ...
     */
    public class WorkerThread extends Thread {
        @Override
        public void run() {
            doSomethingLong();
        }
    }
}
