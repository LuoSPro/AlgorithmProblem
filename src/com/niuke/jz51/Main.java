package com.niuke.jz51;

import java.util.Arrays;

/**
 * 题目描述
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 * 对于A长度为1的情况，B无意义，故而无法构建，因此该情况不会存在。
 * 示例1
 * 输入
 * 复制
 * [1,2,3,4,5]
 * 返回值
 * 复制
 * [120,60,40,30,24]
 */
public class Main {

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(new Main().multiply(A)));
    }

    /**
     * 思路：
     * 由于中间涉及到多次重复的计算，所以应该采用动态规划法，将结果的组合算出来。
     * 首先要建立一个 n*n 的矩阵，然后对其下三角进行赋值，但是由于运算的特殊性，其实只用到了下三角的直角边上的结果
     *
     * @param A
     * @return
     */
    public int[] multiply(int[] A) {
        //建立下三角矩阵
        int len = A.length;
        int[][] result = new int[len][len];
        //初始化矩阵
        for (int i = 0; i < len; i++) {
            result[i][i] = A[i];
        }
        //运算,第一列
        for (int i = 1; i < len; i++) {
            result[i][0] = result[i][i] * result[i - 1][0];
        }
        //运算，最后一行
        for (int i = len - 2; i >= 1; i--) {
            result[len - 1][i] = result[len - 1][i + 1] * result[i][i];
        }
        //计算结果
        int[] B = new int[len];
        //单独计算B[0],最左下角的数
        B[0] = result[len-1][0];
        //计算B[n-1]
        B[len-1] = result[len-2][0];
        for (int i = 1; i < len-1; i++) {
            B[i] = result[i-1][0]*result[len-1][i+1];
        }
        return B;
    }
}
