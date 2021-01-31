package com.niuke.jz50;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 题目描述
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中第一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * 返回描述：
 * 如果数组中有重复的数字，函数返回true，否则返回false。
 * 如果数组中有重复的数字，把重复的数字放到参数duplication[0]中。（ps:duplication已经初始化，可以直接赋值使用。）
 */
public class Main {

    public static void main(String[] args) {
        int[] numbers = {2,3,1,0,2,5,3};
        int length = 7;
        int[] duplication = new int[1];
        System.out.println(new Main().duplicate(numbers, length, duplication));
    }

    /**
     * 思路：
     * 这道题不能用排序，因为他需要按照顺序去找重复的数字，所以最简单的就是用一个Map去保存
     *
     * 题解：
     * 我们上面用的是最容易想到的，但是空间复杂度为O(N),我们需要新开辟一个空间来保存，这样不太行。
     * 这里其实给了一个条件，我们没有用上，那就是她数据的范围是0~n-1的，那么我们就能给每个数据归位。如果发现他的位置上已经归位了，那么她就是重复的
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        int index = numbers[0];
        int temp;
        while (numbers[index] != index){
            temp = numbers[index];
            index = numbers[temp];
        }
        if (numbers[index] == index){
            duplication[0] = index;
            return true;
        }
        return false;


//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < length; i++) {
//            if (set.contains(numbers[i])){
//                duplication[0] = numbers[i];
//                return true;
//            }
//            set.add(numbers[i]);
//        }
//        return false;


    }
}
