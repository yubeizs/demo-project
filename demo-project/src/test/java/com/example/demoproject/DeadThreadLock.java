package com.example.demoproject;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class DeadThreadLock {

    private static Lock lock1 = new ReentrantLock() ;

    private static Lock lock2 = new ReentrantLock() ;

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock1.lock();
                    System.out.println(Thread.currentThread().getName()+"lock1加锁成功");
                    Thread.sleep(1000);
                    lock2.lock();
                    System.out.println(Thread.currentThread().getName()+"lock1,2加锁成功");
                    lock1.unlock();
                    lock2.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock2.lock();
                    System.out.println(Thread.currentThread().getName()+"lock2加锁成功");
                    Thread.sleep(1000);
                    lock1.lock();
                    System.out.println(Thread.currentThread().getName()+"lock1,2加锁成功");
                    lock1.unlock();
                    lock2.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程B").start();
    }

}

