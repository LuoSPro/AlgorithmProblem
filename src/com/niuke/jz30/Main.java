package com.niuke.jz30;

/**
 * 题目描述
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为 O(n).
 * 示例1
 * 输入
 * 复制
 * [1,-2,3,10,-4,7,2,-5]
 * 返回值
 * 复制
 * 18
 * 说明
 * 输入的数组为{1,-2,3,10,—4,7,2,一5}，和最大的子数组为{3,10,一4,7,2}，因此输出为该子数组的和 18。
 */
public class Main {
    public static void main(String[] args) {
        int[] array = {-2,-8,-1,-5,-9};
        System.out.println(new Main().FindGreatestSumOfSubArray(array));
    }

    public int FindGreatestSumOfSubArray(int[] array) {
        //过滤数据
        if (array == null||array.length == 0){
            return 0;
        }
        //动态规划
        int[] record = new int[array.length];
        record[0] = array[0];
        int max = record[0];
        for (int i = 1; i < array.length; i++) {
            if (record[i-1] < 0){
                record[i] = array[i];
            }else {
                record[i] = record[i-1] + array[i];
            }
            max = Math.max(max,record[i]);
        }
        return max;
    }
}
