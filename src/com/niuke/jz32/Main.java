package com.niuke.jz32;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] numbers = {3,32,321};
        new Main().PrintMinNumber(numbers);
    }

    /**
     * 思路：我觉得就是一个全排列的问题，然后把所有的数做比较，这相当于暴力了
     * @param numbers
     * @return
     */
    public String PrintMinNumber(int [] numbers) {
        List<String> list = new ArrayList<>();
        allSort(numbers,list,"",0);
        Collections.sort(list);
        return list.get(0);
    }

    private void allSort(int[] numbers, List<String> list,String num, int cur) {
        if (cur == numbers.length){
            list.add(num);
            return;
        }
        for (int i = cur; i < numbers.length; i++) {
            swap(numbers,cur,i);
            allSort(numbers, list,num+numbers[cur] , cur+1);
            swap(numbers,i,cur);
        }
    }

    private void swap(int[] numbers, int x, int y) {
        if (x == y){
            return;
        }
        int temp = numbers[y];
        numbers[y] = numbers[x];
        numbers[x] = temp;
    }

}
