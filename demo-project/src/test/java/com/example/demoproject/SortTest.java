package com.example.test;

import org.assertj.core.util.Lists;
import org.json.JSONObject;

import java.util.*;

import static org.assertj.core.util.IterableUtil.iterator;

public class SortTest {

    public static void main(String[] args) {
        //梯次排序 第一列是顺序a,b,c,d; 第二列也是a,b,c,d
        List<String> list  = new ArrayList<>();
        list.add("b||d||a");
        list.add("a||c||d");
        list.add("a||b||c");
        list.add("a||c||b");
        list.add("b||c||d");
        list.add("a||b||d");
        list.add("d||c||a");
        list.add("b||c||a");

        List<String> strings = sortStr(list);
        System.out.println("输出："+ strings.toString());
    }

    /**
     * 排序方法
     * @param list
     * @return
     */
    private static List<String> sortStr(List<String> list){

        if(list.size()<=1){
            return list;
        }

        String strings = list.get(0);
        Integer length = strings.split("\\|\\|").length;
        //方法调用
        List<String> sortList = getSortList(list, 0, length - 1);

        return sortList;

    }

    /**
     * 简单的递归实现排序
     * @param list
     * @param num
     * @param length
     * @return
     */
    public static List<String> getSortList(List<String> list,Integer num,Integer length){
        //list 封装成Map，根据num的字符串为key
        Map<String,List<String>> listMap = new LinkedHashMap<>();
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String str = iterator.next();
            String key = getKey(str, num);
            List<String> strings1 = listMap.get(key);
            if(strings1!=null&&strings1.size()>0){
                strings1.add(str);
            } else {
                List<String> tempList = new ArrayList<>();
                tempList.add(str);
                listMap.put(key,tempList);
            }
        }

        //遍历map,取得value,添加到新的list
        List<String> tempList = Lists.newArrayList(listMap.keySet());
        Collections.sort(tempList);
//        Collections.reverse(tempList); 倒序
        Iterator<String> stringIterator =tempList.iterator();
        List<String> lists = new ArrayList<>();

        while (stringIterator.hasNext()){
            String next = stringIterator.next();
            List<String> strings = listMap.get(next);

            if(strings!=null&&strings.size()>0){
                if(num < length){
                    // 每一个map中的value重新进行排序，直到倒数第二列
                    strings = getSortList(strings, num + 1, length);
                }
                //value 已经排好序，添加到list
                lists.addAll(strings);
            }
        }

        return lists;
    }

    //获取以||分割的第num个的值
    private static String getKey(String str,Integer num){
        if(str!=null&&str.length()>0){
            String[] split = str.split("\\|\\|");
            return split[num];
        }
        return null;
    }
}
