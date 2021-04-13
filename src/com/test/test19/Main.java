package com.test.test19;

import com.exam.exam2.ListNode;
import com.test.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<String> list;

    public static void main(String[] args) {
        list = new ArrayList<>();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        wort(root, new StringBuilder());
        for (String s : list) {
            System.out.println(s);
        }
    }

    /**
     * 打印一列，用深搜呗
     * @param root
     * @return
     */
    private static void wort(TreeNode root, StringBuilder path) {
        if (root == null) {
            return;
        }
        path.append(root.val);
        if (root.left == null && root.right == null){
            //叶子节点
            list.add(new String(path));
            return;
        }
        int index = path.length();
        wort(root.left, path);
        path.delete(index,path.length());
        wort(root.right, path);
    }
}
