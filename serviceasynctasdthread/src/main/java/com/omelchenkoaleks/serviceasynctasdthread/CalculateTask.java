package com.omelchenkoaleks.serviceasynctasdthread;

import android.os.AsyncTask;
import android.util.Log;

public class CalculateTask extends AsyncTask<Void, Void, Integer> {
    private int number;

    CalculateTask(int number) {
        this.number = number;
    }

    @Override
    protected Integer doInBackground(Void... voids) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return number * number;
    }

    @Override
    protected void onPostExecute(Integer square) {
        Log.d("happy", "calculated " + square);
    }
}
