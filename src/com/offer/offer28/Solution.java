package com.offer.offer28;

/**
 * 较为简单的办法就是一个一个的比较
 * 而且这又是链表，相互之间的位置是很好确定的。
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(new Solution().isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return bfs(root.left,root.right);
    }

    private boolean bfs(TreeNode left, TreeNode right) {
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null||left.val != right.val){
            return false;
        }
        return bfs(left.left, right.right) && bfs(left.right,right.left);
    }


}
