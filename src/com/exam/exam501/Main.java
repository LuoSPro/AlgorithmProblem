package com.exam.exam501;

import java.util.*;

/**
 * 这道题，我思路是正确的，但是理解错了题，以为是记录二叉树中的下标（太SB了），所以一直想着怎么一边记录值，一边记录下标
 * 还有就是细节的问题，我当初疑惑的点，是cur指针什么时候刷新，其实只要当发生一个值与下一个值不一样时就刷新，一样则不管
 * 还有就是当计数器大于最大值时，应该将list清空
 */
public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
    }

    public int[] findMode(TreeNode root) {
        dfs(root);
        int max = 0;
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                int compare = (o1.getValue()).compareTo(o2.getValue());
                return -compare;
            }
        });
        List<Integer> nums = new ArrayList<>();
        int cur;
        int i;
        for (i = 0; i < list.size(); i++) {
            Map.Entry<Integer, Integer> entry = list.get(i);
            nums.add(entry.getKey());
            if (i>0&&list.get(i-1).getValue() != list.get(i).getValue()){
                break;
            }
        }
        Integer[] ints = new Integer[i];
        //return list.toArray(ints);
        return null;
    }

    Map<Integer,Integer> map = new HashMap<>();

    private void dfs(TreeNode node){
        if (node != null){
            dfs(node.right);
            map.merge(node.val, 1, Integer::sum);
            dfs(node.left);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
