package com.exam.exam26;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = new int[]{};
        // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
        int len = main.removeDuplicates(nums);
        // 在函数里修改输入数组对于调用者是可见的。
        // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]+"  ");
        }
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int cur = nums[0];
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != cur){
                nums[index] = nums[i];
                cur = nums[i];
                index ++;
            }
        }
        return index;
    }


}
