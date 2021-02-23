package com.niuke.jz19;

import com.sun.org.apache.bcel.internal.generic.ALOAD;

import java.util.ArrayList;

/**
 * 题目描述
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * 示例1
 * 输入
 * 复制
 * [[1,2],[3,4]]
 * 返回值
 * 复制
 * [1,2,4,3]
 */
public class Main {

    public static void main(String[] args) {
        int[][] matrix = new int[3][5];
//        int[][] matrix = {{1}};
//        int[][] matrix = {{1}, {2}, {3}, {4}, {5}};
//        int[][] matrix = {{1, 2, 3, 4, 5}};
        int num = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = num++;
            }
        }
        for (Integer integer : new Main().printMatrix(matrix)) {
            System.out.println(integer);
        }
    }

    /**
     * 思路：
     * 这道题大一就遇到过，能想到的办法就是暴力破解,但是好麻烦啊
     *
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList();
        if (matrix == null) {
            return list;
        }
        //只有一行
        if (matrix.length == 1){
            for (int i = 0; i < matrix[0].length; i++) {
                list.add(matrix[0][i]);
            }
        }
        //只有一列
        if (matrix[0].length == 1&&list.size() == 0){
            for (int i = 0; i < matrix.length; i++) {
                list.add(matrix[i][0]);
            }
        }
        //提前返回值
        if (list.size() != 0){
            return list;
        }
        int top = 0, left = 0;
        int right = matrix[0].length - 1, bottom = matrix.length - 1;
        int temp;
        while (right >= left && top <= bottom) {
            temp = left;
            //四条边分别遍历
            while (temp < right) {
                list.add(matrix[top][temp]);
                temp++;
            }
            temp = top;
            //保证下标合理性
            while (temp < bottom) {
                list.add(matrix[temp][right]);
                temp++;
            }
            temp = right;
            //如果只有一行就不需要再反向输出了
            while (temp > left && matrix.length != 1) {
                list.add(matrix[bottom][temp]);
                temp--;
            }
            temp = bottom;
            while (temp > top && matrix[0].length != 1) {
                list.add(matrix[temp][left]);
                temp--;
            }
            //走完一圈
            left++;
            right--;
            top++;
            bottom--;
        }
        //奇数矩阵
        if (matrix.length == matrix[0].length &&matrix.length % 2 == 1) {
            //没有添加最中间的那个数
            list.add(matrix[matrix.length / 2][matrix[0].length / 2]);
        }
        return list;
    }

}
