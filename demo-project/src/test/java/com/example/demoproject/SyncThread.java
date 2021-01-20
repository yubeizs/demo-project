package com.example.demoproject;

public class SyncThread implements Runnable {

    private static Integer number = 0;

    public void method() throws Exception {
        synchronized (number) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "-synchronized锁同步代码块:" + number++);
                Thread.sleep(10);
            }
        }
    }

    @Override
    public void run() {
        try {
            method();
        } catch (Exception e) {

        }
    }
}
