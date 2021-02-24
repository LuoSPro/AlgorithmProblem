package com.niuke.jz25;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 题目描述
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针random指向一个随机节点），请对此链表进行深拷贝，并返回拷贝后的头结点。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 */
public class Main {

    public static void main(String[] args) {
        RandomListNode root = new RandomListNode(1);
        root.next = new RandomListNode(2);
        root.next.next = new RandomListNode(3);
        root.next.next.next = new RandomListNode(4);
        root.random = root.next.next;
        root.next.random = root.next.next.next;
        root.next.next.random = root.next;
        root.next.next.next.random = root;
        new Main().Clone(root);
    }

    /**
     * 思路，这道题就是考的对深拷贝的认识吧，感觉不是很难啊
     *
     * 题解：
     * 我思路是对了，就是靠深拷贝，不过处理的时候，不是很恰当。使用一个Map可以大大的节约时间,减少复杂度
     *
     * 其实这里在写入map的数据时，就把每个RandomListNode就创建好了，后面相当于直接找每个node的替代对象而已
     * @param pHead
     * @return
     */
    public RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead == null){
            return null;
        }
        RandomListNode newHead = new RandomListNode(pHead.label);
        RandomListNode headP = pHead;
        RandomListNode headNew = newHead;
        Map<RandomListNode,RandomListNode> map = new HashMap<>();
        //添加数据到map中
        while (pHead != null){
            map.put(pHead,new RandomListNode(pHead.label));
            pHead = pHead.next;
        }
        pHead = headP;
        while (pHead != null){
            newHead.next = map.get(pHead.next);
            newHead.random = map.get(pHead.random);
            newHead = newHead.next;
            pHead = pHead.next;
        }
        return headNew;


//        //保存头节点
//        RandomListNode head = pHead;
//        RandomListNode nHead = newHead;
//        //处理next
//        while (pHead.next != null){
//            newHead.next = new RandomListNode(pHead.next.label);
//            newHead = newHead.next;
//            pHead = pHead.next;
//        }
//        pHead = head;
//        newHead = nHead;
//        head = newHead;
//        //处理random
//        while (pHead != null){
//            //从头开始遍历
//            RandomListNode temp = head;
//            while (temp.label != pHead.random.label){
//                temp = temp.next;
//            }
//            //找到random
//            newHead.random = temp;
//            newHead = newHead.next;
//            pHead = pHead.next;
//        }
//        return head;


    }

}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
