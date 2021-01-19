package com.offer.offer53I;

public class Main {

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        int target = 1;
        System.out.println(new Main().search(nums, target));
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0){
            return 0;
        }
        //先用二分查找把数字查出来
        int i=0,j = nums.length - 1;
        int mid = 0;
        while (i <= j){
            mid = (i+j)/2;
            if (nums[mid] > target){
                j = mid - 1;
            }else if (nums[mid] < target){
                i = mid + 1;
            }else {
                break;
            }
        }
        int result = 0;
        //再统计前后共有多少个数字
        for (int k = mid; k<nums.length&&nums[k] == target; k++) {
            result++;
        }
        for (int k = mid-1; k>=0&&nums[k] == target; k--) {
            result++;
        }
        return result;
    }

}
