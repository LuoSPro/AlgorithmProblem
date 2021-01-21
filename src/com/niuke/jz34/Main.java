package com.niuke.jz34;

import java.util.*;

/**
 * 题目描述
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 * 示例1
 * 输入
 * 复制
 * "google"
 * 返回值
 * 复制
 * 4
 */
public class Main {

    public static void main(String[] args) {
        String str = "adad";
        System.out.println(new Main().FirstNotRepeatingChar(str));
    }

    /**
     * 思路：
     * 1. 用mapIndex记录字符出现的位置
     * 2. 用setAppear记录以及出现过的字符
     * 3. 用setOnce记录只出现过一次的字符
     *
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar(String str) {
        Map<Character, Integer> mapIndex = new HashMap<>();
        Set<Character> setAppear = new TreeSet<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (setAppear.contains(c)) {
                //已经出现过了
                mapIndex.remove(c);
            } else {
                //第一次出现
                setAppear.add(c);
                mapIndex.put(c, i);
            }
        }
        //找到index最小的那一个
        Set<Map.Entry<Character, Integer>> entries = mapIndex.entrySet();
        int min = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : entries) {
            if (entry.getValue() < min) {
                min = entry.getValue();
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}
