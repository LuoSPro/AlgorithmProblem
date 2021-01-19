package com.offer.offer57;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {10,26,30,31,47,60};
        int target = 40;
        new Solution().twoSum(nums,target);
    }

    public int[] twoSum(int[] nums, int target) {
        int i = 0,j = nums.length-1;
        while (i <= j){
            int s = nums[i] + nums[j];
            if (s > target)
                j--;
            else if (s < target)
                i++;
            else if (s == target)
                return new int[]{nums[i],nums[j]};
        }
        return null;
    }
}
