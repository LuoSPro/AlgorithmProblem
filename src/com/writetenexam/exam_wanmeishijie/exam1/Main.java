package com.writetenexam.exam_wanmeishijie.exam1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String weightStr = sc.nextLine();
        int limit = sc.nextInt();
        String[] temp = weightStr.split(" ");
        int[] weights = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            try {
                weights[i] = Integer.parseInt(temp[i]);
            } catch (NumberFormatException e) {
                return;
            }
        }
        int nums = work(weights,limit);
        System.out.println(nums);
    }

    private static int work(int[] weights, int limit) {
        //先排序
        Arrays.sort(weights);
        //两个指针，向中间靠拢
        int i = 0;
        int j = weights.length-1;
        int count = 0;
        while (i <= j){
            if (weights[j] + weights[i] > limit){
                j--;
                count++;
            }else{
                i++;
                j--;
                count++;
            }
        }
        return count;
    }

}
