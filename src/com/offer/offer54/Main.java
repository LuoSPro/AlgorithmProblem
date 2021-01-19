package com.offer.offer54;

public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);
        int k = 1;
        System.out.println(new Main().kthLargest(root, k));
    }

    /**
     * 中序遍历：
     * 左  ->  中   ->    右
     * if(node == null) return//结束条件
     * search(node.left); //往左分支上面变流
     * node.val
     * search(node.right);
     *
     *
     * 中序遍历倒序
     * 右   ->   根   ->   左
     * if(node == null) return//结束条件
     * search(node.right); //往左分支上面变流
     * node.val
     * search(node.left);
     *
     *
     * 不用去刻意的记录上一个节点的信息，因为递归的时候，会为你保存上一次的记录
     *
     * @param root
     * @param k
     * @return
     */

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        //先向右边找到最大的点
        search(root);
        return res;
    }

    private int res,k;

    private void search(TreeNode root) {
        //结束条件
        if (root == null) return;
        //右
        search(root.right);
        //根
        //已经找到结果了，返回
        if (k == 0) return;
        //找到我们的目标了，记录下来
        if (--k == 0)
            this.res = root.val;
        //左
        search(root.left);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
