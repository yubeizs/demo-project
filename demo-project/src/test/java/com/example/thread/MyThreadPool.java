package com.example.thread;

import java.util.Vector;

public class MyThreadPool {

    public static void main(String[] args) throws Exception {


        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程一开始"+Thread.currentThread());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程一结束"+Thread.currentThread());
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程二开始"+Thread.currentThread());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程二结束"+Thread.currentThread());
            }
        });
        System.out.println("main 方法开始。。。。"+Thread.currentThread());

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println("main 方法结束。。。。"+Thread.currentThread());

    }

}
