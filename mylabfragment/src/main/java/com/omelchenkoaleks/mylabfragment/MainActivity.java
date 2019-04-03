package com.omelchenkoaleks.mylabfragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button mButton_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton_2 = findViewById(R.id.button_2_bt);
    }

    public void doSomethingLong() {
        try {
            System.out.println("long operation starts");

            /**
             * Многопоточность в пользовательском интерфейсе (Андроид) - запрещена!!!
             *
             * поэтому, невозможно изменить название кнопки из другого потока в UI - потоке ...
             */

            Thread.sleep(5000); // это любая долгая операция

            /*
                 ЗДЕСЬ УПАДЕТ ПРИЛОЖЕНИЕ ...
             */
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
