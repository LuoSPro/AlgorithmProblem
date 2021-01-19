package com.exam.exam501;

import java.util.ArrayList;
import java.util.List;

/**
 * 这道题，我思路是正确的，但是理解错了题，以为是记录二叉树中的下标（太SB了），所以一直想着怎么一边记录值，一边记录下标
 * 还有就是细节的问题，我当初疑惑的点，是cur指针什么时候刷新，其实只要当发生一个值与下一个值不一样时就刷新，一样则不管
 * 还有就是当计数器大于最大值时，应该将list清空
 */
public class Solution {
    public static void main(String[] args) {

    }

    private List<Integer> list = new ArrayList<>();
    private int cur = 0;
    private int curCount = 0;
    private int maxCount = 0;

    public int[] findMode(TreeNode root) {
        inOrderTraversal(root);
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public void inOrderTraversal(TreeNode node){
        if (node == null){
            return;
        }
        inOrderTraversal(node.left);

        //处理
        if (cur == node.val){
            curCount++;
        }else{
            curCount = 1;
            cur = node.val;
        }

        if (curCount > maxCount){
            list.clear();
            list.add(cur);
            maxCount = curCount;
        }else if (curCount == maxCount){
            list.add(cur);
        }
        inOrderTraversal(node.right);
    }
}
