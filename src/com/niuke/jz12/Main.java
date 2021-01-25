package com.niuke.jz12;

/**
 * 题目描述
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * 保证base和exponent不同时为0
 * 示例1
 * 输入
 * 复制
 * 2,3
 * 返回值
 * 复制
 * 8.00000
 *
 */
public class Main {
    public static void main(String[] args) {
        double base = 2;
        int exponent = 3;
        System.out.println(new Main().Power(base, exponent));
    }

    /**
     * 思路：看到这个完全没头绪啊，只知道调用系统提供的Api
     * 但是看到答案之后，发现以前学过，就是快速幂的方法（递归），即x^8 = (x^4)^2 ——(O(log n)) 这样可以比暴力解法(  O(n) )的一个一个乘节约很多时间
     *
     * 还有就是要注意对数据进行预处理
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        if (exponent < 0){
            base = 1.0/base;
        }
        return p_power(base,exponent);
    }

    /**
     * 快速幂 —— 求解
     * @param base
     * @param exponent
     * @return
     */
    private double p_power(double base, int exponent) {
        if (exponent == 0){
            //当exponent为0时，相当于x的0次方 = 1
            return 1;
        }
        //递归
        double result = p_power(base, exponent / 2);
        //根据exponent的奇偶来做运算的判断
        if (exponent%2 == 0){
            //偶数，直接乘
            result = result * result;
        }else{
            //奇数,还要乘上自己
            result = result * result * base;
        }
        return result;
    }
}
