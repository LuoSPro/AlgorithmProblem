package com.niuke.jz5;

import java.util.Stack;

public class Main {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        while (stack2.size() != 0){
            stack1.push(stack2.pop());
        }
        stack1.push(node);
    }

    public int pop() {
        while (stack1.size() != 0){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.push(1);
        main.push(2);
        main.push(3);

        System.out.println(main.pop());
        System.out.println(main.pop());
    }


}
