package com.offer.offer04;

/**
 * 审题错误，这道题不是找两数之和，而是找一个数字
 */
public class Main {

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
        System.out.println(new Main().findNumberIn2DArray(matrix, target));
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int[] begin = new int[]{0,0};
        int x = matrix.length - 1;
        int y = matrix[0].length - 1;
        int[] end = new int[]{x,y};
        while (!(begin[0]==end[0]&&begin[1]==end[1])){
            int s = matrix[begin[0]][begin[1]] + matrix[end[0]][end[1]];
            if (s < target){
                begin[0] = begin[0] + 1;
                if (begin[0] > y){
                    begin[0] = 0;
                    begin[1] = begin[1] + 1;
                }
            }
            if (s > target){
                end[0] = end[0] - 1;
                if (end[0] < 0){
                    end[0] = y;
                    end[1] = end[1] - 1;
                }
            }
            if (s == target){
                return true;
            }
        }
        return false;
    }
}
