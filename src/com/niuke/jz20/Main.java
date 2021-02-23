package com.niuke.jz20;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 题目描述
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.push(1);
        System.out.println(main.min());
        main.push(2);
        System.out.println(main.min());
        main.pop();
        main.pop();
        main.push(7);
        System.out.println(main.min());
        main.push(5);
        System.out.println(main.min());
        main.push(3);
        System.out.println(main.min());
    }

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> mins = new Stack<>();
    int min = Integer.MAX_VALUE;

    /**
     * 思路：需要维护一个保存最小值的栈
     *
     * @param node
     */
    public void push(int node) {
        if (node < min) {
            List<Integer> list = new ArrayList<>();
            //把比node小的数拿出来
            while (!mins.empty() && node < mins.peek()) {
                list.add(mins.pop());
            }
            //到达比node大的数的位置
            mins.push(min);
            for (int i = list.size() - 1; i >= 0; i--) {
                mins.push(list.get(i));
            }
            min = node;
        }
        stack.push(node);
    }

    public void pop() {
        int pop = stack.pop();
        if (pop == min && !mins.empty()) {
            mins.pop();
            if (mins.empty()){
                min = Integer.MAX_VALUE;
            }else{
                min = mins.peek();
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min;
    }

}
