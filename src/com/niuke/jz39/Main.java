package com.niuke.jz39;

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
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.left.left = new TreeNode(5);
        System.out.println(new Main().IsBalanced_Solution(root));
    }

    /**
     * 思路：
     * 1. 到达每个节点时，先判断此节点是否为null，如果是，则返回0
     * 2. 节点不为null，则分别遍历节点的左右子节点，函数  left = dfs(root.left) + 1;右节点同理
     * 3. 递归完成后，返回左右节点的最大层数
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null){
            return true;
        }
        dfs(root);
        return flag;
    }

    private boolean flag = true;

    
    public int dfs(TreeNode root){
        if (!flag||root == null){
            return 0;
        }
        //左右子节点
        int left = dfs(root.left) + 1;
        int right = dfs(root.right) + 1;
        if (Math.abs(left - right) > 1){
            flag = false;
        }
        //返回最深的节点
        return Math.max(left,right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
