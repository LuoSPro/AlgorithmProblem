package com.offer.offer43;

public class Main {

    public static void main(String[] args) {
        int n = 12;
//        System.out.println(new Main().countDigitOne(n));
        System.out.println("12".substring(0,1));
    }

    public int countDigitOne(int n) {
        int sum = 0;
        //变成字符串
        String num = n+"";
        //遍历num的每一位
        for (int i = 0; i < num.length(); i++) {
            //取到对应位置上的每一位
            int each = Integer.valueOf(num.substring(i,i+1));
            //判断
            for (int j = 0; j < each; j++) {
//                if ()
            }
        }
        return sum;
    }

}
