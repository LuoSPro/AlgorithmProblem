package com.offer.offer36;

public class Main {

    public static void main(String[] args) {
//        new Main().treeToDoublyList()
    }

    private Node pre,tail;
    //中序遍历
    public Node treeToDoublyList(Node root) {
        dfs(root);
        return null;
    }

    private void dfs(Node root) {
        if (root == null)
            return;
        //左
        dfs(root.left);
        //根

        //右
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
