package com.exam.exam235;

/**
 * 以为这个树是二叉搜索树（ 有序），所以我们完全可以根据其性质：
 * 1. 同时小于根节点，即在根节点的右边找祖先
 * 2. 同时大于根节点，即在根节点的左边找祖先
 * 3. 一个大于根节点，一个小于根节点，直接返回根节点，因为两个数已经分支了
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            if (p.val < ancestor.val && q.val < ancestor.val) {
                ancestor = ancestor.left;
            } else if (p.val > ancestor.val && q.val > ancestor.val) {
                ancestor = ancestor.right;
            } else {
                break;
            }
        }
        return ancestor;
    }
}