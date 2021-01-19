package com.exam.exam538;

/**
 * Morris 遍历
 * 此算法是先将二叉树变成一个右子树：每次让当前节点的右子树的最左节点=当前节点（因为当前节点肯定下雨右子树上的值，所以大小没变）
 *        5
 *      2   13
 *    1    12
 *
 *  变成
 *
 *         13
 *       12  15
 *      5
 *     2
 *    1
 *
 *  改变后，直接从根节点开始向左子树遍历，此时当前节点是最大值
 */
class Solution {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(13);
        left.right= new TreeNode(3);
        right.left = new TreeNode(10);
        right.right = new TreeNode(15);

        node.left = left;
        node.right = right;
        new Solution().convertBST(node);
    }

    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        TreeNode node = root;

        while (node != null) {
            //当前节点的右子节点为空，处理当前节点
            if (node.right == null) {
                sum += node.val;
                node.val = sum;
                //遍历当前节点的左子节点；
                node = node.left;
            } else {//当前节点的右子节点不为空
                TreeNode succ = getSuccessor(node);//找到当前节点右子树的最左节点
                //最左节点的左指针为空
                if (succ.left == null) {
                    //将最左节点的左指针指向当前节点
                    succ.left = node;
                    //遍历当前节点的右子节点；
                    node = node.right;
                } else {//最左节点的左指针不为空
                    //将最左节点的左指针重新置为空（恢复树的原状）
                    succ.left = null;
                    sum += node.val;
                    node.val = sum;
                    //将当前节点置为其左节点
                    node = node.left;
                }
            }
        }

        return root;
    }

    public TreeNode getSuccessor(TreeNode node) {
        //找到当前节点右子树的最左节点
        TreeNode succ = node.right;
        while (succ.left != null && succ.left != node) {
            succ = succ.left;
        }
        return succ;
    }
}

