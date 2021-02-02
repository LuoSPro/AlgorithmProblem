package com.niuke.jz53;

import java.util.regex.Pattern;

/**
 * 题目描述
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * 示例1
 * 输入
 * 复制
 * "123.45e+6"
 * 返回值
 * 复制
 * true
 * 示例2
 * 输入
 * 复制
 * "1.2.3"
 * 返回值
 * 复制
 * false
 */
public class Main {

    public static void main(String[] args) {
        String num = "12e";
        char[] str = num.toCharArray();
        System.out.println(new Main().isNumeric(str));
    }


    /**
     * 思路：
     * 这里首先想到的是暴力解法，一个一个遍历，然后把所有情况考虑到
     *
     * 题解：
     * 这道题确实用正则是最简单的方法
     *
     * @param str
     * @return
     */
    public boolean isNumeric(char[] str) {

//        String value = String.valueOf(str);
//        String pattern = "[\\+]?[\\-]?";
        return false;

//        if (str == null || str.length == 0) {
//            return false;
//        }
//        char first = str[0];
//        if (!(first == '+' || first == '-' || (first >= '1' && first <= '9'))){
//            return false;
//        }
//        for (int i = 1; i < str.length - 1; i++) {
//            //不是数字
//            if (!(str[i]>='0'&&str[i]<='9')){
//                if (str[i] == 'e'||str[i] == 'E'){
//                    if (str[i+1] == '-'||str[i+1] == '+'||(str[i+1] >= '0'&&str[i+1] <= '9')){
//                        i++;
//                    }else {
//                        return false;
//                    }
//                }else if (str[i] == '.'){
//                    if (str[i+1] >= '0'&&str[i+1] <= '9'){
//                        i++;
//                    }else {
//                        return false;
//                    }
//                }else {
//                    return false;
//                }
//            }
//        }
//        return true;
    }

}
