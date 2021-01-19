package com.test.test3;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述
 * 给定数组arr，设长度为n，输出arr的最长递增子序列。（如果有多个答案，请输出其中字典序最小的）
 * 示例1
 * 输入
 * 复制
 * [2,1,5,3,6,4,8,9,7]
 * 返回值
 * 复制
 * [1,3,4,8,9]
 * 示例2
 * 输入
 * 复制
 * [1,2,8,6,4]
 * 返回值
 * 复制
 * [1,2,4]
 * 说明
 * 其最长递增子序列有3个，（1，2，8）、（1，2，6）、（1，2，4）其中第三个字典序最小，故答案为（1，2，4）
 */

/**
 * 我的疑惑：
 * 1. 如何把每个位置和他对应的子序列对应起来，因为子序列一个列表，而不是一个数组？
 *
 * 2. 如果我从头到尾都用一个result列表来记录，那么我该如何判断什么时候开始的子序列才是最长的呢？
 *
 */

/**
 * 思考：
 * 我觉得应该从后往前遍历，构造一个二维数组保存length和next，length记录最长递增子序列，next继续下一个数字，方便重新查找
 * 并且设置一个最小值，如果小于这个最小值，子序列+1
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,8,6,4};
        System.out.println(new Main().LIS(arr));
    }

    public int[] LIS (int[] arr) {
        // write code here
        List<Integer> result = new ArrayList<>();
        int[][] node = new int[2][arr.length];
        if (arr.length == 0){
            return null;
        }
        int length = arr.length;

        int minIndex = length - 1;
//        for (int i = length - 1; i >= 0; i++) {
//            //最小index的位置
//            if (arr[i] < arr[minIndex]){
//                //改变最小位置
//                minIndex = i;
//                //当前长度
//                node[0][i] = node
//            }
//            node[0][arr.length - 1] = 1;
//            node[1][arr.length - 1] = -1;
//        }
        return null;
    }

}
