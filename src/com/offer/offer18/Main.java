package com.offer.offer18;

public class Main {
    public static void main(String[] args) {
        ListNode root = new ListNode(-3);
        root.next = new ListNode(5);
        root.next.next = new ListNode(-99);
//        root.next.next.next = new ListNode(9);

        int val = -99;
        root = new Main().deleteNode(root,val);
        while (root != null){
            System.out.println(root.val);
            root = root.next;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null){
            return null;
        }
        ListNode node;
        if (head.val == val) {
            head = head.next;
            return head;
        }
        node = head;
        while (node.next != null){
            if (node.next.val == val){
                node.next = node.next.next;
                //处理完马上返回
                return head;
            }
            node = node.next;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
