package com.leetcode.easy.tree;

import com.leetcode.utils.TreeNode;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    02/08/22, Time:    7:19 AM
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/555/
 */
public class MaxDepth {

  public static void main(String[] args) {
    MaxDepth maxDepth = new MaxDepth();
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    System.out.println("The maximum depth of the tree is: " + maxDepth.maxDepth(root));
  }

  private int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return Math.max(maxDepth(root.left, 1), maxDepth(root.right, 1));
  }

  private int maxDepth(TreeNode root, int maxDepth) {
    if (root == null) {
      return maxDepth;
    }
    return Math.max(maxDepth(root.left, maxDepth + 1), maxDepth(root.right, maxDepth + 1));
  }
}