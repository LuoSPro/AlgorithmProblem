package com.exam.exam88;

/***
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 示例 2：
 *
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 */
public class Main {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        new Main().merge(nums1,m,nums2,n);
        for (int i : nums1) {
            System.out.println(i);
        }
    }

    /**
     * 思路：这道题能让我提交10次，我是没想到的，很简单啊，就是一些边界条件判断不好，这个需要细心啊
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1 == null || nums2 == null || n == 0){
            return;
        }
        int i = 0;
        int j = 0;
        while(i < m+n&&j < n){
            //找到nums1中第一个大于nums2[j]的元素
            while(i < m && nums1[i] <= nums2[j]){
                i++;
            }
            int temp = m;
            //把nums1中i后的元素往后移一位
            while(temp < nums1.length && temp > i){
                nums1[temp] = nums1[temp-1];
                temp--;
            }
            //放入nums2[j]到nums1中
            nums1[i++] = nums2[j++];
            m++;
        }
    }

}
