package com.niuke.jz24;

import javax.print.attribute.standard.NumberUp;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * 题目描述
 * 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * 示例1
 * 输入
 * 复制
 * {10,5,12,4,7},22
 * 返回值
 * 复制
 * [[10,5,7],[10,12]]
 * 示例2
 * 输入
 * 复制
 * {10,5,12,4,7},15
 * 返回值
 * 复制
 * []
 *
 */
public class Main {

    public static void main(String[] args) {
        TreeNode root= new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(12);
        int target = 22;
        ArrayList<ArrayList<Integer>> lists = new Main().FindPath(root, target);
        for (ArrayList<Integer> list : lists) {
            for (Integer item : list) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

    /**
     * 思路：
     * 我觉得这个要用到动态规划，因为会涉及到很多重复的计算。
     *
     * @param root
     * @param target
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        dfs(lists,list,root,target);
        return lists;
    }

    private void dfs(ArrayList<ArrayList<Integer>> lists, ArrayList<Integer> list, TreeNode root, int target) {
        if (root == null){
            return;
        }
        //结束条件:如果该节点的值已经比target大了，那么就不需要再继续往下了（剪枝）
        if (root.val == target){
            //此时相等了，还要判断是否是叶子节点
            if (root.left == null&&root.right == null){
                //符合
                list.add(root.val);
                lists.add(new ArrayList<>(list));
                list.remove((Integer)root.val);
            }
        }else if(root.val < target){
            list.add(root.val);
            //继续网下找
            dfs(lists, list, root.left, target - root.val);
            dfs(lists, list, root.right, target - root.val);
            list.remove((Integer)root.val);
        }

    }

}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
