package com.omelchenkoaleks.asynctask;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
//    MyTask mMyTask;
//    Button mButton_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mButton_2 = findViewById(R.id.button_2_bt);
    }

    public void onClick(View view) {
//        mMyTask = new MyTask();
//        mMyTask.execute(3, 4);
    }


    /*
    ВАЖНАЯ ЗАМЕТКА: если в методе doInBackground() запущен долгий процесс, и тут
    пользователь поворачивает экран, процесс продолжается, но уже другое активити и оно
    не получит тот результат, который должен прийти ))) ...

    ВТОРОЙ ВАЖНЫЙ МИНУС: пока работает AsyncTask он имеет ссылку на предыдушую активити (хотя
    она может уже не показываться на экране (например, при повороте экрана) но, эта активити не
    может попасть к сборщику мусора т.к. есть активная ссылка, хотя она и никакой пользы уже
    не приносит - и вот, эта вся конструкция находится в памяти ...  и с каждым переворотом даже
    может становиться на один экземпляр больше!!! ...
     */
//    public class MyTask extends AsyncTask<Integer, Void, String> {
//        @Override
//        protected String doInBackground(Integer... params) {
//            Integer a = params[0];
//            Integer b = params[1];
//
//            System.out.println("doInBackground "
//                    + Thread.currentThread().getName()
//                    + " "
//                    + Thread.currentThread().getId());
//
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            int c = a + b;
//            return "Summ " + c;
//        }
//
//        @Override
//        protected void onPostExecute(String sum) {
//            System.out.println("onPostExecute "
//                    + Thread.currentThread().getName()
//                    + " "
//                    + Thread.currentThread().getId());
//
//            mButton_2.setText(sum);
//        }
//    }
}
