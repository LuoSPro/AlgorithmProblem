package com.exam.exam13;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(romanToInt("IV"));
    }

    public static int romanToInt(String s) {
        int preNum = getValue(s.charAt(0));
        int sum = 0;
        for (int i = 1; i < s.length(); i++) {
            int num = getValue(s.charAt(i));
            if (preNum >= num){
                sum += preNum;
            }else{
                sum -= preNum;
            }
            preNum = num;
        }
        return sum + preNum;
    }

    public static int getValue(char ch){
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }


//    public static int romanToInt(String s) {
//        s = s.replace("IV","a");
//        s = s.replace("IX","b");
//        s = s.replace("XL","c");
//        s = s.replace("XC","d");
//        s = s.replace("CD","e");
//        s = s.replace("CM","f");
//        System.out.println(s);
//        Map<Character,Integer> map = new HashMap<>();
//        map.put('I',1);
//        map.put('V',5);
//        map.put('X',10);
//        map.put('L',50);
//        map.put('C',100);
//        map.put('D',500);
//        map.put('M',1000);
//        map.put('a',4);
//        map.put('b',9);
//        map.put('c',40);
//        map.put('d',90);
//        map.put('e',400);
//        map.put('f',900);
//        char[] arr = s.toCharArray();
//        int sum = 0;
//        for (int i = 0; i < arr.length; i++) {
//            sum += map.get(arr[i]);
//        }
//        return sum;
//    }
}
