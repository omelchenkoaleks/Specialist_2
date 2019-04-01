package com.omelchenkoaleks.viewpager;

import android.util.Log;

public class Logger {
    public static void logMe() {
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        Log.d("happy", stack[3].getClassName() + " " + stack[3].getMethodName());
    }

}
