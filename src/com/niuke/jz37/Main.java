package com.niuke.jz37;

/**
 * 题目描述
 * 统计一个数字在升序数组中出现的次数。
 * 示例1
 * 输入
 * 复制
 * [1,2,3,3,3,3,4,5],3
 * 返回值
 * 复制
 * 4
 */
public class Main {

    public static void main(String[] args) {
        int[] array = {3, 3, 3, 3, 4, 5};
        int k = 3;
        System.out.println(new Main().GetNumberOfK(array, k));
    }

    /**
     * 思路：想要快速的查询，用二分法最佳，找到后，直接前后一起统计
     *
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK(int[] array, int k) {
        //二分查找
        int low = 0;
        int high = array.length - 1;
        int mid = 0;
        int count = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (array[mid] < k) {
                low = mid + 1;
            } else if (array[mid] > k) {
                high = mid - 1;
            } else {
                count++;
                break;
            }
        }
        //没找到
        if (count == 0) {
            return 0;
        }
        low = mid-1;
        while (low >= 0 && array[low] == k) {
            count++;
            low--;
        }
        high = mid+1;
        while (high < array.length && array[high] == k) {
            count++;
            high++;
        }
        return count;
    }
}
