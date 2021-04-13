package com.niuke.nc108;

public class Main {

    public static void main(String[] args) {
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','1','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(new Main().solveMatrix(matrix));
    }

    /**
     * 暴力解法，之前想到过，但是实现不来
     * @param matrix
     * @return
     */
    public int solve (char[][] matrix) {
        // write code here
        if (matrix == null||matrix.length == 0||matrix[0].length == 0){
            return 0;
        }
        int row = matrix.length;
        int clo = matrix[0].length;
        int maxSize = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < clo; j++) {
                if (matrix[i][j] == '1'){
                    //左上角为1
                    maxSize = Math.max(maxSize,1);
                    //求从这个点出发，最大的矩阵面积
                    int curMaxSize = Math.min(row-i,clo-j);
                    //遍历来验证
                    for (int k = 1; k < curMaxSize; k++) {
                        boolean flag = true;
                        if (matrix[i+k][j+k] == '0'){
                            //先查对角线
                            break;
                        }
                        //再从两边开始查
                        for (int l = 0; l < k; l++) {
                            if (matrix[i][j+l] == '0'||matrix[i+l][j]=='0'||matrix[i+k][j+l] == '0'||matrix[i+l][j+k]=='0'){
                                flag = false;
                                break;
                            }
                        }
                        if (flag){
                            //符合,k+1是因为要加上原先的1，即，当从左上角往两边延申的时候，走一步之后，长方形的边长变成了2
                            maxSize = Math.max(maxSize,k+1);
                        }else {
                            //不符合，跳出循环
                            break;
                        }
                    }
                }
            }
        }
        //返回矩阵的面积
        return maxSize*maxSize;
    }

    /**
     * 暴力解法，之前想到过，但是实现不来
     * @param matrix
     * @return
     */
    public int solveMatrix (char[][] matrix) {
        // write code here
        if (matrix == null||matrix.length == 0||matrix[0].length == 0){
            return 0;
        }
        int row = matrix.length;
        int clo = matrix[0].length;
        int maxX = 0;
        int maxY = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < clo; j++) {
                if (matrix[i][j] == '1'){
                    //左上角为1
                    maxX = Math.max(maxX,1);
                    maxY = Math.max(maxY,1);
                    //求从这个点出发，最大的矩阵面积
                    int curMaxSize = Math.min(row-i,clo-j);
                    //遍历来验证
                    int curX = curMaxSize;
                    int curY = curMaxSize;
                    for (int x = 0; x < curMaxSize; x++) {
                        for (int y = 0; y < curY; y++) {
                            if (matrix[x+i][y+j] == '0'||y+j == curY-1) {
                                curY = Math.min(curY, y);
                                curX = Math.min(curX,x);
                            }else{
                                curX = Math.max(curX,x+1);
                            }
                        }
                    }
                    maxX = Math.max(maxX,curX);
                    maxY = Math.max(maxY,curY);
                }
            }
        }
        //返回矩阵的面积
        return maxX*maxY;
    }

}
