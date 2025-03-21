package com.leetcode.medium.tree;

import com.leetcode.utils.TreeNode;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    30/06/24,
 * Time:    9:36 pm
 * 1339. Maximum Product of Splitted Binary Tree
 * https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/description/
 */
public class MaximumProductOfSplittedBinaryTree {
  public static void main(String[] args) {
    MaximumProductOfSplittedBinaryTree maximumProductOfSplittedBinaryTree = new MaximumProductOfSplittedBinaryTree();
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(3);
    root.right.right = new TreeNode(4);
    root.right.right.left = new TreeNode(5);
    root.right.right.right = new TreeNode(6);
    System.out.println(maximumProductOfSplittedBinaryTree.maxProduct(root));
  }

  int mod = 1000000007;
  long maxProduct = 0;
  long totalSum = 0;

  private int maxProduct(TreeNode root) {
    if (root == null) {
      return 0;
    }
    totalSum = findMaxProduct(root);
    findMaxProduct(root);
    return (int) (maxProduct % mod);
  }

  private int findMaxProduct(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftSum = findMaxProduct(root.left);
    int rightSum = findMaxProduct(root.right);
    int subTreeSum = leftSum + rightSum + root.val;
    long remainingSubTreeSum = totalSum - subTreeSum;
    maxProduct = Math.max(maxProduct, remainingSubTreeSum * subTreeSum);
    return subTreeSum;
  }
}