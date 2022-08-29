package com.leetcode.easy.tree;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    28/08/22, Time:    11:11 AM
 * https://leetcode.com/problems/balanced-binary-tree/
 */
public class BalancedBinaryTree {

  public static void main(String[] args) {
    BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    System.out.println(balancedBinaryTree.isBalanced(root));
  }

  private boolean isBalanced(TreeNode root) {
    return isBalanced(root, 0) >= 0;
  }

  private int isBalanced(TreeNode root, int height) {
    if (root == null) {
      return height;
    }
    int leftHeight = isBalanced(root.left, height + 1);
    int rightHeight = isBalanced(root.right, height + 1);
    if (leftHeight < 0 || rightHeight <= 0 || Math.abs(leftHeight - rightHeight) > 1) {
      return -1;
    }
    return Math.max(leftHeight, rightHeight);
  }
}