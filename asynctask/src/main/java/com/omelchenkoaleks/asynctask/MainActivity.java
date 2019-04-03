package com.omelchenkoaleks.asynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    MyTask mMyTask;
    Button mButton_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton_2 = findViewById(R.id.button_2_bt);
    }

    public void onClick(View view) {
        mMyTask = new MyTask();
        mMyTask.execute();
    }

    public void doSomethingLong() {
        try {
            System.out.println("long operation starts");
            Thread.sleep(5000);
            mButton_2.setText("done");
            System.out.println("long operation stops");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*
    Посмотрим логи:
        методы onPreExecute() and onPostExecute() выполняются в (1) потоке главном, а метод
        doInBackground() в каком-то другом = ради этого AsyncTask и создавался ...
     */
    public class MyTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            System.out.println("onPreExecute "
                    + Thread.currentThread().getName()
                    + " "
                    + Thread.currentThread().getId());
        }

        @Override
        protected Void doInBackground(Void... voids) {
            System.out.println("doInBackground "
                    + Thread.currentThread().getName()
                    + " "
                    + Thread.currentThread().getId());
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            System.out.println("onPostExecute "
                    + Thread.currentThread().getName()
                    + " "
                    + Thread.currentThread().getId());
        }
    }
}
