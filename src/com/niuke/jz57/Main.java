package com.niuke.jz57;

/**
 * 题目描述
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * 这里的next就是指向的父节点（这描述，看不出来鸭）
 *
 */
public class Main {

    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(0);
//        new Main().GetNext()
    }

    /**
     * 思路：
     * 我记得前面做过一道和这道题类似的题，当时的要求是吧二叉树变成一个双向链表，这道题也是类似，就是把树的中序遍历实现，然后连接各节点。
     * 不过，把二叉树变成双向链表是直接操作的是节点的左右指针，而这道题直接操作节点的next指针。
     *
     * 但是这里直接是默认的二叉树，形参接收的，也只是其中的一个节点，并不是整棵树。
     * 所以这里应该根据情况直接判断。
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode.left == null){
            return pNode;
        }
        return null;

    }

}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
