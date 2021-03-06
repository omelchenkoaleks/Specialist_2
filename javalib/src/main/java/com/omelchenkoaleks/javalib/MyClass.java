package com.omelchenkoaleks.javalib;

public class MyClass {
    static int sN = 0;

    public static void main(String[] args) {
        System.out.println("hello");

        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start();
        t2.start();

        System.out.println("wow!");
    }

    public static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 20000; i++) {
                sN++;
            }
            System.out.println("sN = " + sN);
        }
    }
}
