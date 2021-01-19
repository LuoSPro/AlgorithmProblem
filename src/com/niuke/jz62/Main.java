package com.niuke.jz62;

import javax.swing.tree.TreeNode;

public class Main {

    public static void main(String[] args) {

        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(3);
        node.left.left = new TreeNode(2);
        node.left.right = new TreeNode(4);

        node.right = new TreeNode(7);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(8);
        System.out.println(new Main().KthNode(node, 3).val);
    }

    private int index = 0;
    private TreeNode node;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null||k<=0){
            return null;
        }
        index = k;
        DFS(pRoot);
        return node;
    }

    private void DFS(TreeNode pRoot) {
        //中序遍历
        if (index>0&&pRoot.left != null){
            DFS(pRoot.left);
        }
        if (index>0&&--index == 0){
            node = pRoot;
        }
        if (index>0&&pRoot.right != null){
            DFS(pRoot.right);
        }
    }

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
}
