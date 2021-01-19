package com.exam.exam15;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Main().hammingWeight(00000000000000000000000000001011));
    }

    public int hammingWeight(int n) {
//        //1、利用Java得语言特性
//        return Integer.bitCount(n);

//        //2、位运算
//        int count = 0;
//        while (n != 0){
//            count += n&1;
//            n >>>= 1;
//        }
//        return count;

        //3、利用n&(n-1)
        int res = 0;
        while(n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
//        int count = 0;
//        while (n != 0){
//            if (n%10 == 1){
//                count++;
//            }
//            n /= 10;
//        }
//        return count;
    }
}
