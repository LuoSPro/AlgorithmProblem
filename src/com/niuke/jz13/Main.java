package com.niuke.jz13;

/**
 *
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 */
public class Main {

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        new Main().reOrderArray(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    /**
     * 最简单的办法，把数组分开，再合并不就好了吗
     * @param array
     */
    public int[] reOrderArray(int [] array) {

        if (array==null||array.length == 0){
            return array;
        }
        int[] pre = new int[array.length];
        int[] end = new int[array.length];
        int x = 0, y = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0){
                //偶数，放后面
                end[x++] = array[i];
            }else {
                //奇数
                pre[y++] = array[i];
            }
        }
        //合并
        for (int i = y,j=0; i < pre.length; i++,j++) {
            pre[i] = end[j];
        }

        return pre;
    }

    /**
     * 思路：
     * 感觉这个和快排的思想差不多，就是对换前后奇数偶数的位置，但是有一个条件好像不对。就是得保证相对位置不发生改变。
     * 如果考虑简单一点的话，就使用两个数组分别存储奇数和偶数，这样时间复杂度为O(n)，空间复杂度也为O(n)
     *
     * 有没有其他的思路呢，把空间复杂度降低的办法
     * 突然想到，我们刚开始想用快排的做法，快排是从两边向中间靠拢，那我们直接从中间向两边靠拢不就好啦，
     * 这样的话，时间复杂度O(log n)，空间复杂度O(1)。可能这就是面试官想要的答案吧
     *
     * @param array
     */
//    public void reOrderArray(int [] array) {
//        if (array == null||array.length == 0){
//            return;
//        }
//        int mid = array.length / 2;
//        int l = mid-1,r  = mid;
//        while (l >= 0 || r <= array.length){
//            while (array[l]%2 == 1){//奇数
//                l--;
//            }
//            while (array[r]%2 == 0){//奇数
//                r++;
//            }
//            //交换
//            int temp = array[l];
//            array[l] = array[r];
//            array[r] = temp;
//            l--;
//            r++;
//        }
//    }
}
