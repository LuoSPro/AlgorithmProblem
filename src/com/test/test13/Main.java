package com.test.test13;

import com.sun.org.apache.bcel.internal.generic.LNEG;

public class Main {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        reverse(root);
    }

    private static void reverse(ListNode root) {
        ListNode node = root.next;
        ListNode next = null;
        root.next = null;
        while (node != null){
            next = node.next;
            node.next = root;
            root = node;
            node = next;
        }
    }


}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
