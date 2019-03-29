package com.omelchenkoaleks.fragments;

import android.util.Log;

/**
 * инструмент для наблюдения за жизненным циклом ...
 */
public class Logger {
    public static void logMe() {
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        // выводим весь стек
        for (int i = 0; i < stack.length; i++) {
            Log.d("happy", ""
                    + i
                    + " "
                    + stack[i].getClassName()
                    + " "
                    + stack[i].getMethodName());
        }

        // в стеке подсмотрели номер элемента массива нужный и теперь его только можем вывести ...
            Log.d("happy", stack[3].getClassName() + " " + stack[3].getMethodName());
        }
    }
}
