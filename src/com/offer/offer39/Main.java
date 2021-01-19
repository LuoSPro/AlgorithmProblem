package com.offer.offer39;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        int[] nums = {1};
        int element = new Main().majorityElement(nums);
        System.out.println(element);
    }

    public int majorityElement(int[] nums) {
        int size = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)){
                int value = map.get(num) + 1;
                map.put(num,value);
                if (value >= size/2.0){
                    return num;
                }
            }else{
                map.put(num,1);
            }
        }
        return nums[0];
    }

}
