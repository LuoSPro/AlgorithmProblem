package com.exam.exam637;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        TreeNode right1 = new TreeNode(20);
        node.right = right1;
        right1.left = new TreeNode(15);
        right1.right = new TreeNode(7);
        Main main = new Main();
        List<Double> doubles = main.averageOfLevels(node);
        System.out.println(doubles);
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Double> avgList = new ArrayList<>();
        if (root == null){
            return avgList;
        }
        //层次遍历需要用到队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            //用size控制循环次数
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                //出队列
                TreeNode treeNode = queue.poll();
                //list记录每一层的数据
                /**
                 *      3
                 *     9  20
                 *       15  7
                 * 因为queue每次保存的是一个节点的子节点，而list是保存的每一层的子节点（所有queue遍历后的数据）
                 */
                list.add(treeNode.val);
                if (treeNode.left != null) {
                    //左子节点入队列
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    //右子节点入队列
                    queue.offer(treeNode.right);
                }
            }
            res.add(list);
        }
        for (List<Integer> list : res) {
            double sum = 0;
            for (Integer integer : list) {
                sum += integer;
            }
            avgList.add(sum / list.size());
        }
        return avgList;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
