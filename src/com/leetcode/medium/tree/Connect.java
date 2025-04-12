package com.leetcode.medium.tree;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   11-04-2025
    Time:   03:58 pm
    116. Populating Next Right Pointers in Each Node
    https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
*/
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

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

public class Connect {
    public Node connect(Node root) {
        if (root == null || root.left == null || root.right == null) {
            return root;
        }
        root.left.next = root.right;
        if (root.next != null) {
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}
