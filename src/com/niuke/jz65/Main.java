package com.niuke.jz65;

public class Main {

    public static void main(String[] args) {
        String matrix = "ABCESFCSADEE";
        int rows = 3;
        int cols = 4;
        String str = "ABCCED";
        System.out.println(new Main().hasPath(matrix, rows, cols, str));
    }

    /**
     * 思路：我觉得这个其实和字符串匹配很相似，都是在一段中找匹配。
     * 这里优化是有的，但是我先把基本做出来
     *
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     * @return
     */
    public boolean hasPath(String matrix, int rows, int cols, String str) {
        // write code here
        boolean[] vis = new boolean[rows*cols];
        int[][] arr = new int[rows][cols];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = matrix.charAt(index++);
            }
        }
        return path(arr, str,vis);
    }

    private boolean path(int[][] arr, String str, boolean[] vis) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == str.charAt(0)) {
                    //起点找到了
                    if (searchArr(arr, i, j, str, 1,vis)){
                        return true;
                    }
                }
            }
        }
        //没找打起点
        return false;
    }

    /**
     * 需要解决的问题：不能往回走
     * 用一个boolean数组要好得多
     *   标识上次的位置  1：上  2：下   3：左  4：右
     * @param arr
     * @param x
     * @param y
     * @param str
     * @param index
     * @return
     */
    private boolean searchArr(int[][] arr, int x, int y, String str, int index,boolean[] vis) {
        int visIndex = x * arr[0].length + y;
        if (y >= arr[0].length || x >= arr.length || x < 0 || y < 0||vis[visIndex] == true||arr[x][y] != str.charAt(index - 1)) {
            return false;
        }
        if (index == str.length()) {
            return true;
        }
        //先设置已经访问
        vis[visIndex] = true;
        //四个情况：上下左右
        if (searchArr(arr, x - 1, y, str, index + 1,vis)||
                searchArr(arr, x + 1, y, str, index + 1,vis)||
                searchArr(arr, x, y - 1, str, index + 1,vis)||
                searchArr(arr, x, y + 1, str, index + 1,vis))
            return true;
        //回溯
        vis[visIndex] = false;
        return false;
    }

}
