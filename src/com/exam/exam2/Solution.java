package com.exam.exam2;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] strArr = str.split("\\+");
        byte[] str1 = strArr[0].getBytes();
        byte[] str2 = strArr[1].getBytes();
        ListNode firstNode = new ListNode(-1);
        ListNode nodeOne = firstNode;
        for (int i = 0; i < str1.length; i++) {
            if (str1[i]>='0'&&str1[i]<='9'){
                ListNode node = new ListNode(str1[i]-'0');
                nodeOne.next = node;
                nodeOne = node;
            }
        }

        ListNode secondNode = new ListNode(-1);
        nodeOne = secondNode;
        for (int i = 0; i < str2.length; i++) {
            if (str2[i]>='0'&&str2[i]<='9'){
                ListNode node = new ListNode(str2[i]-'0');
                nodeOne.next = node;
                nodeOne = node;
            }
        }

        ListNode thirdNode = new ListNode(-1);
        nodeOne = thirdNode;
        nodeOne.next = null;
        int flag = 0;
        firstNode=firstNode.next;
        secondNode=secondNode.next;
        for (; firstNode!=null||secondNode!=null;) {
            ListNode node = new ListNode(-1);
            int num1 = 0;
            if (firstNode!=null){
                num1 = firstNode.val;
                firstNode=firstNode.next;
            }
            int num2 = 0;
            if (secondNode!=null){
                num2 = secondNode.val;
                secondNode=secondNode.next;
            }
            if (num1+num2+flag>9){
                node.val = num1 + num2 + flag - 10;
                flag = 1;
            }else{
                node.val = num1 + num2 + flag;
                flag = 0;
            }

            //尾插法
            nodeOne.next = node;
            nodeOne = node;

            //头插法
//            node.next = nodeOne.next;
//            nodeOne.next = node;
        }

        if (flag == 1){
            ListNode node = new ListNode(1);
            nodeOne.next = node;
            nodeOne = node;
        }
//
//        while(firstNode!=null){
//            nodeOne.next = firstNode;
//            nodeOne = firstNode;
//            firstNode = firstNode.next;
//        }
//
//        while(secondNode!=null){
//            nodeOne.next = secondNode;
//            nodeOne = secondNode;
//            secondNode = secondNode.next;
//        }

        thirdNode = thirdNode.next;
        for (;thirdNode!=null;thirdNode=thirdNode.next) {
            System.out.print(thirdNode.val);
            if (thirdNode.next != null){
                System.out.print(" -> ");
            }
        }

//        LinkedList<Integer> list1 = new LinkedList();
//        LinkedList<Integer> list2 = new LinkedList();
//        for (int i = 0; i < str1.length; i++) {
//            if (str1[i]>='0'&&str1[i]<='9'){
//                list1.addFirst(str1[i]-'0');
//            }
//        }
//        for (int i = 0; i < str2.length; i++) {
//            if (str2[i]>='0'&&str2[i]<='9'){
//                list2.addFirst(str2[i]-'0');
//            }
//        }

//        LinkedList<Integer> list = new LinkedList();
//        for (int i = 0; i < list1.size()&&i<list2.size(); i++) {
//            int num = 0;
//            int num1 = (int)list1.get(list1.size()-1-i)-'0';
//            int num2 = (int)list2.get(list2.size()-1-i)-'0';
//            if (num1+num2>9){
//                int x = list1.size()-i-2;
//                list1.set(list1.size()-i-2, (char) (list1.get(list1.size()-2-i)+'1'-'0'));
//                list.add(num1+num2-10);
//            }else{
//                list.add(num1+num2);
//            }
//        }
//        for (int i = 0; i < list.size(); i++) {
//            System.out.print(list.get(i));
//            if (i != list.size()-1){
//                System.out.print(" -> ");
//            }
//        }

    }
}

/**
 * (9 -> 8) + (1)
 * (2) + (9)
 * (5) + (5)
 * (9 -> 9) + (1)
 */
