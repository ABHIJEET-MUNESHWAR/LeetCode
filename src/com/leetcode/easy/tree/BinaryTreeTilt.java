package com.leetcode.easy.tree;

import com.leetcode.utils.TreeNode;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    26/11/22, Time:    7:28 pm
 * https://leetcode.com/problems/binary-tree-tilt/
 */
public class BinaryTreeTilt {

  int diff = 0;

  public static void main(String[] args) {
    BinaryTreeTilt binaryTreeTilt = new BinaryTreeTilt();
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.right = new TreeNode(9);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(5);
    root.right.right = new TreeNode(7);
    System.out.println(binaryTreeTilt.findTilt(root));
    System.out.println(binaryTreeTilt.findTilt2(root));
  }

  private int findTilt2(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int currentValue = 0;
    currentValue = Math.abs(sumSubTree(root.left) - sumSubTree(root.right));
    return currentValue + findTilt2(root.left) + findTilt2(root.right);
  }

  private int sumSubTree(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return root.val + sumSubTree(root.left) + sumSubTree(root.right);
  }

  private int findTilt(TreeNode root) {
    helper(root);
    return diff;
  }

  private int helper(TreeNode root) {
    if (root == null) {
      return 0;
    }
    if (root.left == null && root.right == null) {
      return root.val;
    }
    int leftSum = helper(root.left);
    int rightSum = helper(root.right);
    diff += Math.abs(leftSum - rightSum);
    return leftSum + rightSum + root.val;
  }
}