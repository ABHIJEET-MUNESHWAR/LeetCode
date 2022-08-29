package com.leetcode.easy.tree;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    29/08/22, Time:    10:25 PM
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 */
public class MinimumDistance {

  int min = Integer.MAX_VALUE;
  Integer prev = null;

  public static void main(String[] args) {
    MinimumDistance minimumDistance = new MinimumDistance();
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.right = new TreeNode(6);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    System.out.println(minimumDistance.getMinimumDifference(root));
  }

  public int getMinimumDifference(TreeNode root) {
    if (root == null) {
      return min;
    }
    getMinimumDifference(root.left);
    if (prev != null) {
      min = Math.min(min, root.val - prev);
    }
    prev = root.val;
    getMinimumDifference(root.right);
    return min;
  }
}