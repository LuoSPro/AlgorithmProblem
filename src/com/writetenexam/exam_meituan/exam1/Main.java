package com.writetenexam.exam_meituan.exam1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int count = work(str);
        int len = str.length();
        System.out.println((int)(Math.pow(2,len)-(Math.pow(2,count)-count)*(len-count))%20210101);
    }

    private static int work(String str) {
        if (str == null||str.length() == 0){
            return 0;
        }
        int num = 0;
        int count = 1;
        //求重复子序列的长度
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i-1)){
                count++;
            }else if (str.charAt(i) != str.charAt(i-1) && count != 1){
                num += count;
                count = 1;
            }
        }
        return num;
    }


}
