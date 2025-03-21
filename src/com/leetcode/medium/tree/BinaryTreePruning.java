package com.leetcode.medium.tree;

import com.leetcode.utils.TreeNode;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    29/06/24,
 * Time:    3:13 pm
 * 814. Binary Tree Pruning
 * https://leetcode.com/problems/binary-tree-pruning/description/
 */
public class BinaryTreePruning {
  public static void main(String[] args) {
    BinaryTreePruning binaryTreePruning = new BinaryTreePruning();
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(0);
    root.right.left = new TreeNode(0);
    root.right.right = new TreeNode(1);
    root = binaryTreePruning.pruneTree(root);
    root.inorderTraversal(root);
  }

  private TreeNode pruneTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    root.left = pruneTree(root.left);
    root.right = pruneTree(root.right);
    if (root.left == null && root.right == null && root.val == 0) {
      return null;
    }
    return root;
  }
}