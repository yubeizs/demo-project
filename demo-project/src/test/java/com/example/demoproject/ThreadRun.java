package com.example.demoproject;

public class ThreadRun implements Runnable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ThreadRun(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("ThreadRun方法名称："+Thread.currentThread().getName()+" Thread id信息："+Thread.currentThread().getId());
    }
}
