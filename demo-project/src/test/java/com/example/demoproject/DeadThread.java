package com.example.demoproject;

public class DeadThread implements Runnable{

    private Object lock1 = new Object() ;

    private Object lock2 = new Object() ;

    public void method() throws Exception{
        System.out.println("死锁开始~~~");
        synchronized (lock1){
            System.out.println(Thread.currentThread().getName()+":锁住了lock1");
            Thread.sleep(1000);
            synchronized (lock2){
                   System.out.println(Thread.currentThread().getName()+":锁住了lock2");
               }
        }
    }

    public void otherMethod() throws Exception{
        System.out.println();
        synchronized (lock2){
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+":锁住了lock2");
            synchronized (lock1){
                System.out.println(Thread.currentThread().getName()+":锁住了lock1");
            }
        }
    }


    @Override
    public void run() {
        try {
            method();
            otherMethod();
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        DeadThread deadThread = new DeadThread();
        new Thread(deadThread,"线程A").start();
        new Thread(deadThread,"线程B").start();

    }
}
