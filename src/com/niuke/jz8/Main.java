package com.niuke.jz8;

/**
 *
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * 示例1
 * 输入
 * 复制
 * 1
 * 返回值
 * 复制
 * 1
 * 示例2
 * 输入
 * 复制
 * 4
 * 返回值
 * 复制
 * 5
 */
public class Main {

    public static void main(String[] args) {
        int target = 5;
        System.out.println(new Main().JumpFloor(target));
    }

    /**
     * 思路
     * 我承认我有赌的成分！！！
     * 看完题解后，突然想到，他每次肯定是走一步或者两步，因为超过两步后的数字都可以由1,2组合而成，所以其实能走的步数每次就2种：走1步或走2步
     * @param target
     * @return
     */
    public int JumpFloor(int target) {
        int a = 1;
        int b = 0;
        int temp;
        for (int i = 0; i < target; i++) {
            temp = a + b;
            b = a;
            a = temp;
        }
        return a;
    }
}
