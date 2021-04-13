package com.writetenexam.exam_xiecheng.test2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] arrStr = s.split("\\+");
        float[] data = new float[arrStr.length];
        StringBuilder isFloat = new StringBuilder();
        StringBuilder exp = new StringBuilder();
        for (int i = 0,k=0; i < arrStr.length; i++) {
            if (!isTrue(arrStr[i],isFloat)){
                System.out.println("Invalid Expression");
                return;
            }else {
                if (isFloat.length() != 0){
                    //无限循环小数
                    exp.append(build(arrStr[i])+"+");
                }else{
                    float num = Float.parseFloat(arrStr[i]);
                    if (num - (int)num > 0){
                        //有限小数
                        exp.append(build(num+"")+"+");
                    }else{
                        //整数
                        exp.append((int)num + "+");
                    }
                }
            }
        }
        exp.substring(0,exp.length()-1);
        System.out.println(exp);
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
        if (i<numStr.length()){
            i--;
        }
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

    private static boolean isTrue(String s,StringBuilder isFloat) {
        //判断是否是一个合法的数
        if (s == null || s.length() == 0){
            return false;
        }
        char c = s.charAt(0);
        if (s.length() == 1){
            if (c >= '1' && c <= '9'){
                return true;
            }
            return false;
        }
        //不止一位数
        if (c == '0'){
            if (s.charAt(1) != '.') {
                return false;
            }else if (s.length() == 2 && s.charAt(1) == '.'){
                return false;
            }
        }
        char t = ' ';
        //保证最后一位是 ')'
        boolean flag = false;
        for (int i = 2; i < s.length(); i++) {
            //考虑无限循环的情况
            t = s.charAt(i);
            if (t=='('&&s.charAt(s.length()-1) == ')' || flag){
                isFloat.append("(");
                flag = true;
            }else if (!(c >= '0' && c <= '9')){
                return false;
            }
        }
        return true;
    }


}
