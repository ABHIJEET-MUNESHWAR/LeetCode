package com.leetcode.medium.tree;

import com.leetcode.utils.TreeNode;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    01/07/24,
 * Time:    1:16 am
 * 1372. Longest ZigZag Path in a Binary Tree
 * https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/description/
 */
public class LongestZigZag {
  public static void main(String[] args) {
    LongestZigZag lz = new LongestZigZag();
  }

  int maxPath = 0;

  public int longestZigZag(TreeNode root) {
    dfs(root, false, 0);
    dfs(root, true, 0);
    return maxPath;
  }

  private void dfs(TreeNode node, boolean goLeft, int steps) {
    if (node == null) {
      return;
    }
    maxPath = Math.max(maxPath, steps);
    if (goLeft) {
      dfs(node.left, false, steps + 1);
      dfs(node.right, true, 1);
    } else {
      dfs(node.left, false, 1);
      dfs(node.right, true, steps + 1);
    }
  }
}