package com.example.demoproject;

public class ThreadTest {

    public static void main(String[] args) throws Exception{
//         Thread thread1 = new Thread(new SyncThread(), "SyncThread1");
//         Thread thread2 = new Thread(new SyncThread(), "SyncThread2");
//         thread1.start();
//         thread2.start();

        System.out.println("开始了~~");
//        Thread.sleep(20000);
        DeadThread deadThread = new DeadThread();
        new Thread(deadThread,"线程A").start();
        new Thread(deadThread,"线程B").start();
    }

      /*  ThreadRun runThread = new ThreadRun("runThread");
        ThreadEx threadEx1 = new ThreadEx("start");
        ThreadEx threadEx2 = new ThreadEx("run");

        runThread.run();

        threadEx1.start();
        threadEx2.run();*/
//    }
}
