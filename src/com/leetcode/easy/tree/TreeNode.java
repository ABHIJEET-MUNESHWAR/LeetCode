package com.leetcode.easy.tree;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    02/08/22, Time:    6:49 AM
 */
public class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  public TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  public void inorderTraversal(TreeNode root) {
    if (root == null) {
      return;
    }
    root.inorderTraversal(root.left);
    System.out.println(root.val);
    root.inorderTraversal(root.right);
  }
}