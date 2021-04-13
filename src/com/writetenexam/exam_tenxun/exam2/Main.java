package com.writetenexam.exam_tenxun.exam2;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextLine();
        }
        //检验是否合法
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if ("for".equals(arr[i])){
                stack.add(arr[i]);
            }else if ("end".equals(arr[i])){
                stack.pop();
            }else {
                System.out.println("0");
                return;
            }
        }
        if (stack.size() != 0){
            System.out.println(0);
        }
        int max = 0;
        int count = 0;
        int[] dp = new int[size];
        for (int i = 0; i < arr.length-1; i++) {
            if ("end".equals(arr[i])){
                if (i - dp[i-1]*2 - 1 >= 0){
                    if ("end".equals(arr[i - dp[i-1]*2 - 1])){
                        dp[i] = dp[i - dp[i-1]*2 - 1] + 1;
                    }else{
                        dp[i] = dp[i - dp[i-1]*2 - 1] + 1 + dp[i-1];
                    }
                }else{
                    dp[i] = 1;
                }

            }
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i]++;
            if (dp[i] > max){
                max = dp[i];
            }
        }
//        work(arr,0,0,size);
        if (size == 0){
            System.out.println("0");
        }else{
            System.out.println(max);
        }
    }

    static int max = 0;

    /**
     * 二叉树的思想
     * @param arr
     * @param size
     * @return
     */
    private static void work(String[] arr,int cur, int count,int size) {
        //可以count++
        boolean flag = true;
        if (cur >= size){
            //是end就返回
            return;
        }
        if ("end".equals(arr[cur])){
            if (cur+1<size&&"for".equals(arr[cur+1])){
                count--;
            }
        }else{
            count++;
            if (count > max){
                max = count;
            }
        }
        work(arr, cur+1, count, size);
    }
/**
 * 16
 * for
 * for
 * for
 * for
 * end
 * end
 * end
 * for
 * end
 * for
 * for
 * for
 * end
 * end
 * end
 * end
 */

}
