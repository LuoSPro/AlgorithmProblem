package com.niuke.jz33;

import java.util.Arrays;

/**
 * 题目描述
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * 示例1
 * 输入
 * 复制
 * 7
 * 返回值
 * 复制
 * 8
 *
 */
public class Main {

    public static void main(String[] args) {
        int index = 7;
        System.out.println(new Main().GetUglyNumber_Solution(index));
    }

    /**
     * 列举了一下丑数： 1 2 3 4 5    6 8 9 10 12 13
     * 其实就是基于 2  3  5 的组合来判断的，这个和硬币分配的解法类似
     *
     * 但是这道题要求的是第几个数，而不是判断这个数是不是，所以需要我们把所有的丑数求出来
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution(int index) {
//        int[] arr = new int[index];
//        //前五个
//        for (int i = 0; i < 5; i++) {
//            arr[i] = i+1;
//        }
//        if (index <= 5){
//            return arr[index-1];
//        }
//        //开始根据前面的数来组合后面的数
//        int k = 4;
//        for (int i = 0; arr.length != index; i++) {
//            for (int j = 0; arr.length != index; j++) {
//                for (int l = 0; arr.length != index; l++) {
//                    arr[k++] = 5*i+3*j+2*l;
//                }
//            }
//        }

        if (index <= 0){
            return 0;
        }
        //我那样求不出来的，因为不能保证顺序嘛，而且可能先把大数存进去了，再存小的
        //网上的思路还不错，牛逼
        int[] arr = new int[index];
        int x = 0, y = 0, z = 0;//表示2 3 5 每一个用到第几个了
        int k = 1;
        arr[0] = 1;
        while (k < index){
            //由于arr里面的都是丑数，所以用arr里面的丑数去乘以 2 3 5，得到的都是丑数，不过这里需要求他们的最小值
            arr[k] = Math.min(2*arr[x],Math.min(3*arr[y],5*arr[z]));
            //如果当前的丑数能被2整除，那么为了下一轮是新的丑数，要把x+1，而丑数不能被2整除，说明此事的arr[x]还没被用
            if (arr[k] % 2 == 0) x++;
            if (arr[k] % 3 == 0) y++;
            if (arr[k] % 5 == 0) z++;
            k++;
        }
        return arr[index-1];
    }

}
