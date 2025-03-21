package com.leetcode.easy.tree;

import com.leetcode.utils.TreeNode;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    08/10/23,
 * Time:    11:07pm
 * https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
 */
public class SumRootToLeaf {
  public static void main(String[] args) {
    SumRootToLeaf sumRootToLeaf = new SumRootToLeaf();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(0);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(0);
    root.left.right = new TreeNode(1);
    root.right.left = new TreeNode(0);
    root.right.right = new TreeNode(1);
    System.out.println(sumRootToLeaf.sumRootToLeaf(root));
  }

  private int sumRootToLeaf(TreeNode root) {
    return sumRootToLeaf(root, 0);
  }

  private int sumRootToLeaf(TreeNode root, int sum) {
    if (root == null) {
      return 0;
    }
    sum = (sum * 2) + root.val;
    if (root.left == null && root.right == null) {
      return sum;
    }
    return sumRootToLeaf(root.left, sum) + sumRootToLeaf(root.right, sum);
  }
}