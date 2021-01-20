package com.example.thread;

import com.alibaba.fastjson.JSON;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test {

    public static Map<String,String> map = new ConcurrentHashMap<>();

    static {
        initMap();
    }

    private static void initMap() {
        map.put("1","静态方法测试");

    }

    public static void main(String[] args) {
        System.out.println("打印："+ JSON.toJSONString(map));
    }
}
