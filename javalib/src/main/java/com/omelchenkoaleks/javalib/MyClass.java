package com.omelchenkoaleks.javalib;

public class MyClass {
    public static void main(String[] args) {
        System.out.println("hello");

        MyThread t1 = new MyThread();
        t1.start();

        System.out.println("wow!");

        /*
        методо посылвет сообщение thread, что пора завершаться ...
         */
//        t1.interrupt();
    }

    /*
    нужен, чтобы запустить какую-то отдельную задачу (в отдельном потоке) ...
     */
    public static class MyThread extends Thread {
        @Override
        public void run() {
            try {
                sleep(20000);
                System.out.println("thread");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
