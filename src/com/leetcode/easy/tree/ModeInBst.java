package com.leetcode.easy.tree;

import com.leetcode.utils.TreeNode;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    13/10/22, Time:    8:44 AM
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/
 */
public class ModeInBst {

  public static void main(String[] args) {
    ModeInBst modeInBst = new ModeInBst();
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.right = new TreeNode(2);
    int[] modes = modeInBst.findMode(root);
    //
  }

  private int[] findMode(TreeNode root) {
    return null;
  }
}