package com.writetenexam.exam_xiecheng.test2;

/**
 * 无限循环小数和有限不循环小数 变分数的解法
 *
 * 假设 n = 0.47777...
 * n*10 =  4.7777...
 * n*100 = 47.7777...
 * 相减
 *
 * n*(100-10) = 43
 * n = 43/90
 *
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(build("0.25(285714)"));
    }

    //求最大公约数
    public static int gcd(int a,int b){
        if (b == 0){
            return a;
        }
        return gcd(b,a%b);
    }

    //求无限小数的分数形式
    public static String build(String numStr){
        //分子
        int x = 0;
        //分母
        int y;
        //分子的放大倍数
        int xMul = 1;
        int i;
        for (i = 2;i< numStr.length()&&numStr.charAt(i) != '(';i++){
            //小数点后不循环的部分
            x = x*10 + numStr.charAt(i)-'0';
            //每次向前移动一位，数字扩大10倍
            xMul *= 10;
        }
        y = x;
        //分母的放大倍数
        int yMul = xMul;
        if (numStr.charAt(i) != '('){
            //不是无限循环小数,，而是把有限小数遍历完了，就直接求最大公约数化简即可
            int n = gcd(x,xMul);
            //返回有限不循环小数的分数形式
            return x/n + "/" + xMul/n;
        }
        //是无限不循缓小数，处理 循环数 部分
        for(i++;numStr.charAt(i) != ')';i++){
            //把循环部分也扩大n倍，到时候和之前的a值相减，就能得到
            y = y*10 + numStr.charAt(i) - '0';
            yMul *= 10;
        }
        //相减得到差值
        x = y - x;
        xMul = yMul - xMul;
        //求最大公约数
        int n = gcd(x,xMul);
        return x/n + "/" + xMul/n;
    }

}
