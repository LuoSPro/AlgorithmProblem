package com.exam.exam37;

import java.util.ArrayList;
import java.util.List;

class Solution {
    //储存行每一行存在的数字
    boolean[][] line = new boolean[9][9];
    //储存行每一列存在的数字
    boolean[][] col = new boolean[9][9];
    //将格子分为9块储存行每一块存在的数字
    boolean[][][] block = new boolean[3][3][9];
    //将空格子储存
    List<int[]> list = new ArrayList<>();
    //找到结果
    boolean success = false;

    public void solveSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                //保存空格的位置，方便后面直接将0~9放入这些空格做检验
                if (board[i][j] == '.')
                    list.add(new int[]{i, j});
                else{
                    //将数字储存
                    //数字1~9，储存0~8
                    //0~8:因为9x9的表格，最大下标是8
                    int num = board[i][j] - '0' - 1;
                    //line[i][num]:第i行的第num个位置不是空格，设置表示true
                    //col[j][num]:第j列第num行的位置不是空格，设置为true
                    //block[i/3][j/3][num]:第(i/3，j/3)号块下，第num个数字已经存在，设置为true
                    line[i][num] = col[j][num] = block[i/3][j/3][num] = true;
                }
            }
        }
        //开始放数字
        dfs(board, 0);
    }
    
    public void dfs(char[][] board, int index){
        //找到结果
        //根据记录的空格，一个一个去找，如果index都和空格的个数相同时，那么就代表当前的数字没有冲突，直接就是最终答案
        //找到后，success为true，此时不需要再放数字到空格找正确的答案，直接退出当前循环
        if (index == list.size()){
            success = true;
            return;
        }
        //得到空格的横坐标和纵坐标
        int i = list.get(index)[0];
        int j = list.get(index)[1];
        //因为每个位置只能放0~9，所以用每个数字去试，直到找到符合的数字
        //如果success为false，表示未找到，需要继续放置数字到空格，去找到正确的答案
        for (int num = 0; num < 9 && !success; num++){
            //满足条件
            //如果数字没有出现在行、列以及块中都未出现这个值
            if (!line[i][num] && !col[j][num] && !block[i/3][j/3][num]){
                line[i][num] = col[j][num] = block[i/3][j/3][num] = true;
                //如果这个数字没有在三个条件中出现，那么这个数字可作为候补数字去补充，将该数字放到当前位置下
                board[i][j] = (char)('0' + num + 1);
                //然后继续填写下一个空，index+1：下一个空
                dfs(board, index + 1);
                //还原现场
                line[i][num] = col[j][num] = block[i/3][j/3][num] = false;
            }
        }
    }

    public static void main(String[] args) {
        char[][] board  = new char[][]{
                new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        new Solution().solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
    }
}