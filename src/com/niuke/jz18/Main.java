package com.niuke.jz18;

/**
 * 题目描述
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 *
 */
public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);
        new Main().Mirror(root);
        System.out.println(root);
    }

    public void Mirror(TreeNode root) {
        if (root == null){
            return;
        }
        dfs(root);
    }

    private void dfs(TreeNode root) {
        if (root.left == root.right){
            //两个都为null的时候，不再往下继续了
            return;
        }
        //交换
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        //继续往下
        if (root.left != null){
            //不为null
            dfs(root.left);
        }
        if (root.right != null){
            //不为null
            dfs(root.right);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
