package com.niuke.nc38;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
//        int[][] matrix = {
//                {1,2,3,4},
//                {5,6,7,8},
//                {9,10,11,12},
//                {13,14,15,16}
//        };
        int[][] matrix = {{1},{2},{3}};
        for (Integer integer : new Main().spiralOrder(matrix)) {
            System.out.println(integer);
        }
    }

    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null||matrix.length == 0||matrix[0].length == 0){
            return list;
        }
//        if (matrix.length == 1){
//            for (int i = 0; i < matrix[0].length; i++) {
//                list.add(matrix[0][i]);
//            }
//            return list;
//        }
//        if (matrix[0].length == 1){
//            for (int i = 0; i < matrix.length; i++) {
//                list.add(matrix[i][0]);
//            }
//            return list;
//        }
        int top = 0,left =0;
        int bottom = matrix.length-1,right = matrix[0].length-1;
        while (top < (matrix.length + 1)/2 && left < (matrix[0].length+1)/2){
            //从左往右
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            //从上往下
            for (int i = top+1; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            //从右往左
            for (int i = right-1;top != bottom && i >= left; i--) {
                list.add(matrix[bottom][i]);
            }
            //从下往上
            for (int i = bottom-1;left != right && i >= top + 1; i--) {
                list.add(matrix[i][left]);
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return list;
    }

}
