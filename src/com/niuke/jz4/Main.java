package com.niuke.jz4;

import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *  * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 *
 *
 *         1
 *      2     3
 *   4      5   6
 *     7      8
 */
public class Main {

    public static void main(String[] args) {
        int [] pre = {1,2,4,7,3,5,6,8};
        int [] in = {4,7,2,1,5,3,8,6};
        new Main().reConstructBinaryTree(pre,in);
    }

    /**
     * 思路：
     * 结构：
     * <p>先序遍历：根  左子树  右子树</p>
     * <p>中序遍历：左子树  根  右子树</p>
     * 需要利用中序遍历中的第一个节点（根节点），来将前序遍历划分成两部分（左子树 右子树）
     * 这里需要将前序遍历中每个节点的位置保存下来，这样才好通过查询中序遍历，将根节点找到后，再由根节点将中序遍历划分开
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        //筛选数据，先序遍历必须有数据
        if (pre == null||pre.length == 0){
            return null;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            //将中序遍历中每个节点的位置保存下来
            map.put(in[i],i);
        }
        //根节点
        return buildTree(map,pre,0,pre.length-1,in,0,in.length-1);
    }

    /**
     *
     * 结构：
     * <p>先序遍历：根  左子树  右子树</p>
     * <p>中序遍历：左子树  根  右子树</p>
     *
     * 作用：
     * 先序遍历：用于找根
     * 中序遍历：用于划分左右子树
     *
     * @param node 根节点
     * @param map 存储的中序遍历的位置
     * @param pre 先序遍历
     * @param leftP 先序遍历的左边
     * @param rightP 先序遍历的右边
     * @param in 中序遍历
     * @param leftI 中序遍历的左边
     * @param rightI 中序遍历的右边
     */
//    private TreeNode buildTree(TreeNode node,Map<Integer,Integer> map,int [] pre, int leftP,int rightP,int [] in,int leftI,int rightI){
//        //结束条件(距离缩小到1的时候才返回)
//        if (rightI - leftI == 1){
//            return node;
//        }else if (rightI == leftI){
//            return null;
//        }
//        //根节点在中序遍历中的位置
//        int index = map.get(node.val);
//        //左子树的个数
//        int leftCount = index - leftI;
//        //右子树个数（根节点不包括在内）
//        int rightCount = rightI - index - 1;
//        //下一个根节点(先序遍历的第一个)
//        TreeNode root = new TreeNode(pre[leftP+1]);
//        //递归
//        node.left = buildTree(root, map, pre, leftP+1, rightP+leftCount, in, leftI, index);
//        //中序遍历的右边不能一直是rightI,因为中间的节点也有右子树，所以需要index+rightCount+1
//        node.right = buildTree(root, map, pre, leftP+leftCount+1, rightP, in, index+1, index+rightCount-1);
//        return node;
//    }

    //这里我全部都是按照左右闭区间来做的，省去了开区间的复杂性
    private TreeNode buildTree(Map<Integer,Integer> map, int [] pre, int leftP, int rightP, int [] in, int leftI, int rightI){
        //结束条件
        if (leftI > rightI){
            return null;
        }
        //根节点位置
        int index = map.get(pre[leftP]);
        //得到根节点
        TreeNode root = new TreeNode(in[index]);
        //得到左右节点的个数
        int leftCount = index - leftI;
        int rightCount = rightI - index;
        //遍历左子树（这里的先序遍历处理倒是很简单，直接根据leftCount就可以得出来）
        //而这道题递归结束的点在于中序遍历的角标上，因为在左子树时，right=index-1最终会造成right>left；而右子树上，left=index+1会造成right>left，一样的道理
        root.left = buildTree(map,pre,leftP+1,leftP+leftCount,in,leftI,index-1);
        root.right = buildTree(map,pre,leftP+leftCount+1,rightP,in,index+1,rightI);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
