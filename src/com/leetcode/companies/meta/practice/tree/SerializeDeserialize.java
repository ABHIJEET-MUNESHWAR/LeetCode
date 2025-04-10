package com.leetcode.companies.meta.practice.tree;


import com.leetcode.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   10-04-2025
    Time:   07:24 pm
    297. Serialize and Deserialize Binary Tree
    https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
*/


public class SerializeDeserialize {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode current = q.poll();
            if (current == null) {
                result.append("n ");
                continue;
            }
            result.append(current.val + " ");
            q.add(current.left);
            q.add(current.right);
        }
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") {
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll();
            if (!values[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                q.add(left);
                parent.left = left;
            }
            if (!values[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                q.add(right);
                parent.right = right;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        SerializeDeserialize serializeDeserialize = new SerializeDeserialize();
    }
}
