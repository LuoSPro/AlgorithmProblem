package com.exam.exam226;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode nodeLeft = new TreeNode(2);
        TreeNode nodeRight = new TreeNode(7);
        root.left = nodeLeft;
        root.right = nodeRight;
        nodeRight.left = new TreeNode(6);
        nodeRight.right = new TreeNode(9);
        nodeLeft.left = new TreeNode(1);
        nodeLeft.right = new TreeNode(3);
        new Main().invertTree(root);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
