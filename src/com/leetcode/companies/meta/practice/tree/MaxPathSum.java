package com.leetcode.companies.meta.practice.tree;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   10-04-2025
    Time:   07:28 pm
    https://leetcode.com/problems/binary-tree-maximum-path-sum/
    124. Binary Tree Maximum Path Sum
*/

import com.leetcode.utils.TreeNode;

public class MaxPathSum {
    int maxSum;

    public int solve(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = solve(root.left);
        int right = solve(root.right);

        int neecheHiMilGayaAnswer = left + right + root.val; //(1)
        int koiEkAccha = Math.max(left, right) + root.val; //(2)
        int onlyRootAccha = root.val; //(3)
        maxSum = Math.max(maxSum, Math.max(neecheHiMilGayaAnswer, Math.max(koiEkAccha, onlyRootAccha)));
        return Math.max(koiEkAccha, onlyRootAccha);
    }

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        solve(root);
        return maxSum;
    }
}
