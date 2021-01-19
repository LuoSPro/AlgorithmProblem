package com.offer.offer21;

public class Main {

    public static void main(String[] args) {
        int[] nums = {2,4,6,8,1};
        new Main().exchange(nums);
    }

    //思路：采用快排的思想，但是只需要跑一遍
    public int[] exchange(int[] nums) {
        int i=0,j=nums.length-1;
        while (i<j){
            while (i<j&&nums[i] % 2 == 1){
                //奇数不管
                i++;
            }
            while (i<j&&nums[j] % 2 == 0){
                //偶数不管
                j--;
            }
            if (i<j){
                //交换
                change(nums,i,j);
            }
        }
        return nums;
    }

    private void change(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
