package com.exam.exam85;

import java.util.Stack;

/**
 *85. 最大矩形
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：6
 * 解释：最大矩形如上图所示。
 * 示例 2：
 *
 * 输入：matrix = []
 * 输出：0
 * 示例 3：
 *
 * 输入：matrix = [["0"]]
 * 输出：0
 * 示例 4：
 *
 * 输入：matrix = [["1"]]
 * 输出：1
 * 示例 5：
 *
 * 输入：matrix = [["0","0"]]
 * 输出：0
 *
 *
 */
public class Main {

    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};

        System.out.println(new Main().maximalRectangle(matrix));
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null) {
            return 0;
        }
        //数据合法性
        int row = matrix.length;
        if (row == 0) {
            return 0;
        }
        int clo = matrix[0].length;
        //获取数据
        int[] height = new int[clo];
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < clo; j++) {
                if (matrix[i][j] == '1') {
                    height[j] = height[j] + 1;
                } else {
                    height[j] = 0;
                }
            }
            max = Math.max(max, workStack(height));
        }
        return max;
    }

    private int workStack(int[] height) {
        //使用单调栈处理
        Stack<Integer> stack = new Stack();
        //添加哨兵
        stack.push(-1);
        int i = 0;
        int max = 0;
        while (i < height.length) {
            while (stack.peek() != -1 && height[stack.peek()] > height[i]) {
                //不满足单调栈，就要出栈
                max = Math.max(max, height[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i++);
        }
        //从后往前再找一下
        while (stack.peek() != -1) {
            max = Math.max(max, height[stack.pop()] * (height.length - stack.peek() - 1));
        }
        return max;
    }
}
