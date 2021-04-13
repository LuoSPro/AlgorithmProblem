package com.test.test25;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        String s = "i am hero";
        System.out.println(new Main().work(s));
    }

    private String work(String s) {
        Stack<String> stack = new Stack<>();
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                //空格
                stack.push(" "+temp);
                temp = "";
            }else{
                temp += s.charAt(i);
            }
        }
        //最后一个单词
        stack.push(temp);
        s = "";
        while (!stack.isEmpty()){
            s += stack.pop();
        }
        return s;
    }


}
