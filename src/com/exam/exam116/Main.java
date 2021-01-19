package com.exam.exam116;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Node node = new Node();
        node.left = new Node(2);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right = new Node(3);
        node.right.left = new Node(6);
        node.right.right = new Node(7);
        new Main().connect(node);
    }

    public Node connect(Node root) {
        if (root == null){
            return null;
        }
        if (root.left != null){
            queue.add(root.left);
        }
        if (root.right != null){
            queue.add(root.right);
        }
        bfs(queue.peek());
        return root;
    }

    Queue<Node> queue = new ArrayDeque<>();
    private Node lastNode;

    public void bfs(Node node){
        Node font;
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            if (lastNode == null){
                lastNode = queue.peek();
            }
            //最先进入的
            font = queue.poll();
            //判断左右为null否，加入queen
            if (font.left != null){
                queue.add(font.left);
            }
            if (font.right != null){
                queue.add(font.right);
            }
            //连接
            if (lastNode != font){
                lastNode.next = font;
                //更新
                lastNode = font;
            }
        }
        //置空
        lastNode = null;
        //循环
        if (!queue.isEmpty()){
            bfs(queue.peek());
        }
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
