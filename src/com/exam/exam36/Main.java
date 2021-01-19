package com.exam.exam36;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        char[][] board  = new char[][]{
                new char[]{'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(main.isValidSudoku(board));
    }

    /**
     * 思路：
     * 由于每行、每列、没个块中，0~9的数字只能出现一次，所以先循环，把一存在的数字的位置设为true
     * 然后再每次设置标识前，先判断是否已经标识过，若已经标识过，则有重复
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        //记录行
        boolean[][] line = new boolean[9][9];
        //列
        boolean[][] column = new boolean[9][9];
        //块
        boolean[][][] block = new boolean[3][3][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!(board[i][j] == '.')){
                    int num = board[i][j] - '0' - 1;
                    //如果已经标识过，则有重复
                    if(line[i][num] == true || column[j][num] == true || block[i/3][j/3][num] == true){
                        return false;
                    }
                    //否则就给该数字所在行、列、块，打标识
                    line[i][num] = column[j][num] = block[i/3][j/3][num] = true;
                }
            }
        }
        //最后都没重复，则返回true
        return true;
    }
}
