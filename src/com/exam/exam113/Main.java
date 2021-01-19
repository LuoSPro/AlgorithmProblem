package com.exam.exam113;

import java.util.ArrayList;
import java.util.List;

/**
 * 技巧：在使用list记录元素时，因为会涉及到还原现场这一步，所以会涉及到移除之前添加的元素，由于元素间有重复，所以
 * 最优雅的还原方式是删除最后一个元素，这样即使有重复，也不会把之前的元素删掉
 */
public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        TreeNode temp = new TreeNode(1);
        temp.left = new TreeNode(0);
        temp.left.left = new TreeNode(1);
        temp.left.left.left = new TreeNode(0);
        temp.left.left.right = new TreeNode(1);
        temp.left.right = new TreeNode(2);
        temp.left.right.left = new TreeNode(-1);
        temp.left.right.right = new TreeNode(0);
        temp.right = new TreeNode(1);
        temp.right.left = new TreeNode(0);
        temp.right.left.left = new TreeNode(-1);
        temp.right.left.right = new TreeNode(0);
        temp.right.right = new TreeNode(-1);
        temp.right.right.left = new TreeNode(1);
        temp.right.right.right = new TreeNode(0);


        int sum = 2;
        System.out.println(new Main().pathSum(temp, sum));
    }

    private List<List<Integer>> result = new ArrayList<>();
    private int cur = 0;
    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root,sum);
        return result;
    }

    private void dfs(TreeNode node,int sum) {
        if (node == null){
            return;
        }
        cur += node.val;
        list.add(node.val);
        if (cur == sum&& node.left ==null && node.right == null){
            result.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            cur -= node.val;
            return;
        }
        dfs(node.left,sum);
        dfs(node.right,sum);
        list.remove(list.size()-1);
        cur -= node.val;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
