package com.niuke.jz15;

import com.sun.org.apache.bcel.internal.generic.LNEG;

/**
 * 题目描述
 * 输入一个链表，反转链表后，输出新链表的表头。
 * 示例1
 * 输入
 * 复制
 * {1,2,3}
 * 返回值
 * 复制
 * {3,2,1}
 *
 */
public class Main {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root = new Main().ReverseList(root);
        while (root != null){
            System.out.println(root.val);
            root = root.next;
        }
    }

    /**
     * 这里我首先想到用栈来存储节点，这样就能翻转，但是这样肯定不是最优解，最优解应该是在空间复杂度为O(1)的基础上去做，这个就要多思考一下了
     * 这里我想到的是用三个指针来保存pre,next，newHead,先试一试吧
     * pre:node的前一个节点
     * next:node的下一个节点
     * newHead:新的链表的头结点
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode next = null;
        ListNode node = head.next;
        head.next = null;
        while (node != null){
            //1. 先保存node的next后面的数据
            next = node.next;
            //2. 将node的next改变
            node.next = head;
            //3. 改变head
            head = node;
            //4. 下一位数
            node = next;
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
