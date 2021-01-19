package com.exam.exam1002;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 思路：这个问题的坑就在每个字符串所拥有的字符上面（是否存在，出现过几次）
 * 我的问题：我想到这个点之后，我是去记录每个字符出现得次数，（用总得次数/字符串个数），事实证明这个想法太简单了，我这样没法确定
 * 每个字符是否在它得里面出现了，
 * 题解思路：就是通过记录每个字符串的中字符出现的最小值(Math.min()方法)，然后就能拿到每个字符串的交集，确实牛逼
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(new Main().commonChars(new String[]{"bbddabab","cbcddbdd","bbcadcab","dabcacad","cddcacbc","ccbdbcba","cbddaccc","accdcdbb"}));
    }

    public List<String> commonChars(String[] A) {
        List<String> list = new ArrayList<>();
        int[] arrResult = new int[26];
        Arrays.fill(arrResult,Integer.MAX_VALUE);
        for (int i = 0; i < A.length; i++) {
            int[] arrTemp = new int[26];
            String s = A[i];
            for (int j = 0; j < s.length(); j++) {
                arrTemp[s.charAt(j)-'a']++;
            }
            for (int j = 0; j < arrResult.length; j++) {
                arrResult[j] = Math.min(arrResult[j], arrTemp[j]);
            }
        }
        for (int i = 0; i < arrResult.length; i++) {
            for (int j = 0; j < arrResult[i]; j++) {
                list.add(String.valueOf((char) ('a' + i)));
            }
        }
        return list;
    }
}
