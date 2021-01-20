package com.example.mymethod;

import com.alibaba.fastjson.JSONArray;
import lombok.Synchronized;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindLostNum {

    public static void main(String[] args) throws Exception {

        for (int i = 1; i <=100; i++) {
            List<Integer> list = Stream.iterate(1, n -> n + 1).limit(100).collect(Collectors.toList());
            list.remove(list.indexOf(i));
            Integer num = findNum(list, 1, 100, 100);
            if(i != num){
                System.out.println("num:"+i);
            }
        }
        System.out.println("测试通过~~");
    }

    /**
     *
     * @param numList 缺少数字的数组
     * @param min 数组的最小值
     * @param max 数组的最大值
     * @param initSize 不缺失的话数组的长度（比如1-100应该有100个数。initSize 就是100）
     * @return
     * @throws Exception
     */
    public static Integer findNum(List<Integer> numList, Integer min, Integer max , Integer initSize) throws Exception{
        // 数组为空，直接返回min，相当于就一个数的数组，还少了一个数，应该不存在这种，方法会做处理
        if(numList.size() == initSize){
            return min;
        }
        // 数组缺少数字，size肯定是小于initSize 的，如果大于，肯定是有问题了
        if(numList.size()> initSize){
            throw new Exception("数组个数大于传递个数，缺失暂时无法计算！");
        }

        Integer minNum = numList.get(0); // 获取数组实际的最小值
        Integer maxNum = numList.get(numList.size() - 1); // 获取数组实际的最大值

        //对比，不一样的话直接返回最小值或者最大值
        if(min != minNum){
            return min;
        }
        if(max != maxNum){
            return max;
        }

        //数组个数奇数偶数区分，奇数偶数肯定有不同的处理逻辑
        int midNum ;  // 中间的那个值，奇数组与偶数组定义不同
        boolean flag = false;// 数组个数是不是偶数
        if((initSize)%2==0){
             midNum = (maxNum + minNum) / 2;
             flag = true;
        } else {
            midNum = (maxNum + minNum) / 2;
        }
        // 中间的那个值为空，直接返回，说明缺少这个中间数
        int i = numList.indexOf(midNum);
        if(i == -1){
            return midNum;
        }


        if(flag){// 偶数个数的数组处理
            // 从第一个到中位数 数组
            List<Integer> preList = numList.subList(0, numList.indexOf(midNum)+1);
            if(preList.size() != initSize/2){  //数组长度不是initSize的一半，说明缺少数字，递归查询
                return findNum(preList,minNum,midNum,initSize/2);
            }
            // 同理，处理后半段
            List<Integer> nextList = numList.subList(numList.indexOf(midNum)+1,numList.size());
            if(nextList.size() != initSize/2){
                return findNum(nextList,midNum+1,maxNum,initSize/2);
            }
        } else {
            //奇数数组处理，取中位数前一位数字，应该等于中位数减一
            Integer midPreNum = numList.get(numList.indexOf(midNum) - 1);
            if(midPreNum != (midNum-1)){
                return midNum -1;
            }
            // 同理，取中位数后一位数字
            Integer midNextNum = numList.get(numList.indexOf(midNum) + 1);
            if(midNextNum != (midNum+1)){
                return midNum + 1;
            }
            //移除中位数
            numList.remove(numList.indexOf(midNum));

            // 取前半段处理，然后递归
            List<Integer> preNumList = numList.subList(0, numList.indexOf(midPreNum)+1);
            if(preNumList.size() < initSize/2){
                return findNum(preNumList,min,midPreNum,initSize/2);
            }
            // 取后半段处理，然后递归
            List<Integer> nextNumList = numList.subList(numList.indexOf(midPreNum)+1,numList.size());
            if(nextNumList.size() < initSize/2){
                return findNum(nextNumList,midNextNum,max,initSize/2);
            }
            // 找不到的话就是没有缺少喽
            System.out.println("数组不缺少值！！");
        }
        return null;

    }




}
