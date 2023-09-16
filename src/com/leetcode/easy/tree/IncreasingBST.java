package com.leetcode.easy.tree;

import com.leetcode.utils.TreeNode;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    13/09/23,
 * Time:    9:49 am
 * https://leetcode.com/problems/increasing-order-search-tree/
 */
public class IncreasingBST {
  TreeNode curr = null;

  public static void main(String[] args) {
    IncreasingBST increasingBST = new IncreasingBST();
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(3);
    root.right = new TreeNode(6);
    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(4);
    root.left.left.left = new TreeNode(1);
    root.right.right = new TreeNode(8);
    root.right.right.left = new TreeNode(7);
    root.right.right.right = new TreeNode(9);
    root = increasingBST.increasingBST2(root);
    root.inorderTraversal(root);
  }

  private TreeNode increasingBST2(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode result = new TreeNode(0);
    curr = result;
    inorder(root);
    return result.right;
  }

  private void inorder(TreeNode node) {
    if (node == null) {
      return;
    }
    inorder(node.left);
    node.left = null;
    curr.right = node;
    curr = node;
    inorder(node.right);
  }

  private TreeNode increasingBST(TreeNode root) {
    if (root == null) {
      return root;
    }
    return increasingBST(root, null);
  }

  private TreeNode increasingBST(TreeNode root, TreeNode tail) {
    if (root == null) {
      return tail;
    }
    TreeNode res = increasingBST(root.left, root);
    root.left = null;
    root.right = increasingBST(root.right, tail);
    return res;
  }
}