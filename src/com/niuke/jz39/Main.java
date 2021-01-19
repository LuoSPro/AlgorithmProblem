package com.niuke.jz39;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 题目描述
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 * 平衡二叉树（Balanced Binary Tree），具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
 * 示例1
 * 输入
 * 复制
 * {1,2,3,4,5,6,7}
 * 返回值
 * 复制
 * true
 *
 */
public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.right = new TreeNode(2);
        System.out.println(new Main().IsBalanced_Solution(root));
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null){
            return true;
        }
        return dfs(root.left)==dfs(root.right);
    }

    public int dfs(TreeNode root){
        int layer = 0;
        if (root == null){
            return layer;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        return dfs(root.left)+1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
