package com.offer.offer57;

import java.util.HashMap;
import java.util.Map;

/**
 * 哈希的时间、空间复杂度为O(N)，因为需要一个一个的遍历
 * 但是这道题是排序数组，可以使用对撞双指针法，将空间复杂度降为O(1)
 *
 */
public class Main {

    public static void main(String[] args) {
        int[] nums = {10,26,30,31,47,60};
        int target = 40;
        new Main().twoSum(nums,target);
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //如果没有记录
            if (!map.containsKey(nums[i])){
                map.put(target-nums[i],nums[i]);
            }else {
                return new int[]{nums[i],map.get(nums[i])};
            }
        }
        return null;
    }
}
