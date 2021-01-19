package com.exam.exam747;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Main().dominantIndex(new int[]{1,2,16,35,44,100,27,0}));
    }

    public int dominantIndex(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int max = nums[0];
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max){
                max = nums[i];
                index = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 && nums[i] != max && max / nums[i] < 2){
                index = -1;
                break;
            }
        }

        return index;
    }
}
