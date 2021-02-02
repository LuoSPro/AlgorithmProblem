package com.niuke.jz55;

import com.sun.org.apache.bcel.internal.generic.LNEG;

/**
 * 题目描述
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class Main {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
//        root.next.next.next = root.next.next;
        root.next.next.next.next = new ListNode(5);
        System.out.println(new Main().EntryNodeOfLoop(root).val);
    }

    /**
     * 思路：
     * 看到过这个题，题解用的是快慢指针，这个还有点印象，但是细节忘得差不多了，
     * 比如为什么快慢指针就能相遇（我觉得是因为在闭环里面，快慢指针始终是一个循环，所以必相遇）
     *
     * 题解：
     * 其实快慢指针很容易想通，但是最后相遇的节点需要依据数学依据才能理解：
     *   A                 B
     *                 (       )
     *                D          C
     *                  (     )
     *                     _
     * 假设环是由BCD组成的，现在设AB=X，BC=Y，并且假设慢指刚好走到B点（环的开始），快指针走到D点（环里面），
     * 设快慢指针在C点相遇（BCD很大，以至于快指针还没走完环的一圈，慢指针就进来了）。
     * 那么，此时慢指针在B点的话，慢指针所走路程为X，快指针为2X
     * 当在C点相遇时，A走了X+Y,B走了2*(X+Y)
     * 所以，DB = Y，ABCD=2X，BCD=X
     * 所以，在相遇之后，慢指针在C点，到达B点的距离为  CD+DB = CD + BC BCD = X。快指针从A点过来的距离 AB也等于X
     * 所以两个必定相遇
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode quickP = pHead;
        ListNode slowP = pHead;
        while (quickP != null && quickP.next != null) {
            //双倍的走
            quickP = quickP.next.next;
            //一个一个的走
            slowP = slowP.next;
            if (slowP == quickP)
                break;
        }
        if (quickP == null||quickP.next==null){
            return null;
        }
        quickP = pHead;
        while (slowP != quickP) {
            //慢指针一直在环内循环
            slowP = slowP.next;
            //快指针从头一个一个的循环
            quickP = quickP.next;
        }
        //这里直接放回慢指针是不对的，因为快慢指针可能是在环里面相遇的，所以还需要再找一遍
        return slowP;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
