package com.leetcode.easy.tree;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    17/09/22, Time:    6:15 PM
 * https://leetcode.com/problems/sum-of-left-leaves/
 */
public class SumOfLeftLeaves {

  public static void main(String[] args) {
    SumOfLeftLeaves sumOfLeftLeaves = new SumOfLeftLeaves();
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    System.out.println(sumOfLeftLeaves.sumOfLeftLeaves(root));
  }

  private int sumOfLeftLeaves(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int sum = 0;
    if (root.left != null) {
      if (root.left.left == null && root.left.right == null) {
        sum += root.left.val;
      } else {
        sum += sumOfLeftLeaves(root.left);
      }
    }
    if (root.right != null) {
      sum += sumOfLeftLeaves(root.right);
    }
    return sum;
  }
}