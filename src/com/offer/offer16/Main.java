package com.offer.offer16;


/**
 * 快速幂：
 *
 * 循环      表达式( x^n * res)
 * 0         3^5 * (1)
 * 1         9^2 * (1*3)
 * 2         81^1 * (1*3)
 * 3         6561^0 * (1*3*81)
 *
 *
 * 最终的值就是 1*3*81，即res的值
 * 这个其实和把x相乘n次差不多，不过由于每次都是把n/2，来计算，所以最终的时间复杂度就是 log2 n
 *
 *
 * 不过还有一个比较特殊的点，就是 x^(-n) 和 1/x ^ n 的转换，这是我没想到的
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(new Main().myPow(2.10000, 3));
    }

    public double myPow(double x, int n) {
        //防止下面的1/x报错
        if (x == 0){
            return 0;
        }
        //假设x初始为 x*res  -->  x*1
        double res = 1;
        //防止出现大数的情况，先用long保存
        long b = n;
        //把x^(-n)   -->   1/x ^ n
        if (b < 0){
            x = 1/x;
            b = -b;
        }
        //由于我们会把  (x^t)^b  最终变成  (x^t)^0 ,所以我们不在乎x的值，而是在乎当b=0时，(x^t)^0 = 1,res的值就是最终的值
        while (b != 0){
            if ((b&1) == 1){
                //当b为奇数时，为了向下取整，会多出一个x，这个时候，我们把它乘到res上去
                res *= x;
            }
            //x的值继续变化,成倍似的增长
            x *= x;
            //把b的值右移一位，删掉最后一位数字
            b >>= 1;
        }
        return res;
    }

}
