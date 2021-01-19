package com.test.test2;


/**
 * 题目描述
 * 给定一个数组arr，返回子数组的最大累加和
 * 例如，arr = [1, -2, 3, 5, -2, 6, -1]，所有子数组中，[3, 5, -2, 6]可以累加出最大的和12，所以返回12.
 * [要求]
 * 时间复杂度为O(n)O(n)，空间复杂度为O(1)O(1)
 *
 * 示例1
 * 输入
 * [1, -2, 3, 5, -2, 6, -1]
 * 返回值
 * 12
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1, -2, 3, 5, -2, 6, -1};

        System.out.println(new Main().maxsumofSubarray(arr));
    }

    public int maxsumofSubarray (int[] arr) {
        // write code here
        int result = 0;
        for (int i = 1; i < arr.length; i++) {
            //用arr来保存当前位置的最大累加和
            arr[i] = Math.max(arr[i-1]+arr[i],arr[i]);
            //上边做修改，下边做比较+保存
            result = Math.max(arr[i],result);
        }
        return result;
    }
}
