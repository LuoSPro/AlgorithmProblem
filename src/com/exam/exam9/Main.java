package com.exam.exam9;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        Main mMain = new Main();
        System.out.println(mMain.isPalindrome(x));
    }

//    public boolean isPalindrome(int x) {
//        if (x<0){
//            return false;
//        }
//        byte[] str = String.valueOf(x).getBytes();
//        Stack<Byte> stack = new Stack();
//        Queue<Byte> queue = new LinkedList();
//        for (int i = 0; i < str.length; i++) {
//            stack.push(str[i]);
//            queue.offer(str[i]);
//        }
//        for (int i = 0; i < str.length; i++) {
//            if (stack.pop() != queue.poll()){
//                return false;
//            }
//        }
//        return true;
//    }

//    public boolean isPalindrome(int x) {
//        if (x<0){
//            return false;
//        }
//        byte[] arr = String.valueOf(x).getBytes();
//        int len = arr.length;
//        for (int i = 0; i < len; i++) {
//            if (arr[i] != arr[len-1-i]){
//                return false;
//            }
//        }
//        return true;
//    }

//    public boolean isPalindrome(int x) {
//        if (x<0){
//            return false;
//        }
////        if (Integer.reverse(x) == x)
////            return true;
////        return false;
////    }

//    public boolean isPalindrome(int x) {
//        if (x<0){
//            return false;
//        }
//        int len = String.valueOf(x).length();
//        while (x!=0){
//            if ((int) (x/Math.pow(10,len-1)) != x%10){
//                return false;
//            }
//            x = (int) (x%Math.pow(10,len-1));
//            x /= 10;
//            len -= 2;
//        }
//        return true;
//    }


    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        int cur = 0;
        int num = x;
        while(num != 0) {
            cur = cur * 10 + num % 10;
            num /= 10;
        }
        return cur == x;
    }
}
