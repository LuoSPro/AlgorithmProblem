package com.day.day0325;

import com.exam.exam2.ListNode;

public class Main {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(1);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(3);
        root.next.next.next.next = new ListNode(4);
        root.next.next.next.next.next = new ListNode(4);
        root.next.next.next.next.next.next = new ListNode(5);
        ListNode node = new Main().deleteDuplicates(root);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //头指针，不参与运算
        ListNode root = new ListNode(-1);
        //保存链表
        root.next = head;
        //更新
        ListNode node = root;
        ListNode next = node.next;
        while (next != null && next.next != null) {
            //不相等则继续走
            if (next.next.val == next.val) {
                //相等，则遍历完
                while (next != null && next.next != null && next.next.val == next.val) {
                    next = next.next;
                }
                //删掉节点
                node.next = next.next;
            }
            next = next.next;
            if (next != null && next.next != null && node.next.val != next.val) {
                node = node.next;
            }
        }
        return root.next;
    }

}
