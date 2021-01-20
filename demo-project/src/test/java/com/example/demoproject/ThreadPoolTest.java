package com.example.demoproject;

import java.util.concurrent.*;

public class ThreadPoolTest {

    private static LinkedBlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<Runnable>();

    public static void main(String[] args) {


        ExecutorService executorService =new ThreadPoolExecutor(5, 10, 0L, TimeUnit.SECONDS, blockingQueue);
        executorService.execute(new Runnable() {
            @Override
            public void run() {

            }
        });

    }
}
