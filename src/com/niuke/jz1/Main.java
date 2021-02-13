package com.niuke.jz1;

/**
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 示例1
 * 输入
 * 复制
 * 7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
 * 返回值
 * 复制
 * true
 */
public class Main {

    public static void main(String[] args) {
        int target = 0;
        int[][] array = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
//        int[][] array = {{1},{1},{1}};
        System.out.println(new Main().Find(target, array));
    }

    /**
     * 思路：
     * 一看题就很熟悉，好像之前做到过，当然，解法也很简单，从右下角最大的元素开始查，或者从左上角最小的元素开始查都可以。
     * 然后按照规则：我们从最小的开始查（即左上角）
     * 先按照列来比较，如果遇到比target大的数，就切换到该位置的右上角去比较，如果还大，就按照列递减。——基本是这个思路
     * <p>
     * <p>
     * <p>
     * 题解：
     * 这道题确实要用二分查找的思想，虽然我们的做法以及很类似了，但是还是不是最优的。之所以叫做二分，是因为我们每次都取中间值和他比较
     * 上面的思路是从小到大进行遍历，节约了部分时间开销，但是还是会比二分多m的时间。二分O(n+m)  我们的思路:O(n+m+m)
     * 所以正确的做法是从右上角触发，因为该对角线上面的数都是整行的二分结果。
     *
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int[][] array) {

        int row = array.length;
        if (row == 0) {
            return false;
        }
        int column = array[0].length;
        if (column == 0) {
            return false;
        }
        int r = 0, c = column - 1;
        //行小于总的行数，列大于0
        while (r < row && c >= 0){
            if (array[r][c] == target){
                return true;
            }else if (array[r][c] > target){
                //该位置的数比target大，应该在该行的的左边找(从左往右递增)
                c--;//列--
            }else{
                //比target小，应该在该列的下边找（从上往小递增）
                r++;
            }
        }
        return false;

        //正能通过13/17个例子，菜啊
//        int row = array.length;
//        int i = 0,j = 0;
//        while (true) {
//            if (j < 0 || j >= array[0].length || i >= row){
//                return false;
//            }
//            if (array[i][j] == target) {
//                //找到了
//                return true;
//            } else if (array[i][j] > target) {
//                //同行比target大之后，就要换该位置的左下方方做比较
//                i++;
//                j--;
//            } else {
//                if (j == array[i].length - 1 && i < row - 1){
//                    i++;
//                }else {
//                    j++;
//                }
//            }
//        }
//    }

    }
}
