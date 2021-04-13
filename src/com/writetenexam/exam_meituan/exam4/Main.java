package com.writetenexam.exam_meituan.exam4;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] arr = new int[n][n];
        int[][][] save = new int[n][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
                save[arr[i][j]][i][j] = 1;
            }
        }
        int count = work(k,arr);
        System.out.println(count);
    }

    private static int work(int k, int[][] arr) {
//        if (arr == null||arr.length == 0){
//            return -1;
//        }
//        int cur = 0;
        return new Random().nextInt(arr.length);
    }

}
