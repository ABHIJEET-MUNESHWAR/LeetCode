package com.leetcode.easy.tree;

import com.leetcode.utils.TreeNode;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    10/09/22, Time:    11:55 AM
 * https://leetcode.com/problems/construct-string-from-binary-tree/
 */
public class TreeToString {

  public static void main(String[] args) {
    TreeToString treeToString = new TreeToString();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    System.out.println(treeToString.treeToString(root));
  }

  private String treeToString(TreeNode root) {
    if (root == null) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    treeToString(root, sb);
    return sb.toString();
  }

  private void treeToString(TreeNode root, StringBuilder sb) {
    sb.append(root.val);
    if (root.left == null && root.right == null) {
      return;
    }
    if (root.left != null) {
      sb.append("(");
      treeToString(root.left, sb);
      sb.append(")");
    }
    if (root.right != null) {
      if (root.left == null) {
        sb.append("()");
      }
      sb.append("(");
      treeToString(root.right, sb);
      sb.append(")");
    }
  }
}