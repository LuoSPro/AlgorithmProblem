package com.exam.exam21;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        ListNode listNode13 = main.new ListNode(4);
        ListNode listNode12 = main.new ListNode(2, listNode13);
        ListNode listNode11 = main.new ListNode(1 ,listNode12);
        ListNode listNode23 = main.new ListNode(4);
        ListNode listNode22 = main.new ListNode(3, listNode23);
        ListNode listNode21 = main.new ListNode(1,listNode22);
        ListNode listNode = main.mergeTwoLists(listNode11, listNode21);
        while (true) {
            System.out.print(listNode.val);
            if (listNode.next == null) {
                break;
            }
            System.out.print("->");
            listNode = listNode.next;
        }

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //注：我第一次的想法是新建一个ListNode作为节点，再把l1、l2的值写到上面去，但是这样始终会多一个新建的节点
        //看完题解后，发现直接把l1、l2作为节点，并一下开始就从第二个节点开始记录，那么新建的节点就会在第一个，返回.next就能解决
        ListNode listNode = new ListNode();
        ListNode head = listNode;
        while (l1 != null&&l2 != null) {
            if (l1.val <= l2.val) {
                listNode.next = l1;
                l1 = l1.next;
            } else {
                listNode.next = l2;
                l2 = l2.next;
            }
            listNode = listNode.next;
        }
        if (l1 != null){
            listNode.next = l1;
        }
        if (l2 != null){
            listNode.next = l2;
        }
        return head.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
