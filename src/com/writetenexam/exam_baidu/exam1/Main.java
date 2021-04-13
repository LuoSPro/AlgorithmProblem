package com.writetenexam.exam_baidu.exam1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = 0;
        int size = 0;
        try {
            max = sc.nextInt();
            size = sc.nextInt();
        } catch (Exception e) {
            System.out.println("0");
            return;
        }
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(work(arr, max));
    }

    private static int work(int[] arr, int max) {
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= max){
                max = max-arr[i];
                count++;
            }else{
                break;
            }
        }
        return count;
    }

}
