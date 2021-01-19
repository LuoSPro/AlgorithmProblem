package com.exam.exam704;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Main().search(new int[]{6}, 6));
    }

    public int search(int[] nums, int target) {
        int high = nums.length-1;
        int low = 0;
        while (low<=high){
            int mid = (high+low)/2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                high = --mid;
            }else {
                low = ++mid;
            }
        }
        return -1;
    }
}
