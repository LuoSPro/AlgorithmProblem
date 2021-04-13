package com.exam.exam739;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = new Main().dailyTemperatures(arr);
        for (int i : result) {
            System.out.println(i);
        }
    }

    /**
     * 暂时想的是暴力
     *
     * 题解：单调栈，yyds
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {

        //单调栈，保留最大的
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int[] dp = new int[T.length];
        int i = 0;
        while (i < T.length){
            //保持递增
            while (stack.peek() != -1&&T[stack.peek()] < T[i]){
                //弹栈
                dp[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
            i++;
        }
        return dp;


//        if (T == null||T.length == 0){
//            return null;
//        }
//        int[] dp = new int[T.length];
//        for (int i = 0; i < T.length-1; i++) {
//            if (T[i] < T[i+1]){
//                dp[i] = 1;
//            }else{
//                //第二天小于
//                boolean flag = false;
//                for (int j = i+1; j < T.length; j++) {
//                    if (T[j] > T[i]){
//                        dp[i] = j-i;
//                        flag = true;
//                        break;
//                    }
//                }
//                if (!flag){
//                    dp[i] = 0;
//                }
//            }
//        }
//        return dp;
    }

}
