package com.exam.exam79;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import static sun.plugin2.os.windows.OVERLAPPED.size;

public class Main {
    public static void main(String[] args) {
        char[][] board =
        {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "ABCCED";
        System.out.println(new Main().exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int column = board[0].length;
        boolean[][] flag = new boolean[row][column];
        int[][] direction = {{-1,0},{0,1},{1,0},{0,-1}};
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (searchWord(board,word,flag,direction,i,j,row,column,0)){
                    return true;
                }
            }
        }
        return false;

    }

    private boolean searchWord(char[][] board,String word,boolean[][] flag,int[][] direction,int i,int j,int row,int column,int cur){
        //当为最后一个字符时
        if (cur == word.length() - 1){
            return word.charAt(cur) == board[i][j];
        }
        //不是最后一个字符，但当前的相等，去寻找下一位
        if (word.charAt(cur) == board[i][j]){
            //表示该点已经访问
            flag[i][j] = true;
            for (int k = 0; k < direction.length; k++) {
                int newI = i+direction[k][0];
                int newJ = j+direction[k][1];
                if (newI < row && newJ < column && newI >= 0 && newJ >= 0&& !flag[newI][newJ]){
                    if (searchWord(board, word, flag, direction, newI, newJ, row, column, cur+1)){
                        return true;
                    }
                }
            }
            flag[i][j] = false;
        }
        return false;
    }
}
