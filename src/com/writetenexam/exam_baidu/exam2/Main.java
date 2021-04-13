package com.writetenexam.exam_baidu.exam2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //男M，女F
        Scanner sc = new Scanner(System.in);
        int row = 0;
        int clo = 0;
        try {
            row = sc.nextInt();
            clo = sc.nextInt();
        } catch (Exception e) {
            //不合法数据
            System.out.println("0");
            return;
        }
        char[][] arr = new char[row][clo];
        for (int i = 0; i < row; i++) {
            String str = sc.nextLine();
            if (str.length() == 0){
                i--;
                continue;
            }
            //不合法数据
            if (str.length() > clo){
                System.out.println("0");
                return;
            }
            for (int j = 0; j < clo; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        System.out.println(work(arr,row,clo));
        sc.close();
    }

    /**
     * 思路：我觉得可以采用深搜，不过我这里不加上动态规划的话，可能会超时
     * @param arr
     * @param row
     * @param clo
     * @return
     */
    private static int work(char[][] arr, int row, int clo) {
        //保存已经走过的路
        int[] dp = new int[row*clo];
//        dfs(arr,row,clo,0,0,dp);
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < clo; j++) {
                if (arr[i][j] == 'M'){
                    //男的
                    int result = search(arr, row, clo, i, j,dp);
                    if (result > max){
                        max = result;
                    }
                }
            }
        }
        return 1;
    }

    private static int search(char[][] arr, int row, int clo, int x, int y,int[] dp) {
        if (arr[x][y] == 'F'||dp[x*clo+y] == 1){
            return 0;
        }
        int left = 0,down = 0,right = 0,up = 0;
        dp[x*clo + y] = 1;
        if (y+1 < clo){
            //右走
            right = search(arr, row, clo, x, y+1,dp);
        }
        if (x+1 < row){
            //下走
            down = search(arr, row, clo, x+1, y,dp);
        }
        if (y-1 >= 0){
            //左走
            left = search(arr, row, clo, x, y-1,dp);
        }
        if (x-1 >= 0){
            //上走
            up = search(arr, row, clo, x-1, y,dp);
        }
        dp[x*clo + y] = 0;
        if (left == 0||down == 0){
            return 0;
        }
        if (left - right >= 0&&down-up >= 0){
            return left*down;
        }
        return 0;
    }

//    private static int dfs(char[][] arr, int row, int clo, int x, int y,int dp) {
//        if (arr[x][y] == 'F'){
//            //女生
//
//        }
//        if (y+1 > clo){
//            //右走
//            dfs(arr, row, clo, x, y++);
//        }
//        if (x+1 > row){
//            //下走
//            dfs(arr, row, clo, x++, y);
//        }
//        if (y-1 < 0){
//            //左走
//            dfs(arr, row, clo, x, y--);
//        }
//        if (x-1 < 0){
//            //上走
//            dfs(arr, row, clo, x--, y);
//        }
//        //操作数据
//
//    }

}
