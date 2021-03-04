package com.niuke.jz27;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 *
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
 * 则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * 示例1
 * 输入
 * 复制
 * "ab"
 * 返回值
 * 复制
 * ["ab","ba"]
 *
 */
public class Main {

    public static void main(String[] args) {
        String str = "abc";
        for (String s : new Main().Permutation(str)) {
            System.out.println(s);
        }
    }

    /**
     * 思路：其实这个和我前面做的那个找和等于target的差不多。都是找组合集
     * @param str
     * @return
     */
    public ArrayList<String> Permutation(String str) {
        char[] chars = str.toCharArray();
        Set<String> set = new HashSet<>();
        dfs(chars,set,"");
        return null;
    }

    private void dfs(char[] chars, Set<String> set, String s) {
        //结束条件：当s的长度和chars的长度一样时
        if (s.length() == chars.length){
            set.add(new String(s));
            return;
        }
        //交换

        //递归

        //恢复

    }

}
