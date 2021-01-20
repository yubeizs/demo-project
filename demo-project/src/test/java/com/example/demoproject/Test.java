package com.example.demoproject;

import com.alibaba.fastjson.JSON;

import java.util.HashSet;
import java.util.Set;

public class Test {

    public static void main(String[] args) {
        // 新建2个相同内容的Person对象，
        // 再用equals比较它们是否相等
        Person p1 = new Person("eee",100);
        Person p2 = new Person("eee", 100);
        System.out.printf("%s\n", p1.equals(p2));

        Set<Person> set = new HashSet<>();
        set.add(p1);
        set.add(p2);

        System.out.println("sdfsd:"+ JSON.toJSONString(set));

    }
}
