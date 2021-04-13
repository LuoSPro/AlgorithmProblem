package com.exam.exam173;

public class BSTIterator {

    public BSTIterator(TreeNode root) {

    }

    public int next() {
        return 0;
    }

    public boolean hasNext() {
        return false;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
