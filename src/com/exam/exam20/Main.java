package com.exam.exam20;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(isValid("}{"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            if (item=='('||item=='['||item=='{'){
                stack.push(item);
            }else if (!stack.empty()){
                if (item==')'&&!(stack.pop()=='(')) {
                    return false;
                }else if (item==']'&&!(stack.pop()=='[')) {
                    return false;
                }else if (item=='}'&&!(stack.pop()=='{')) {
                    return false;
                }
            }else {
                return false;
            }
        }
        return stack.isEmpty();
        //return stack.empty()?true:false;
    }
}
