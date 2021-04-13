package com.exam.exam264;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(new Main().nthUglyNumber(n));
    }

    public int nthUglyNumber(int n) {
        int c2 = 0;
        int c3 = 0;
        int c5 = 0;
        int[] arr = new int[n];
        int index = 1;
        //初始化数据
        arr[0] = 1;
        while(index < n){
            arr[index] = Math.min(2*arr[c2],Math.min(3*arr[c3],5*arr[c5]));
            if (arr[index] % 2 == 0) c2++;
            if (arr[index] % 3 == 0) c3++;
            if (arr[index] % 5 == 0) c5++;
            System.out.println(arr[index]);
            index++;
        }
        return arr[index-1];
    }

}
