package com.test.test21;

import com.test.TreeNode;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        work(root);
    }

    public static void work(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.println(node.val + " ");
            if (node.right!=null){
                stack.add(node.right);
            }
            if (node.left != null){
                stack.add(node.left);
            }
        }


    }

}
