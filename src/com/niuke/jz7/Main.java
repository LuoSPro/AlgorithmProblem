package com.niuke.jz7;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 * n\leq 39n≤39
 * <p>
 * 示例1
 * 输入
 * 复制
 * 4
 * 返回值
 * 复制
 * 3
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(new Main().Fibonacci(4));
    }

    //存在栈溢出
//    public int Fibonacci(int n) {
//        if (n == 1 || n == 2){
//            return 1;
//        }
//        return Fibonacci(n-1)+Fibonacci(n-2);
//    }

    public int Fibonacci(int n) {
        if (n == 0){
            return 0;
        } else if (n == 1 || n == 2){
            return 1;
        }
        int a =1 ,b =1;
        for (int i = 3; i <= n; i++) {
            int sum = a + b;
            b = a;
            a = sum;
        }
        return a;
    }
}
