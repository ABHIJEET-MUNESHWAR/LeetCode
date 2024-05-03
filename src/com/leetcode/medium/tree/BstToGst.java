package com.leetcode.medium.tree;

import com.leetcode.utils.TreeNode;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    03/05/24,
 * Time:    7:59 am
 * 1038. Binary Search Tree to Greater Sum Tree
 * https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 */
public class BstToGst {
  int sum = 0;

  public static void main(String[] args) {
    BstToGst bstToGst = new BstToGst();
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(1);
    root.right = new TreeNode(6);
    root.left.left = new TreeNode(0);
    root.left.right = new TreeNode(2);
    root.left.right.right = new TreeNode(3);
    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(7);
    root.right.right.right = new TreeNode(8);
    System.out.println(bstToGst.bstToGst(root));
  }

  private TreeNode bstToGst(TreeNode root) {
    bstToGstSum(root);
    return root;
  }

  private void bstToGstSum(TreeNode root) {
    if (root == null) {
      return;
    }
    bstToGstSum(root.right);
    sum += root.val;
    root.val = sum;
    bstToGstSum(root.left);
  }
}