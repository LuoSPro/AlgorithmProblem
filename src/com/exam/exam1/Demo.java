package com.exam.exam1;

import java.util.HashMap;
import java.util.Map;

public class Demo {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        int[] arr = twoSum(nums,target);
        System.out.println("["+arr[0]+","+arr[1]+"]");
    }


    //最low的解法，也是最先想到的
//    public static int[] twoSum(int[] nums, int target) {
//        int[] arr = new int[2];
//        int i,j;
//        for (i = 0;i<nums.length;i++) {
//            for(j=i+1;j<nums.length;j++){
//                if (nums[i]+nums[j]==target){
//                    arr[0] = i;
//                    arr[1] = j;
//                }
//            }
//        }
//        return arr;
//    }


    //Map解法
    public static int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        //key:所需的值
        //value:下标
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //查看map中有没有 需要这个值的（key）
            if (map.containsKey(nums[i])){
                arr[0] = i;
                arr[1] = map.get(nums[i]);
                return arr;
            }
            map.put(target-nums[i],i);
        }
        return arr;
    }
}
