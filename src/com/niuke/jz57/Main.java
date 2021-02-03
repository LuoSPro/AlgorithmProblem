package com.niuke.jz57;

import java.util.ArrayDeque;
import java.util.Queue;

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
        root.left = new TreeLinkNode(1);
        root.left.next = root;
        root.left.left = new TreeLinkNode(3);
        root.left.left.next = root.left;
        root.left.right = new TreeLinkNode(4);
        root.left.right.next = root.left;
        root.right = new TreeLinkNode(2);
        root.right.next = root;
        System.out.println(new Main().GetNext(root.left.right).val);
    }

    /**
     * 思路：
     * 我记得前面做过一道和这道题类似的题，当时的要求是吧二叉树变成一个双向链表，这道题也是类似，就是把树的中序遍历实现，然后连接各节点。
     * 不过，把二叉树变成双向链表是直接操作的是节点的左右指针，而这道题直接操作节点的next指针。
     *
     * 但是这里直接是默认的二叉树，形参接收的，也只是其中的一个节点，并不是整棵树。
     * 所以这里应该根据情况直接判断。
     *
     * 隔了一天，觉得先尝试一下暴力解法（虽然也是看题解才想到的，太菜了鸭）
     *
     * 题解：
     * 他主要是把每种情况罗列出来了，并且将他们分类，这有点考个人的归纳能力啊：
     * [1] 是一类：特点：当前结点是父亲结点的左孩子
     * [2 3 6] 是一类，特点：当前结点右孩子结点，那么下一节点就是：右孩子结点的最左孩子结点,如果右孩子结点没有左孩子就是自己
     * [4 5]是一类，特点：当前结点为父亲结点的右孩子结点，本质还是[1]那一类
     * [7]是一类，特点：最尾结点
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {

        if (pNode == null){
            return null;
        }

        //当前节点是右孩子节点,那么他的下一个就是右节点的最左节点
        if (pNode.right != null){
            pNode = pNode.right;
            while (pNode.left != null){
                pNode = pNode.left;
            }
            return pNode;
        }

        //当前节点是父节点的左节点，或者是右节点:这里的做法就是一直去查找父节点，只要父节点没有左子树就一直往上查。已找到父节点有左子树，那么就是答案了
        while (pNode.next != null){
            TreeLinkNode next = pNode.next;
            while (next.left == pNode){
                return next;
            }
            pNode = pNode.next;
        }

        //尾结点的情况
        return null;


//        if (pNode == null){
//            return pNode;
//        }
//        TreeLinkNode temp = pNode;
//        //查找父节点
//        while (temp.next != null){
//            temp = temp.next;
//        }
//        //刚开始用队列做了一个层次遍历，发现怎么都不对，啊这....
//        //中序遍历
//        inOrder(temp);
//        while (queue.size() > 0){
//            TreeLinkNode node = queue.poll();
//            if (node == pNode&&queue.size() > 0){
//                return queue.poll();
//            }
//        }
//        return null;
    }

    private Queue<TreeLinkNode> queue = new ArrayDeque<>();

    private void inOrder(TreeLinkNode temp) {
        if (temp == null){
            return;
        }
        inOrder(temp.left);
        queue.add(temp);
        inOrder(temp.right);
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
