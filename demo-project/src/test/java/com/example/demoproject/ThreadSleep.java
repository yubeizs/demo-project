package com.example.demoproject;

public class ThreadSleep {

    public static Integer count = 1;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public synchronized Integer getAddCount(){
        return getCount()+1;
    }



}
