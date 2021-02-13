package com.niuke.jz14;

import com.sun.org.apache.bcel.internal.generic.LNEG;

/**
 *
 * 题目描述
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 示例1
 * 输入
 * 复制
 * 1,{1,2,3,4,5}
 * 返回值
 * 复制
 * {5}
 *
 */
public class Main {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        System.out.println(new Main().FindKthToTail(root, 1).val);
    }

    /**
     * 思路：典型的双指针法
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null){
            return null;
        }
        ListNode temp = head;
        while (k-- > 0&& temp != null){
            temp = temp.next;
        }
        if (k >= 0){
            return null;
        }

        while (temp != null){
            head = head.next;
            temp = temp.next;
        }
        return head;
    }

}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
