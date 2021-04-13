package com.day.day0326;

import com.exam.exam2.ListNode;

/**
 *
 * 83. 删除排序链表中的重复元素
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 *
 * 返回同样按升序排列的结果链表。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * 示例 2：
 *
 *
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 *
 *
 */
public class Main {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(1);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(3);
        root.next.next.next.next = new ListNode(4);
        root.next.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next.next = new ListNode(5);
        ListNode node = new Main().deleteDuplicates(root);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null||head.next == null){
            return head;
        }
        ListNode node = head;
        ListNode next = head.next;
        while (next != null){
            while (next != null && node.val == next.val){
                //相等
                next = next.next;
            }
            node.next = next;
            node = node.next;
            if (next != null){
                next = next.next;
            }
        }
        return head;
    }

}
