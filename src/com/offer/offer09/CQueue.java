package com.offer.offer09;

import java.util.Stack;

public class CQueue {
    private Stack<Integer> headStack;
    private Stack<Integer> endStack;

    public CQueue() {
        headStack = new Stack<>();
        endStack = new Stack<>();
    }

    public void appendTail(int value) {
        endStack.push(value);
    }

    public int deleteHead() {
        if (endStack.size() == 0){
            return -1;
        }
        while (!endStack.empty()) {
            Integer value = endStack.pop();
            headStack.push(value);
        }
        Integer result = headStack.pop();
        while (!headStack.empty()) {
            Integer value = headStack.pop();
            endStack.push(value);
        }
        return result;
    }

    public static void main(String[] args) {
        CQueue queue = new CQueue();
        System.out.println(queue.deleteHead());
        queue.appendTail(5);
        queue.appendTail(2);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }
}
