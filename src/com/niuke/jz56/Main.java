package com.niuke.jz56;

import com.exam.exam2.ListNode;

public class Main {


    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        //头指针，不参与运算
        ListNode root = new ListNode(-1);
        //保存链表
        root.next = pHead;
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
