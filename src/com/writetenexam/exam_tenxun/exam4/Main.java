package com.writetenexam.exam_tenxun.exam4;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        System.out.println(work(arr, max));
    }

    private static int work(int[][] arr, int money) {
        //保存最小序列
        Map<Integer,Integer> maxMap = new HashMap<>();
        Map<Integer,Integer> minMap = new HashMap<>();
        //就每个的最小
        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0]>arr[i][1]){
                minMap.put(i,arr[i][1]);
                min += arr[i][0];
            }else{
                maxMap.put(i,arr[i][0]);
            }
        }
        for (int i = 0; i < arr.length/2+1; i++) {
            money -= minMap.get(i) + maxMap.get(arr.length-1-i);
        }
        return money;

    }


}
