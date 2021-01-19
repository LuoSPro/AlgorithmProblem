package com.niuke.jz58;

/**
 * 题目描述
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * 示例1
 * 输入
 * 复制
 * {8,6,6,5,7,7,5}
 * 返回值
 * 复制
 * true
 * 示例2
 * 输入
 * 复制
 * {8,6,9,5,7,7,5}
 * 返回值
 * 复制
 * false
 *
 */
public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);

        root.right = new TreeNode(6);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(5);
        System.out.println(new Main().isSymmetrical(root));
    }

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null){//如果root根节点为null，那么直接相等
            return true;
        }
        return dfs(pRoot.left,pRoot.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        //如果left或者right都为null，则返回相等
        if (left == right){
            return true;
        }
        if (left == null||right == null){//其中一个为null，都不相等
            return false;
        }else{
            //判断自身是否相等，再向下判断
            return left.val==right.val&&dfs(left.left,right.right)&&dfs(left.right,right.left);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
