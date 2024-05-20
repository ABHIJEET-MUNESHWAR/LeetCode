package com.leetcode.medium.tree;

import com.leetcode.utils.TreeNode;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    20/05/24,
 * Time:    12:35 pm
 * 979. Distribute Coins in Binary Tree
 * https://leetcode.com/problems/distribute-coins-in-binary-tree/description/?envType=daily-question&envId=2024-05-18
 */
public class DistributeCoins {
  public static void main(String[] args) {
    DistributeCoins distributeCoins = new DistributeCoins();
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(0);
    root.right = new TreeNode(0);
    System.out.println(distributeCoins.distributeCoins(root));
  }

  int moves = 0;

  private int distributeCoins(TreeNode root) {
    solve(root);
    return moves;
  }

  private int solve(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = solve(root.left);
    int right = solve(root.right);
    moves += Math.abs(left) + Math.abs(right);
    return (left + right + root.val) - 1;
  }
}