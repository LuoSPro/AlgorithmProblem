package com.niuke.jz9;

/**
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 示例1
 * 输入
 * 复制
 * 3
 * 返回值
 * 复制
 * 4
 *
 */
public class Main {

    public static void main(String[] args) {
        int target = 4;
        System.out.println(new Main().JumpFloorII(target));
    }

    public int JumpFloorII(int target) {
        if (target == 0||target == 1)
            return 1;
        int a = 1,b;
        for (int i = 2; i <= target; i++) {
            b = a << 1;
            a = b;
        }
        return a;
    }
}
