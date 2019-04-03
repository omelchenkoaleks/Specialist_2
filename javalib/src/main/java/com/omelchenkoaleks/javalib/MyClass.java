package com.omelchenkoaleks.javalib;

public class MyClass {
    public static void main(String[] args) {
        System.out.println("hello");

        MyThread t1 = new MyThread();
        t1.start();
    }

    public static class MyThread extends Thread {
        @Override
        public void run() {
            try {
                sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread");
        }
    }
}
