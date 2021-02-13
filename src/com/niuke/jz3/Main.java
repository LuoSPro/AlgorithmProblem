package com.niuke.jz3;

import com.sun.org.apache.bcel.internal.generic.ALOAD;

import java.util.ArrayList;

/**
 *
 * 题目描述
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * 示例1
 * 输入
 * 复制
 * {67,0,24,58}
 * 返回值
 * 复制
 * [58,24,0,67]
 *
 */
public class Main {

    public static void main(String[] args) {

        ListNode root = new ListNode(67);
        root.next = new ListNode(0);
        root.next.next = new ListNode(24);
        root.next.next.next = new ListNode(58);
        for (Integer integer : new Main().printListFromTailToHead(root)) {
            System.out.println(integer);
        }
    }

    /**
     * 思路：
     * 最简单的办法应该就是用队列的方式去做，但是这道题应该考的是逆向打印单向链表，所以这里需要用到额外的两个指针去做交换（做过，但是记不太清了）
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null){
            return list;
        }
        //保存上一个节点
        ListNode pre = null;
        ListNode next;
        //保存当前节点
        ListNode cur = listNode;
        while (cur != null){
            //处理前,先记录
            next = cur.next;
            //处理后
            cur.next = pre;
            //更新pre
            pre = cur;
            //更新cur
            cur = next;
        }

        //记录
        while (pre != null){
            list.add(pre.val);
            pre = pre.next;
        }
        return list;
    }

}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
