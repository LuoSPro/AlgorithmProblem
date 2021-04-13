package com.writetenexam.exam_wanmeishijie.exam2;

import java.util.Scanner;

/**
 *
 * 0 1 12 -1 -1 -1
 * -1 0 9 3 -1 -1
 * -1 -1 0 0 5 -1
 * -1 -1 4 0 13 15
 * -1 -1 -1 -1 0 4
 * -1 -1 -1 -1 -1 0
 *
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(work(arr, 1));
        System.out.println(work(arr, 2));
         System.out.println(work(arr, 3));
        System.out.println(work(arr, 4));
        System.out.println(work(arr, 5));
    }

    private static int work(int[][] arr, int i) {
        //到达1退出递归
        if (i == 0){
            return 0;
        } else{//状态转移
            int distance = 999;
            for (int j = 0; j < 6; j++) {
                if (arr[j][i] != -1&&arr[j][i] != 0){
                    int temp = arr[j][i] + work(arr,j);
                    if (temp < distance){
                        distance = temp;
                    }
                }
            }
            return distance;
        }
    }
}
