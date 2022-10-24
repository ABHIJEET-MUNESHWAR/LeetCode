package com.leetcode.medium.tree;

import com.leetcode.utils.TreeNode;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    01/09/22, Time:    9:32 AM
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 */
public class GoodNodesBinaryTree {

  int good;

  public static void main(String[] args) {
    GoodNodesBinaryTree goodNodesBinaryTree = new GoodNodesBinaryTree();
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(1);
    root.right = new TreeNode(4);
    root.left.left = new TreeNode(3);
    root.right.left = new TreeNode(1);
    root.right.right = new TreeNode(5);
    System.out.println(goodNodesBinaryTree.goodNodes(root));
  }

  private int goodNodes(TreeNode root) {
    good = 0;
    countGoodNodes(root, Integer.MIN_VALUE);
    return good;
  }

  private void countGoodNodes(TreeNode root, int minValue) {
    if (root == null) {
      return;
    }
    if (root.val >= minValue) {
      good++;
    }
    minValue = Math.max(minValue, root.val);
    countGoodNodes(root.left, minValue);
    countGoodNodes(root.right, minValue);
  }
}