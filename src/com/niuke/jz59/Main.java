package com.niuke.jz59;

import java.util.*;

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
     * 思路，这个肯定就是要用层次遍历嘛，因为涉及到正向和反向，那么肯定就需要队列和栈嘛，很简单
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null){
            return result;
        }
        //层次遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        int flag = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            flag++;
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
            if (flag % 2 == 0){
                Collections.reverse(list);
            }
            result.add(list);
        }
        return result;
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
