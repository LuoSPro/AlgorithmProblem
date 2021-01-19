package com.exam.exam142;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(3);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(0);
        listNode.next.next.next = new ListNode(-4);
        listNode.next.next.next.next = listNode;
        System.out.println(new Main().detectCycle(listNode).val);
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null){
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        while (head != null){
            
        }
        return null;

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
