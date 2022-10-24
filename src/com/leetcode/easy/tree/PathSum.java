package com.leetcode.easy.tree;

import com.leetcode.utils.TreeNode;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    30/08/22, Time:    9:13 AM
 */
public class PathSum {

  public static void main(String[] args) {
    PathSum pathSum = new PathSum();
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(4);
    root.right = new TreeNode(8);
    root.right.left = new TreeNode(13);
    root.right.right = new TreeNode(4);
    root.right.right.right = new TreeNode(1);
    root.left.left = new TreeNode(11);
    root.left.left.left = new TreeNode(7);
    root.left.left.right = new TreeNode(2);
    System.out.println(pathSum.hasPathSum(root, 22));
  }

  private boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) {
      return false;
    }
    if (root.left == null && root.right == null && root.val == targetSum) {
      return true;
    }
    return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right,
        targetSum - root.val);
  }
}