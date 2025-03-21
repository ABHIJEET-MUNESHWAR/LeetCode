package com.leetcode.medium.tree;

import com.leetcode.utils.TreeNode;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    29/06/24,
 * Time:    4:17 pm
 * 1026. Maximum Difference Between Node and Ancestor
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/description/
 */
public class MaximumDifferenceBetweenNodeAndAncestor {
  public static void main(String[] args) {
    MaximumDifferenceBetweenNodeAndAncestor maximumDifferenceBetweenNodeAndAncestor = new MaximumDifferenceBetweenNodeAndAncestor();
    TreeNode root = new TreeNode(8);
    root.left = new TreeNode(3);
    root.right = new TreeNode(10);
    root.right.right = new TreeNode(14);
    root.right.right.left = new TreeNode(13);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(6);
    root.left.right.left = new TreeNode(4);
    root.left.right.right = new TreeNode(7);
    System.out.println(maximumDifferenceBetweenNodeAndAncestor.maxAncestorDiff(root));
  }

  private int maxAncestorDiff(TreeNode root) {
    int min = root.val;
    int max = root.val;
    return findMaxDiff(root, min, max);
  }

  private int findMaxDiff(TreeNode root, int min, int max) {
    if (root == null) {
      return max - min;
    }
    min = Math.min(min, root.val);
    max = Math.max(max, root.val);

    int leftValue = findMaxDiff(root.left, min, max);
    int rightValue = findMaxDiff(root.right, min, max);
    return Math.max(leftValue, rightValue);
  }
}