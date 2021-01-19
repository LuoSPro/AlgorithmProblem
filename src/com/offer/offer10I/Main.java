package com.offer.offer10I;

public class Main {

    public static void main(String[] args) {
        System.out.println(new Main().fib(3));
    }

    /**
     * 循环记忆法
     *
     * @param n
     * @return
     */
//    public int fib(int n) {
//        if (n == 0) {
//            return 0;
//        }
//        if (n == 1) {
//            return 1;
//        }
//        int arr[] = new int[n+1];
//        arr[0] = 0;
//        arr[1] = 1;
//        for (int i = 2; i <= n; i++) {
//            arr[i] = (arr[i-1]+arr[i-2])% 1000000007;
//        }
//        return arr[n];
//    }

    /**
     * 动态规划法
     */
    public int fib(int n) {
        int a = 0,b = 1,sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b)%1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
