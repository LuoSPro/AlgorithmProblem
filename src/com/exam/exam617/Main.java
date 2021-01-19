package com.exam.exam617;

public class Main {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.left.left = new TreeNode(5);
        root1.right = new TreeNode(2);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.left.right = new TreeNode(4);
        root2.right = new TreeNode(3);
        root2.right.right = new TreeNode(7);

        TreeNode temp = new TreeNode(1);
        //new Main().mergeTrees(root1,root2);
        new Main().mergeTrees(null,temp);
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        t1 = merge(t1,t2);
        return t1;
    }

    private TreeNode merge(TreeNode t1, TreeNode t2){
        if (t1 == null){
            if (t2 != null){
                t1 = new TreeNode(t2.val);
                t1.left = merge(t1.left,t2.left);
                t1.right = merge(t1.right,t2.right);
            }
        }else{
            if (t2 != null){
                t1.val += t2.val;
                t1.left = merge(t1.left,t2.left);
                t1.right = merge(t1.right,t2.right);
            }
        }
        return t1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
