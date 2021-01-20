package com.example.jvm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/**
 *  设置虚拟机参数：
 *  -Xms100M -Xms100m -XX:+UseSerialGC -XX:+PrintGCDetails
 */
public class JConsoleTool {

    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException {
        Thread.sleep(20000); //先运行程序，在执行监控
        List<OOMObject> list = new ArrayList<OOMObject>();
        Thread.sleep(5000);
        for (int i = 0; i < num; i++) {
            // 稍作延时，令监视曲线的变化更加明显
            Thread.sleep(50);
            System.out.println("对象添加："+i);
            list.add(new OOMObject());
            if(i>880)
                Thread.sleep(10000);
        }
        System.gc();
    }

    public static void main(String[] args) throws Exception {
//        for (int i = 0; i < 10000 ; i++) {
//            Thread.sleep(6000);
//            System.out.println("数字："+i);
//        }

        fillHeap(1000);
        int i = 0;
        while(true){
            Thread.sleep(6000);
            System.out.println("数字："+i++);
        }
    }



    /**
     * 等待控制台输入
     * @throws IOException
     */
    public static  void waitRerouceConnection () throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
    }
    /**
     * 线程死循环演示
     */
    public static void createBusyThread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true)   // 第41行
                    ;
            }
        }, "testBusyThread");
        thread.start();
    }

    /**
     * 线程锁等待演示
     */
    public static void createLockThread(final Object lock) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "testLockThread");
        thread.start();
    }

}
