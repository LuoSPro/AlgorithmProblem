package com.niuke.jz60;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * 题目描述
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * 示例1
 * 输入
 * 复制
 * {8,6,10,5,7,9,11}
 * 返回值
 * 复制
 * [[8],[6,10],[5,7,9,11]]
 *
 */
public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);

        root.right = new TreeNode(10);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);
        ArrayList<ArrayList<Integer>> lists = new Main().Print(root);
        for (ArrayList<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    /**
     * 这道题不就是直接进行层次遍历吗，过于简单，争取一次性过。
     * 除了和条件略微有点冲突，真的是一次性过
     * @param pRoot
     * @return
     */
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (pRoot == null){
            return lists;
        }
        ArrayList<Integer> list;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(pRoot);
        while (queue.size() != 0){
            list = new ArrayList<>();
            int size = queue.size();
            while (size-- > 0){
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            lists.add(list);
        }
        return lists;
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
