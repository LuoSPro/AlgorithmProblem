package com.niuke.jz43;

/**
 * 题目描述
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,
 * 要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 * 示例1
 * 输入
 * 复制
 * "abcXYZdef",3
 * 返回值
 * 复制
 * "XYZdefabc"
 *
 */
public class Main {

    public static void main(String[] args) {
        String str = "abcXYZdef";
        int n = 3;
        System.out.println(new Main().LeftRotateString(str, n));
    }


    /**
     * 思路：
     * 这个问题看起来不是很难啊，就是简单的字符串操作，利用Java里面的Api可以直接搞定。如果要考虑优化的话，那我实在是想不到有什么可优化的
     * @param str
     * @param n
     * @return
     */
    public String LeftRotateString(String str,int n) {
        if (n <= 0||str == null||str.length() == 0){
            return str;
        }
        return str.concat(str.substring(0,n)).substring(n);
    }

}
