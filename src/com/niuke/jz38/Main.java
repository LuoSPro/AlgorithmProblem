package com.niuke.jz38;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * 示例1
 * 输入
 * 复制
 * {1,2,3,4,5,#,6,#,#,7}
 * 返回值
 * 复制
 * 4
 *
 *
 *
 */
public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        System.out.println(new Main().TreeDepth(root));
    }

    public int TreeDepth(TreeNode root) {
        int layer = 0;
        if (root == null){
            return layer;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- > 0){
                TreeNode node = queue.poll();
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            layer++;
        }
        return layer;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
