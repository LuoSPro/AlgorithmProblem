package com.niuke.jz26;

/**
 * 题目描述
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left= new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        new Main().Convert(root);
    }

    /**
     * 我觉得是中序遍历来解决这个问题，因为中序遍历的结果就是二叉排序树的顺序
     *
     * 算了，我得思路正确，但是递归得时候总是处理不好，借鉴一个别人和我思路差不多得
     * @param pRootOfTree
     * @return
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
//        if (pRootOfTree == null){
//            return null;
//        }
//        inOrder(pRootOfTree,pRootOfTree.left);
//        inOrder(pRootOfTree,pRootOfTree.right);
        inOrder(pRootOfTree);
        while (lastNode != null && lastNode.left != null)
            lastNode = lastNode.left;
        return lastNode;
    }

    private TreeNode inOrder(TreeNode parent,TreeNode node) {
        if (node == null||node.left == parent){
            return null;
        }
        inOrder(node,node.left);
        //处理
        if (node.val < parent.val){
            //左节点
            node.right = parent;
        }else{
            node.left = parent;
        }
        inOrder(node,node.right);
        return node;
    }

    private TreeNode lastNode;

    /**
     * 始终保持上一个，才好和下一个联系起来
     * @param node
     */
    private void inOrder(TreeNode node) {
        if (node == null){
            return;
        }
        inOrder(node.left);
        node.left = lastNode;
        if (lastNode != null){
            lastNode.right = node;
        }
        lastNode = node;
        inOrder(node.right);
    }

}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
