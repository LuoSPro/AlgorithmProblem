package com.exam.exam19;

import com.exam.exam2.ListNode;

import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        ListNode listNode1 = main.new ListNode(1);
        ListNode listNode2 = main.new ListNode(2);
        ListNode listNode3 = main.new ListNode(3);
        ListNode listNode4 = main.new ListNode(4);
        ListNode listNode5 = main.new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode listNode = main.removeNthFromEnd(listNode1, 5);
        while (true) {
            System.out.print(listNode.val);
            if (listNode.next == null) {
                break;
            }
            System.out.print("->");
            listNode = listNode.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //提示：Maintain two pointers and update one with a delay of n steps.
        //延迟n步：指针1和指针2相差n个，指针2到达最后一个的时候，指针1的下一个刚好是要删除的
        ListNode pointHead = head;
        ListNode tempPoint = pointHead;
        while (n-- != 0) {
            tempPoint = tempPoint.next;
        }
        ListNode pointEnd = tempPoint;
        while (true) {
            //退出条件
            if (pointEnd == null || pointEnd.next == null) {
                break;
            }
            //更新指针
            pointHead = pointHead.next;
            pointEnd = pointEnd.next;
        }
        if (pointEnd == null){
            head = pointHead.next;
        }else{
            pointHead.next = pointHead.next.next;
        }
        return head;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
