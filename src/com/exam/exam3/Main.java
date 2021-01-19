package com.exam.exam3;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        System.out.println(lengthOfLongestSubstring(str));
    }

    /**
     * 暴力解法，容易超时
     */
    /*public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <= n; j++) {
                if (allUnique(s,i,j)){
                    max = Math.max(max,j-i);
                }
            }
        }
        return max;
    }

    public static boolean allUnique(String s,int start,int end){
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character character = s.charAt(i);
            if (set.contains(character))
                return false;
            set.add(character);
        }
        return true;
    }*/

    /**
     * 滑动窗口
     */
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int max = 0,i=0,j=0;
        while (i<n && j<n){
            Character c = s.charAt(j);
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                max = Math.max(max,j-i);
            }else{
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }
}
