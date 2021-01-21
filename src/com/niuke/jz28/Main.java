package com.niuke.jz28;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * 示例1
 * 输入
 * 复制
 * [1,2,3,2,2,2,5,4,2]
 * 返回值
 * 复制
 * 2
 */
public class Main {
    public static void main(String[] args) {
        int[] array = {1};
        System.out.println(new Main().MoreThanHalfNum_Solution(array));
    }

    public int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer,Integer> map = new HashMap<>();
        int length = array.length;
        for (int i = 0; i < array.length; i++) {
            int item = array[i];
            if (map.containsKey(item)){
                //包含了这个数
                map.put(item,map.get(item) + 1);
            }else{
                map.put(item,1);
            }
            if (map.get(item) > length/2){
                return item;
            }
        }
        return 0;
    }
}
