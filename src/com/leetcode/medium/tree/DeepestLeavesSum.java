package com.leetcode.medium.tree;

import com.leetcode.utils.TreeNode;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    02/05/24,
 * Time:    12:15 pm
 * 1302. Deepest Leaves Sum
 * https://leetcode.com/problems/deepest-leaves-sum/description/
 */
public class DeepestLeavesSum {
  int sum = 0;
  int maxDepth = 0;

  public static void main(String[] args) {
    DeepestLeavesSum deepestLeavesSum = new DeepestLeavesSum();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.left.left.left = new TreeNode(7);
    root.right.right = new TreeNode(6);
    root.right.right.right = new TreeNode(8);
    System.out.println(deepestLeavesSum.deepestLeavesSum(root));
  }

  private int deepestLeavesSum(TreeNode node) {
    deepestLeavesSum(node, 1);
    return sum;
  }

  private void deepestLeavesSum(TreeNode node, int currentDepth) {
    if (node != null) {
      if (maxDepth < currentDepth) {
        maxDepth = currentDepth;
        sum = 0;
      }
      if (maxDepth == currentDepth) {
        sum += node.val;
      }
      deepestLeavesSum(node.left, currentDepth + 1);
      deepestLeavesSum(node.right, currentDepth + 1);
    }
  }

}