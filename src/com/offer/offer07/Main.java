package com.offer.offer07;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *  
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 */
public class Main {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode treeNode = new Main().buildTree(preorder, inorder);
        System.out.println(treeNode);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //先判断两种基况：起始大于结束，返回null
        if (preorder == null || preorder.length == 0){
            return null;
        }
        //使用一个 Map 存储中序遍历的每个元素及其对应的下标
        //使用中序遍历的理由:确定了根节点后，就能知道左右子树的节点数量
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
    }

    public TreeNode buildTree(int[] preorder,int preorderStart,int preorderEnd,
                              int[] inorder,int inorderStart,int inorderEnd,
                              Map<Integer,Integer> map){
        //判断前序遍历的下标范围,若开始大于结束，则当前的二叉树中没有节点，返回空值 null
        if (preorderStart > preorderEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preorderStart]);
        //若开始等于结束，则当前的二叉树中恰好有一个节点，根据节点值创建该节点作为根节点并返回。
        if (preorderStart == preorderEnd){
            return root;
        }else{
            //若开始小于结束
            int rootIndex = map.get(root.val);
            //根据中序遍历可以计算出左、右子树的节点数
            int leftNodes = rootIndex - inorderStart;
            int rightNodes = inorderEnd - rootIndex;
            //递归去重建左子树和右子树
            //知道节点数量后，在前序遍历中即可得到左子树和右子树各自的下标范围
            //preorder:前序遍历表[根节点  左子树  右子树]
            //preorderStart = preorderStart+1:由于前序遍历的第一个位置是根节点，所以开始位置向后一个才是左子树的开始
            //preorderEnd = preorderStart+leftNodes:由于左子树的数量是leftNodes,所以结束位置就是 开始位置+leftNodes
            //inorder:中序遍历表[左子树  根节点  右子树]
            //inorderStart = inorderStart:由于根节点的位置在中间，所以开始位置始终是属于左子树的，这个不用变
            //inorderEnd = rootIndex-1:由于rootIndex位置是根节点，所以左子树的范围是 起始位置~根节点的前一个
            TreeNode leftSubTree = buildTree(preorder, preorderStart+1, preorderStart+leftNodes, inorder, inorderStart, rootIndex-1, map);

            //preorder:前序遍历表[根节点  左子树  右子树]
            //preorderStart = preorderEnd-rightNodes+1:这是其实也可以是preorderStart = preorderStart+leftNodes+1,其目的都是得到右子树范围内的起点，如上图
            //preorderEnd = preorderEnd:结束位置就是整个表的结尾
            //inorder:中序遍历表[左子树  根节点  右子树]
            //inorderStart = rootIndex+1:由于根节点的位置在中间，所以右子树的范围是 根节点的后一个~结束位置
            //inorderEnd = inorderEnd:由于rootIndex位置是根节点，所以右子树的范围是 根节点的后一个~结束位置
            TreeNode rightSubTree = buildTree(preorder, preorderStart+leftNodes+1, preorderEnd, inorder, rootIndex+1, inorderEnd, map);
            root.left = leftSubTree;
            root.right = rightSubTree;
            return root;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
