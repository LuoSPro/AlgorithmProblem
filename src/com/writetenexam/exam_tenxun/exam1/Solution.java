package com.writetenexam.exam_tenxun.exam1;

import com.sun.org.apache.bcel.internal.generic.LNEG;
import javafx.util.Pair;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        ListNode root = new ListNode(5);
        root.next = new ListNode(3);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(2);
        root.next.next.next.next = new ListNode(1);
        ListNode solve = new Solution().solve(root);
        System.out.println(root);
//        while (solve!=null){
//            System.out.println(solve.val);
//        }
    }


    /**
     * 思路：要保证链表顺序，所以不能排序
     * @param S
     * @return
     */
    public ListNode solve (ListNode S) {
        // write code here
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o2.val - o1.val;
            }
        });
        ListNode root = S;
        while (root != null){
            queue.add(new ListNode(root.val));
            root = root.next;
        }
        root = queue.poll();
        S = root;
        while (!queue.isEmpty()){
            root.next = queue.poll();
            root = root.next;
        }
        return S;
    }

}

class ListNode{
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
