package com.offer.offer04;

public class Solution {

    public static void main(String[] args) {
        int[][] matrix =
                {
                        {1 ,  4,  7, 11, 15},
                        {2 ,  5,  8, 12, 19},
                        {3 ,  6,  9, 16, 22},
                        {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}
                };
        int target = 20;
        System.out.println(new Solution().findNumberIn2DArray(matrix, target));
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        //右上角的数才是一个中位数
        int row = matrix.length,column = matrix[0].length;
        int x = 0,y = column - 1;

        while (x < row && y >= 0){
            int s = matrix[x][y];
            if (s == target){
                return true;
            }else if (s > target){
                y--;
            }else {
                x++;
            }
        }
        return false;
    }
}
