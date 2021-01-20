package com.example.demoproject;

public class TestSynchorize {

    public synchronized static void test1() {
        System.out.println("test1");
    }

    public synchronized void test2(){
        System.out.println("test2");
    }

    public void test3(){
        synchronized (this){
            System.out.println("test3");
        }
    }
}
