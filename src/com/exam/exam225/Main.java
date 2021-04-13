package com.exam.exam225;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }



}

/**
 * 思路：就是用两个队列，当要出栈的时候，就把一个队列里面的钱 size-1个数移到另一个队列中
 */
class MyStack {

    private Queue<Integer> pre;
    private Queue<Integer> end;

    /** Initialize your data structure here. */
    public MyStack() {
        pre = new LinkedList<>();
        end = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        pre.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (pre.size() != 1){
            end.add(pre.poll());
        }
        while (!end.isEmpty()){
            pre.add(end.poll());
        }
        return pre.poll();
    }

    /** Get the top element. */
    public int top() {
        while (pre.size() != 1){
            end.add(pre.poll());
        }
        //拿到最后一个数
        int pop = pre.poll();
        while (!end.isEmpty()){
            pre.add(end.poll());
        }
        //把最后一个数加在后面
        pre.add(pop);
        return pop;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return pre.size() == 0;
    }
}
