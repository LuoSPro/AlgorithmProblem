package com.niuke.jz6;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * <p>
 * 输入
 * 复制
 * [3,4,5,1,2]
 * 返回值
 * 复制
 * 1
 *
 *
 *
 *
 *
 *
 *
 * 难点：
 * 1. 非递减序列
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,4,5};
        System.out.println(new Main().minNumberInRotateArray(arr));
    }

    public int minNumberInRotateArray(int[] array) {
        //二分法
        int len = array.length;
        int left = 0, right = len - 1;
        int mid;
        while (left < right) {
            mid = (left + right)/2;
            //非递减序列，直接返回最左边的数
            // 1,1,2,4,5,..,7
            if (array[right] > array[left]){
                return array[left];
            }
            //l > m : 说明m在后面的递增序列中
            if (array[left] > array[mid]){
                right = mid;
            }else if (array[right] < array[mid]){//r < m : 说明m在前面的递增序列中
                left = ++mid;
            }else{
                //left = right，避免出现 1 0 1 1的情况
                left++;
            }
        }
        //当left == right 的时候，就找到了中间点
        return array[left];
    }

}
