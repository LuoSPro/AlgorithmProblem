package com.test.test15;

import com.sun.org.apache.bcel.internal.generic.LNEG;

public class Main {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = new ListNode(6);
//        root.next.next.next.next.next.next = root.next.next.next;
        root.next.next.next.next.next.next = new ListNode(7);
//        root.next.next.next.next.next.next.next = new ListNode(8);
        System.out.println(new Main().hasCycle(root));
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode quick = head.next;
        ListNode slow = head;
        while (quick != null && quick.next != null && quick.val != slow.val) {
            quick = quick.next.next;
            slow = slow.next;
        }
        return quick == null||quick.next == null ? false : true;
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
