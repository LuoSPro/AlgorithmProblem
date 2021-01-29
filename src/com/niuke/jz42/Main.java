package com.niuke.jz42;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 返回值描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 * 示例1
 * 输入
 * 复制
 * [1,2,4,7,11,15],15
 * 返回值
 * 复制
 * [4,11]
 *
 */
public class Main {

    public static void main(String[] args) {
        int[] array = {1,2,4,7,11,15};
        int sum = 15;
        ArrayList<Integer> list = new Main().FindNumbersWithSum(array, sum);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    /**
     * 思路：
     * 看到这道题，首先想到力扣的第一题，用Map去处理两数之和，这道题思来想去，多半也是这个思路。
     * 不过，这里说可能有多组，那么就需要保存乘积的最小值，然后判断+变化
     *
     *
     * 题解：
     * 官方给了一个双指针法，没有细看，但是评论区给了一个提示点，说：最外层的乘积最小。
     * 思考了一下，确实是，所以运用这个思想+双指针法，可以完美的解决这个问题
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        int i= 0;
        int j =array.length - 1;
        while (i<j){
            if (array[i] + array[j] > sum){
                //和过大，应该缩小最大值
                j--;
            }else if (array[i] + array[j] == sum){
                list.add(Math.min(array[j], array[i]));
                list.add(Math.max(array[j], array[i]));
                break;
            }else{
                //和过小，应该增大最小值
                i++;
            }
        }
        return list;


//        ArrayList<Integer> list = new ArrayList<>();
//        //保存该数字需要的数字
//        Map<Integer,Integer> map = new HashMap<>();
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < array.length; i++) {
//            if (!map.containsKey(array[i])){
//                //不包含，就添加
//                map.put(sum - array[i],i);
//            }else{
//                //包含，则记录
//                int item = array[map.get(array[i])];
//                if (item*array[i] < min){
//                    list.clear();
//                    list.add(Math.min(item, array[i]));
//                    list.add(Math.max(item, array[i]));
//                }
//            }
//        }
//        return list;
    }

}
