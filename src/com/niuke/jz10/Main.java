package com.niuke.jz10;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * 比如n=3时，2*3的矩形块有3种覆盖方法：
 *
 * 示例1
 * 输入
 * 复制
 * 4
 * 返回值
 * 复制
 * 5
 *
 */
public class Main {

    public static void main(String[] args) {

    }

    /**
     * 思路：
     * 做完jz9，再来看这个，一模一样，都是基于1和2的，其他方法都能由1,2组合，太明显了吧，今天剑指offer打卡完成——2021-1-22
     * @param target
     * @return
     */
    public int rectCover(int target) {
        if (target == 0)
            return 0;
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
