package com.niuke.jz27;

import java.util.ArrayList;
import java.util.Collections;

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
        ArrayList<String> list = new ArrayList<>();
        dfs(list,str,0);
        Collections.sort(list);
        return list;
    }

    /**
     *
     * @param list 返回的结果
     * @param s 每个Item
     * @param index 当前的要交换的位置
     */
    private void dfs(ArrayList<String> list, String s,int index) {
        //结束条件：当s的长度和chars的长度一样时
        if (index == s.length() && !list.contains(s)){
            list.add(s);
        }
        //这里要用一个for循环，因为要对从index后的每一位进行交换
        for (int i = index; i < s.length(); ++i) {
            //交换
            s = swap(s,index,i);
            //递归
            dfs(list, s, index + 1);
            //恢复
            s = swap(s,i,index);
        }

    }

    private String swap(String s, int index, int i) {
        if (i != index){
            StringBuffer sb = new StringBuffer(s);
            char temp = sb.charAt(index);
            sb.setCharAt(index,sb.charAt(i));
            sb.setCharAt(i,temp);
            s = sb.toString();
        }
        return s;
    }

}
