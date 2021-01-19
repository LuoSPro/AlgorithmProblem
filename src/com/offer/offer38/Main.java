package com.offer.offer38;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 *  
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 *  
 *
 * 示例:
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *
 *
 * 思路：
 * 0~s.length-1这几个位置中，从0开始，固定每一个位置的数，并用set去保存，方便查重
 * 每次递归都是在对其下一位进行固定，每次回归都是对set中已经存在过的数进行剪枝（不剪枝就是完全排列——有重复）
 * 如果最后一位元素被固定了，那么这个顺序就符合我们的要求了，可以直接加进list
 */
public class Main {
    public static void main(String[] args) {
        String[] strings = new Main().permutation("aab");
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }

    }

    public String[] permutation(String s) {
        char[] data = s.toCharArray();
        List<String> list = new ArrayList<>();
        perm(list,data,0,data.length);
        return list.toArray(new String[list.size()]);
    }

    public void swap(char[] data,int i,int j){
        char temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public void perm(List<String> list, char[] data, int begin, int end){
        if (begin == data.length - 1){
            //当最后一个位置被固定时，找到一个排列
            list.add(new String(data));
        }else{
            //没有找完一个排列，则继续往下找下一个元素
            //set每次递归都被重新创建，所以当回归的时候才去判断是否有重复
            HashSet<Character> set = new HashSet<>();
            for (int i = begin; i < end; i++) {
                //判断是否有重复元素
                if (set.contains(data[i])){
                    // 重复，因此剪枝
                    continue;
                }
                //如果没有重复元素
                set.add(data[i]);
                //交换元素
                swap(data,begin,i);
                //递归排列剩余的从begin+1到end的元素（固定begin+1的位置）
                perm(list,data,begin+1,end);
                //回溯时还原现场（不还原，我们就不知道是否已经全排列完成）
                swap(data,begin,i);
            }
        }
    }
}
