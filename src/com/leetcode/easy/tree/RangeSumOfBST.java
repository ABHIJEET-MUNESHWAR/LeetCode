package com.leetcode.easy.tree;

import com.leetcode.utils.TreeNode;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    07/12/22, Time:    10:07 pm
 * https://leetcode.com/problems/range-sum-of-bst/
 */
public class RangeSumOfBST {

  public static void main(String[] args) {
    RangeSumOfBST rangeSumOfBST = new RangeSumOfBST();
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(5);
    root.right = new TreeNode(15);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(7);
    root.right.right = new TreeNode(18);
    System.out.println(rangeSumOfBST.rangeSumBST(root, 7, 15));
  }

  private int rangeSumBST(TreeNode root, int low, int high) {
    if (root == null) {
      return 0;
    }
    return (root.val >= low && root.val <= high ? root.val : 0)
        + rangeSumBST(root.left, low, high)
        + rangeSumBST(root.right, low, high);
  }
}