package com.leetcode.easy.tree;

import com.leetcode.utils.TreeNode;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    16/09/23,
 * Time:    10:41 pm
 * https://leetcode.com/problems/evaluate-boolean-binary-tree/
 */
public class EvaluateTree {
  public static void main(String[] args) {
    EvaluateTree evaluateTree = new EvaluateTree();
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.right = new TreeNode(3);
    root.right.left = new TreeNode(0);
    root.right.right = new TreeNode(1);
    System.out.println(evaluateTree.evaluateTree(root));
  }

  private boolean evaluateTree(TreeNode root) {
    switch (root.val) {
      case 0:
        return false;
      case 1:
        return true;
      case 2:
        return evaluateTree(root.left) || evaluateTree(root.right);
      default:
        return evaluateTree(root.left) && evaluateTree(root.right);
    }
  }
}