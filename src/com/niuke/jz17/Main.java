package com.niuke.jz17;

/**
 *
 * 题目描述
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 示例1
 * 输入
 * 复制
 * {8,8,#,9,#,2,#,5},{8,9,#,2}
 * 返回值
 * 复制
 * true
 *
 */
public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(9);
        root.left.left.left = new TreeNode(2);
        root.left.left.left.left = new TreeNode(5);

        TreeNode child = new TreeNode(8);
        child.left = new TreeNode(9);
        child.left.left = new TreeNode(5);
//        child.left.left.left = new TreeNode(2);
        System.out.println(new Main().HasSubtree(root, child));
    }

    /**
     *
     * 思路：
     * 直接想的就是先查找子树的根节点在树中的位置，然后再对其结构进行判断
     *
     * 题解：
     * 思路对了，但是细节没处理好，
     * 刚开始，我判断的是当root1==null||root2==null的时候，返回true
     * 但是有问题，那就是root1为null的时候，root2还不喂null，此时这个就不想等
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1==null||root2==null){
            return false;
        }
        //查找根节点
        return findRoot(root1,root2);
    }

    private boolean findRoot(TreeNode root1, TreeNode root2) {
        //判断root1分支为null的情况
        if (root1 == null){
            return false;
        }
        if (root1.val == root2.val){
            if (judgeNode(root1, root2)){
                return true;
            }
        }
        return findRoot(root1.left,root2)||findRoot(root1.right,root2);
    }

    private boolean judgeNode(TreeNode root1, TreeNode root2) {
        //因为在前面已经判断过，两个都不可能为null，所以这里只要为null，就相同
        if (root2==null){
            return true;
        }
        //这里的问题：刚开始，我判断的是当root1==null||root2==null的时候，返回true
        //但是有问题，那就是root1为null的时候，root2还不喂null，此时这个就不想等
        if (root1 == null){
            return false;
        }
        //继续判断
        if (root1.val != root2.val){
            return false;
        }else{
            //递归判断
            return judgeNode(root1.left,root2.left)&&judgeNode(root1.right,root2.right);
        }
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


