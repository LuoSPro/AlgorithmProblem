package com.niuke.jz36;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目描述
 * 输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 *
 */
public class Main {

    public static void main(String[] args) {

    }

    /**
     * 有一说一，看到这个题，首先想到的是双重循环，但是这样肯定不太行，效率太低了，稍微能优化的，就是把一个链表存到Map里面，再进行一次遍历，这样的时间复杂度为O(n)
     *
     * 题解：
     * 事实证明我还是太年轻了啊，这里使用双指针法，不错不错，这是我没想到的（就算想也想不到啊）
     * 其实就是在遇到公共节点前，始终保持A，B链表的长度相同，这样就能保证他们同时到达公共节点
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
//        if (pHead1 == null||pHead2 == null){
//            return null;
//        }
//        Map<Integer,ListNode> map = new HashMap<>();
//        while (pHead1 != null){
//            map.put(pHead1.val,pHead1);
//            pHead1 = pHead1.next;
//        }
//        while (pHead2 != null){
//            if (map.containsKey(pHead2.val)){
//                return map.get(pHead2.val);
//            }
//            pHead2 = pHead2.next;
//        }
//        return null;

        //---------------双指针------------------
        if(pHead1 == null || pHead2 == null)return null;
        ListNode node1 = pHead1,node2 = pHead2;
        while (node1 != node2){
            node1 = node1.next;
            node2 = node2.next;

            if (node1 != node2&&node1 == null) {
                node1 = pHead2;
            }
            if (node1 != node2&&node2 == null){
                node2 = pHead1;
            }
        }
        return node1;
    }

}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
