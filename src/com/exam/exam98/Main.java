package com.exam.exam98;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(7);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(8);
        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(30);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(15);
        root.right.right.right = new TreeNode(45);
        System.out.println(new Main().isValidBST(root));
    }

    private boolean flag = true;

    /**
     * 思路：明显就是用中序遍历嘛，因为要比较大小啊，简单的方法可以用一个数组把中序遍历的结果保存下来，然后再遍历比较
     * 但是要是优化到空间复杂度为O(1)的话，就只能递归了+剪枝了
     *
     * 这里还是有点错，我觉得是要root要大于左边的最大值，小于右边的最小值
     *
     * 其实这个就感觉很好办了，左子树的最大，就在左子树的最右边，右子树的最小，就在右子树的最左边
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        dfs(root);
        return flag;
    }

    private void dfs(TreeNode root) {
        if (root == null || !flag){
            //剪枝
            return;
        }
        dfs(root.left);
        //求左子树的最大值
        TreeNode left = root.left;
        if (left != null){
            //找到左子树的最右个节点
            while (left.right != null){
                left = left.right;
            }
            if (root.val <= left.val){
                //不适合
                flag = false;
            }
        }
        TreeNode right = root.right;
        if (right != null){
            //找到右子树最左边的节点
            while (right.left != null){
                right = right.left;
            }
            if (root.val >= right.val){
                //不适合
                flag = false;
            }
        }
        dfs(root.right);
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
