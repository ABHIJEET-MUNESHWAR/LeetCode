package com.leetcode.easy.tree;

import com.leetcode.utils.TreeNode;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    03/08/22, Time:    6:51 AM
 */
public class ValidateBST {

  public static void main(String[] args) {
    ValidateBST validateBST = new ValidateBST();
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(4);
    root.right = new TreeNode(6);
    root.right.left = new TreeNode(3);
    root.right.right = new TreeNode(7);
    System.out.println("isValidBST: " + validateBST.isValidBST(root));
  }

  private boolean isValidBST(TreeNode root) {
    return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  private boolean isValidBST(TreeNode root, long minValue, long maxValue) {
    if (root == null) {
      return true;
    }
    if (root.val <= minValue || root.val >= maxValue) {
      return false;
    }
    return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);
  }
}