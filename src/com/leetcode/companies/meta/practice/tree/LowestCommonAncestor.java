package com.leetcode.companies.meta.practice.tree;

import com.leetcode.utils.TreeNode;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    02/06/24,
 * Time:    11:56 pm
 * 235. Lowest Common Ancestor of a Binary Search Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 */
public class LowestCommonAncestor {
  public static void main(String[] args) {
    LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
    TreeNode root = new TreeNode(6);
    root.left = new TreeNode(2);
    root.right = new TreeNode(8);
    root.right.left = new TreeNode(7);
    root.right.right = new TreeNode(9);
    root.left.left = new TreeNode(0);
    root.left.right = new TreeNode(4);
    root.left.right.left = new TreeNode(3);
    root.left.right.right = new TreeNode(5);
    int p = 2, q = 8;
    System.out.println(lowestCommonAncestor.lowestCommonAncestor(root, p, q).val);
    System.out.println(lowestCommonAncestor.lowestCommonAncestorUsingBST(root, p, q).val);
  }

  private TreeNode lowestCommonAncestorUsingBST(TreeNode root, int p, int q) {
    if (root == null) {
      return null;
    }
    if (root.val > p && root.val > q) {
      return lowestCommonAncestorUsingBST(root.left, p, q);
    }
    if (root.val < p && root.val < q) {
      return lowestCommonAncestorUsingBST(root.right, p, q);
    }
    return root;
  }

  private TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
    if (root == null) {
      return root;
    }
    if (root.val == p || root.val == q) {
      return root;
    }
    TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
    TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
    if (leftNode != null && rightNode != null) {
      return root;
    }
    if (leftNode != null) {
      return leftNode;
    }
    return rightNode;
  }
}