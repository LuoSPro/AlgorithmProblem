package com.exam.exam235;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.right.right = new TreeNode(9);
        root.right.right = new TreeNode(9);

        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(4);

        System.out.println(new Main().lowestCommonAncestor(root, p, q).val);
    }

    private TreeNode ancestor;
    private Queue<TreeNode> queue = new LinkedList<>();
    private boolean isChild = false;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        if (p == null){
            return q;
        }
        if (q ==null){
            return p;
        }
        ancestor = root;
        queue.offer(root);
        while (!queue.isEmpty()){
            for (int i = 0; i < queue.size(); i++) {
                TreeNode now = queue.poll();
                if (p.val == now.val&&ancestor!=q){
                    dfs(p,q);
                    if (isChild){
                        return p;
                    }
                }
                isChild = false;
                if (q.val == now.val&&ancestor!=p){
                    dfs(q,p);
                    if (isChild){
                        return q;
                    }
                }
                if (now.left!=null){
                    queue.offer(now.left);
                }
                if (now.right!=null){
                    queue.offer(now.right);
                }
            }
        }
        return ancestor;
    }

    private void dfs(TreeNode node,TreeNode child){
        if (node == null){
            return;
        }
        if (child.val == node.val){
            isChild = true;
            return;
        }
        dfs(node.left,child);
        dfs(node.right,child);
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
