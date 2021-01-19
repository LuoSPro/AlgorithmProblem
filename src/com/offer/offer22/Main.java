package com.offer.offer22;

public class Main {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        System.out.println(new Main().getKthFromEnd(node, 2).val);
    }

    /**
     * 双重指针
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode pre = head;
        ListNode end = null;
        //移动指针
        for (int i = 0; i < k-1; i++) {
            end = head.next;
            head = end;
        }
        //当k值过小时，防空指针异常
        if (end == null ){
            end = head;
        }
        //移动指针
        while (end.next != null){
            pre = pre.next;
            end = end.next;
        }
        return pre;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
