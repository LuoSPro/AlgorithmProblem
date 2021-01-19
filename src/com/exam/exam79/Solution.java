package com.exam.exam79;

public class Solution {

    private boolean[][] marked;

    //        x-1,y
    // x,y-1  x,y    x,y+1
    //        x+1,y
    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    // 盘面上有多少行
    private int m;
    // 盘面上有多少列
    private int n;
    private String word;
    private char[][] board;

    public boolean exist(char[][] board, String word) {
        //行数
        m = board.length;
        if (m == 0) {
            return false;
        }
        //列数
        n = board[0].length;
        //标记是否访问过
        marked = new boolean[m][n];
        this.word = word;
        this.board = board;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //遍历，从第一个位置开始查找，如果没有找到，就继续下一个位置
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int start) {
        //当匹配的是word的最后一个字符串时，根据最后一个字符串是否相等来判断word和board是否匹配
        if (start == word.length() - 1) {
            return board[i][j] == word.charAt(start);
        }
        //如果当前word的第start个字符和board的i行。j列的元素相等，就按照这个从上、右、下、左四个方向查找
        if (board[i][j] == word.charAt(start)) {
            //标记当前位置已经访问过，在下一个位置的时候查找时，忽略已经访问过的点
            marked[i][j] = true;
            //direction可以控制访问四个方向
            for (int k = 0; k < 4; k++) {
                int newX = i + direction[k][0];
                int newY = j + direction[k][1];
                //当newX和newY的范围正确并该位置没访问时，递归继续按那个坐标查找
                if (inArea(newX, newY) && !marked[newX][newY]) {
                    //如果匹配了，那么返回匹配
                    if (dfs(newX, newY, start + 1)) {
                        return true;
                    }
                }
            }
            //当当前路径查找不成功时，把访问标志取消
            marked[i][j] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {

//        char[][] board =
//                {
//                        {'A', 'B', 'C', 'E'},
//                        {'S', 'F', 'C', 'S'},
//                        {'A', 'D', 'E', 'E'}
//                };
//
//        String word = "ABCCED";


        char[][] board = {{'a', 'b'}};
        String word = "ba";
        Solution solution = new Solution();
        boolean exist = solution.exist(board, word);
        System.out.println(exist);
    }
}