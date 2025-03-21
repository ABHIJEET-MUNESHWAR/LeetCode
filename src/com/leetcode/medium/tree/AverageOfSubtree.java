package com.leetcode.medium.tree;

import com.leetcode.utils.TreeNode;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    02/05/24,
 * Time:    9:25 am
 * 2265. Count Nodes Equal to Average of Subtree
 * https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/description/
 */
public class AverageOfSubtree {
  public static void main(String[] args) {
    AverageOfSubtree averageOfSubtree = new AverageOfSubtree();
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(8);
    root.right = new TreeNode(5);
    root.left.left = new TreeNode(0);
    root.left.right = new TreeNode(1);
    root.right.right = new TreeNode(6);
    System.out.println(averageOfSubtree.averageOfSubtree(root));
  }

  private int averageOfSubtree(TreeNode root) {
    int[] result = new int[1];
    averageOfSubtree(root, result);
    return result[0];
  }

  private int[] averageOfSubtree(TreeNode node, int[] result) {
    if (node == null) {
      return new int[] {0, 0};
    }
    int[] leftSubTree = averageOfSubtree(node.left, result);
    int[] rightSubTree = averageOfSubtree(node.right, result);
    int currentSum = leftSubTree[0] + rightSubTree[0] + node.val;
    int currentCount = leftSubTree[1] + rightSubTree[1] + 1;
    if (currentSum / currentCount == node.val) {
      result[0]++;
    }
    return new int[] {currentSum, currentCount};
  }
}