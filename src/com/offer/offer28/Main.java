package com.offer.offer28;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(new Main().isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return false;
        }
        if (root.left == null && root.right==null){
            return true;
        }
        if (root.left != null){
            queue.add(root.left);
        }
        if (root.right != null){
            queue.add(root.right);
        }
        return bfs();
    }

    private Queue<TreeNode> queue = new ArrayDeque<>();
    private StringBuilder leftChildStr = new StringBuilder();
    private StringBuilder rightChildStr = new StringBuilder();

    private boolean bfs() {
        if (queue.size() == 0){
            return true;
        }
        leftChildStr = new StringBuilder();
        rightChildStr = new StringBuilder();
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            TreeNode child = queue.poll();
            if (child.val == -1){
                if (i < size / 2){
                    leftChildStr.append("*");
                }else{
                    rightChildStr.append("*");
                }
                continue;
            }
            if (child.left != null){
                queue.add(child.left);
            }else {
                queue.add(new TreeNode(-1));
            }
            if (child.right != null){
                queue.add(child.right);
            }else {
                queue.add(new TreeNode(-1));
            }
            if (i < size / 2){
                leftChildStr.append(child.val);
            }else{
                rightChildStr.append(child.val);
            }
        }
        if (leftChildStr.toString().equals(rightChildStr.reverse().toString())){
            return bfs();
        }else{
            return false;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
