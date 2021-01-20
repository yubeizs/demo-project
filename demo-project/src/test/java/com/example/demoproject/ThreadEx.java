package com.example.demoproject;

public class ThreadEx extends Thread{


    public ThreadEx(String name) {
        super(name);
    }

    /**
     * 重写run()方法
     */
    @Override
    public void run() {
        System.out.println("运行方式"+this.getName()+"  ThreadEx方法名称："+Thread.currentThread().getName()+"  Thread id信息："+Thread.currentThread().getId());
    }
}
