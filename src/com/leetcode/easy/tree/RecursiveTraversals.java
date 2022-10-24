package com.leetcode.easy.tree;

import com.leetcode.utils.TreeNode;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    05/08/22, Time:    10:02 AM
 */
public class RecursiveTraversals {

  public static void main(String[] args) {
    RecursiveTraversals recursiveTraversals = new RecursiveTraversals();
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.right = new TreeNode(6);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(7);
    recursiveTraversals.inorderTraversal(root);
    System.out.println();
    recursiveTraversals.preOrderTraversal(root);
    System.out.println();
    recursiveTraversals.postOrderTraversal(root);
  }

  private void postOrderTraversal(TreeNode root) {
    if (root == null) {
      return;
    }
    postOrderTraversal(root.left);
    postOrderTraversal(root.right);
    System.out.println(root.val);
  }

  private void preOrderTraversal(TreeNode root) {
    if (root == null) {
      return;
    }
    System.out.println(root.val);
    preOrderTraversal(root.left);
    preOrderTraversal(root.right);
  }

  private void inorderTraversal(TreeNode root) {
    if (root == null) {
      return;
    }
    inorderTraversal(root.left);
    System.out.println(root.val);
    inorderTraversal(root.right);
  }
}