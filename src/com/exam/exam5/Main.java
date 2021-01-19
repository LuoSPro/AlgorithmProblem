package com.exam.exam5;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        String s = "babad";
        System.out.println(main.longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        //1、判断参数是否合法
        if (s == null || "".equals(s)){
            return s;
        }
        int len = s.length();
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        //2、1字母初始化，si == si肯定为true
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        //3、2字母初始化   P(i,i+1)=(Si==Si+1)
        for (int i = 0; i < len-1; i++) {
            dp[i][i+1] = chars[i] == chars[i+1];
        }
        int left = 0;
        int right = 0;
        //当前最大长度
        int max = 1;
        //4、多字母初始化
        //这里 len-2，因为我们前面做了1初始化和2初始化
        for (int i = len-2; i >= 0; i--) {
            //因为j在i的后面，所以j一定大于i，所以j<i的部分直接不看
            for (int j = i+1; j < len; j++) {
                //判断 P(i,j)=(P(i+1,j−1) and Si==Sj)
                //注：j != i + 1这个判断在这里相当于是减少了一次循环，因为这一次(相邻两个字符)的循环，2字母初始化就做了
                if (j != i + 1){
                    dp[i][j] = dp[i+1][j-1] && chars[i] == chars[j];
                }
                //记录i,j
                if (dp[i][j] && max < j - i + 1){
                    max = j-i+1;
                    left = i;
                    right = j;
                }
            }
        }
        //subString左闭右开
        return s.substring(left,right+1);


        //我的暴力解法
//        String str = "";
//        int sLength = s.length();
//        for (int i = 0,j = 1; j <= sLength; j++) {
//            String tempStr = s.substring(i, j);
//            int strLength = str.length();
//            if (isPalindrome(tempStr) && tempStr.length() > strLength){
//                 str = tempStr;
//             }
//            if (i < j-strLength && j == sLength){
//                i++;
//                j = i;
//            }
//        }
//        return "".equals(str) ? s : str;
    }

    public boolean isPalindrome(String s){
        int length = s.length();
        for (int i = 0; i < length/2; i++) {
            if (s.charAt(i) != s.charAt(length-i-1)){
                return false;
            }
        }
        return true;
    }
}
