package com.niuke.jz28;

import java.util.HashMap;
import java.util.Map;

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
 *
 */
public class Solution {

    public static void main(String[] args) {
        int[] array = {2};
        System.out.println(new Solution().MoreThanHalfNum_Solution(array));
    }

    public int MoreThanHalfNum_Solution(int [] array) {
        //众数
        int num = -1;
        //出现的次数
        int count = 0;
        //数组的长度
        int length = array.length;
        for (int i = 0; i < length; i++) {
            if (count == 0){
                //如果当前的count为0，那么就把当前的数作为众数
                num = array[i];
                count++;
            }else{
                if (num == array[i]){
                    count++;
                }else{
                    count--;
                }
            }
        }
        //此时的count是用来记录num在数组中出现的次数
        count = 0;
        for (int i = 0; i < length; i++) {
            if (array[i] == num){
                count++;
            }
        }
        if (count > length/2){
            return num;
        }
        return 0;
    }
}
