package com.leetcode.easy.tree;

import com.leetcode.utils.TreeNode;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    25/11/22, Time:    8:05 AM
 * https://leetcode.com/problems/diameter-of-binary-tree/
 */
public class DiameterOfBinaryTree {

  int maxDiameter = 0;

  public static void main(String[] args) {
    DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    System.out.println(diameterOfBinaryTree.diameterOfBinaryTree(root));
  }

  private int diameterOfBinaryTree(TreeNode root) {
    if (root == null) {
      return 0;
    }
    findDiameter(root);
    return maxDiameter;
  }

  private int findDiameter(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftDiameter = findDiameter(root.left);
    int rightDiameter = findDiameter(root.right);
    maxDiameter = Math.max(maxDiameter, leftDiameter + rightDiameter);
    return Math.max(leftDiameter, rightDiameter) + 1;
  }
}