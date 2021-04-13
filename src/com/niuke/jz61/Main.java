package com.niuke.jz61;

import com.exam.exam2.ListNode;
import com.test.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(6);

        main.Deserialize(main.Serialize(root));
    }

    //层次遍历最简单
    String Serialize(TreeNode root) {
        if (root == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        sb.append(root.val).append("!");
        sb.append(",");
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- > 0){
                TreeNode node = queue.poll();
                if (node.left!=null){
                    queue.add(node.left);
                    sb.append(node.left.val+"!");
                }else{
                    sb.append("#");
                }
                if (node.right!=null){
                    queue.add(node.right);
                    sb.append(node.right.val+"!");
                }else{
                    sb.append("#");
                }
            }
            sb.append(",");
        }
        return sb.toString();
    }

    TreeNode Deserialize(String str) {
        if (str == null||str.length() < 2){
            return null;
        }
        String[] layers = str.split(",");
        String layer = layers[0];
        int rootVal = Integer.valueOf(layer.substring(0,layer.length()-1));
        TreeNode root = new TreeNode(rootVal);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int k = 1;
        while (k < layers.length) {
            layer = layers[k++];
            while (!queue.isEmpty() && !layer.isEmpty()) {
                TreeNode node = queue.poll();
                if (layer.charAt(0) == '#') {
                    //空
                    layer = layer.substring(1);
                } else {
                    int index = layer.indexOf("!");
                    int temp = Integer.valueOf(layer.substring(0, index));
                    node.left = new TreeNode(temp);
                    layer = layer.substring(index + 1);
                    queue.add(node.left);
                }
                if (layer.charAt(0) == '#') {
                    //空
                    layer = layer.substring(1);
                } else {
                    int index = layer.indexOf("!");
                    int temp = Integer.valueOf(layer.substring(0, index));
                    node.right = new TreeNode(temp);
                    layer = layer.substring(index + 1);
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

}
