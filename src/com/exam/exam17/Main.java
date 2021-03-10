package com.exam.exam17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> list = new Main().letterCombinations("23");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public List<String> letterCombinations(String digits) {
        //初始化数据
        String s = "";
        String[] res = digits.split("");
        for (int i = 0; i < res.length; i++) {
            if ("2".equals(res[i])){
                s += "abc";
            }else if ("3".equals(res[i])){
                s += "def";
            }else if ("4".equals(res[i])){
                s += "ghi";
            }else if ("5".equals(res[i])){
                s += "jkl";
            }else if ("6".equals(res[i])){
                s += "mno";
            }else if ("7".equals(res[i])){
                s += "pqrs";
            }else if ("8".equals(res[i])){
                s += "tuv";
            }else if ("9".equals(res[i])){
                s += "wxyz";
            }
        }
        List<String> list = new ArrayList<>();
        combinations(s.length(),s,list,0);
        Collections.sort(list);
        return list;
    }

    private void combinations(int n,String s, List<String> list, int index) {
        if (index == n){
            list.add(new String(s));
            return;
        }
        for (int i = index; i < n; i++) {
            //交换
            s = swap(s,i,index);
            //递归
            combinations(n, s, list, index + 1);
            //还原
            s = swap(s,index,i);
        }

    }

    private String swap(String s, int i, int index) {
        if (index != i){
            StringBuilder builder  = new StringBuilder(s);
            builder.setCharAt(i,s.charAt(index));
            builder.setCharAt(index,s.charAt(i));
            s = builder.toString();
        }
        return s;
    }

}
