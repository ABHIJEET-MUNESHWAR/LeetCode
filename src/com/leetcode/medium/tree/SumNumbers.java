package com.leetcode.medium.tree;

import com.leetcode.utils.TreeNode;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    15/04/24,
 * Time:    7:02 am
 */
public class SumNumbers {
  int rootToLeafSum = 0, totalSum = 0;

  public static void main(String[] args) {
    SumNumbers sumNumbers = new SumNumbers();
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(9);
    root.right = new TreeNode(0);
    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(1);
    System.out.println(sumNumbers.sumNumbers(root));
  }

  public int sumNumbers(TreeNode root) {
    sumNumbers(root, rootToLeafSum);
    return totalSum;
  }

  public void sumNumbers(TreeNode node, int rootToLeafSum) {
    rootToLeafSum = rootToLeafSum * 10 + node.val;
    if (node.left == null && node.right == null) {
      totalSum += rootToLeafSum;
    }
    if (node.left != null) {
      sumNumbers(node.left, rootToLeafSum);
    }
    if (node.right != null) {
      sumNumbers(node.right, rootToLeafSum);
    }
  }
}