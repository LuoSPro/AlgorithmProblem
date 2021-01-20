package com.niuke.jz16;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 示例1
 * 输入
 * 复制
 * {1,3,5},{2,4,6}
 * 返回值
 * 复制
 * {1,2,3,4,5,6}
 * <p>
 * 问题：
 * 如果我不想多用一个新的List来保存合并的结果，而是复用list1或list2，那么后面，我如何区分list1和list2呢
 */
public class Main {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);
        new Main().Merge(null, null);
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode list = new ListNode(-1);
        ListNode head = list;
        while (list1 != null && list2 != null) {
            //合并
            if (list1.val > list2.val) {
                list.next = list2;
                list2 = list2.next;
            }else{
                list.next = list1;
                list1 = list1.next;
            }
            list = list.next;
        }
        //收尾工作
        if (list1 != null){
            list.next = list1;
        }
        if (list2 != null){
            list.next = list2;
        }
        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
