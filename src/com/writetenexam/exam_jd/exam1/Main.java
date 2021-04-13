package com.writetenexam.exam_jd.exam1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Cheems的宝石
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 小狗Cheems在魔大陆大冒险，收集到了n颗宝石，第i个宝石有其美丽值a[i]，Cheems决定挑出一些宝石带回家，
 * 一颗带回家的宝石给Cheems带来的快乐值与其石头本身的美丽值相等。虽然我们知道不是所有的宝石的美丽值都为正数，
 * 但是Cheems还是很开心，每带回家3颗宝石，Cheems的快乐值就会加K。问Cheems要如何选择宝石带回家，使得自己能获得的快乐值最高。
 * 请输出快乐值的最大值。
 *
 * 输入描述
 * 第一行包括两个正整数n,k，表示收集到的宝石的数量和每带回家3颗宝石快乐值的增加量。
 *
 * 第二行包括n个整数，表示第i颗宝石的美丽值。
 *
 * -1000≤a[i]≤1000,1≤k≤1000
 *
 * 输出描述
 * 输出能获得的快乐值的最大值
 *
 *
 * 样例输入
 * 5 5
 * 1 2 3 4 -6
 * 样例输出
 * 15
 *
 * 提示
 * 带回前三颗宝石能获得（1 + 2 + 3 + 5= 11）的快乐值，同时再带回第四颗宝石，总共获得的快乐值为15，这时是能获得的最大的快乐值。
 *
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
//        int[] temp = {-6,-5,-3,-1,5,8,9,10};
        System.out.println(work( k, arr));
//        System.out.println(work(5, temp));
    }

    public static int work(int k, int[] arr){
        if (arr == null||arr.length == 0){
            return 0;
        }
        //先排序
        Arrays.sort(arr);
        int[] dp = new int[arr.length];
        dp[arr.length-1] = arr[arr.length-1];
        //从大到小使用动态规划
        for (int i = arr.length - 2; i >= 0; i--) {
            if ((arr.length - i)%3 == 0){
                //特殊情况，已经有三个了，快乐+k
                dp[i] = arr[i] + dp[i+1] + k;
            }else{
                dp[i] = arr[i] + dp[i+1];
            }
        }
        int max = 0;
        for (int i = dp.length - 1; i >= 0; i--) {
            if (dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }



}
