package com.niuke.jz40;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目描述
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *
 */
public class Main {

    public static void main(String[] args) {
        int [] array = {1,3,5,7,9,2,1,3,5,7,8,9};
        int num1[] = new int[1];
        int num2[] = new int[1];
        new Main().FindNumsAppearOnce(array,num1,num2);
        System.out.println(num1[0] + "   " + num2[0]);
    }

    /**
     * 思路：
     * 之前好像遇到过这种问题，当时说的叫xxx抵消法，用的就是 位运算的^(异或：相同为0，不同为1) 来做的
     *
     * 但是这里有两个数，最后就不能区分开这两个数，这就比较烦
     * 暂时不知道怎么处理，所以就先用一个hashset吧
     *
     *
     *
     * 题解：
     * 虽然hash过了，但是还是觉得位运算好一点，所以看了题解，还不错，基本思路就是 异或 运算处理，不过，在得到两个不同的数的异或结果后，
     * 需要有技巧去把这两个数拆分开，拆分的方法就是：结果的位上的1，肯定是两个数0，1异或运算造成的，我们找到结果位上的1，再拿到数组里面去遍历做异或运算，最终
     * 就能找到其中的一个数了，再次异或得到第二个数
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {

        int res = 0;
        //全部异或一遍
        for (int i : array) {
            res ^= i;
        }
        //此时的res是两个数异或的结果
        //找出res位为1的位置
        int index = res&(-res);
        //再次异或(这次基本是对每个数字都要操作一遍了，即基本每个数字都要先放到num1或num2中)
        for (int i : array) {
            int temp = index & i;
            if (temp == 0){
                num1[0] ^= i;
            }else{
                num2[0] ^= i;
            }
        }



//        Set<Integer> set = new HashSet<>();
//        for (int i : array) {
//            if (set.contains(i)){
//                set.remove(i);
//            }else {
//                set.add(i);
//            }
//        }
//        boolean flag = true;
//        for (Integer item : set) {
//            if (flag){
//                num1[0] = item;
//                flag = false;
//            }else{
//                num2[0] = item;
//            }
//        }
    }

}
