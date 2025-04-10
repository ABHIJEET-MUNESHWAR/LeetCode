package com.leetcode.companies.meta.practice.tree;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   10-04-2025
    Time:   07:26 pm
    https://leetcode.com/problems/diameter-of-binary-tree/description/
    543. Diameter of Binary Tree
*/

import com.leetcode.utils.TreeNode;

public class Diameter {
    public int diameter(TreeNode root, int[] result) {
        if (root == null) {
            return 0;
        }
        int left = diameter(root.left, result);
        int right = diameter(root.right, result);
        result[0] = Math.max(result[0], left + right);
        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] result = {Integer.MIN_VALUE};
        diameter(root, result);
        return result[0];
    }
}
