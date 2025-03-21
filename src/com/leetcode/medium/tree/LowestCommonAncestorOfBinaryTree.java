package com.leetcode.medium.tree;

import com.leetcode.utils.TreeNode;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    28/06/24,
 * Time:    9:27 pm
 * 236. Lowest Common Ancestor of a Binary Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 */
public class LowestCommonAncestorOfBinaryTree {
  public static void main(String[] args) {
    LowestCommonAncestorOfBinaryTree lca = new LowestCommonAncestorOfBinaryTree();
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(5);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(6);
    root.left.right = new TreeNode(2);
    root.right.left = new TreeNode(0);
    root.right.right = new TreeNode(8);
    root.left.right.left = new TreeNode(7);
    root.left.right.right = new TreeNode(4);
    System.out.println(lca.lowestCommonAncestor(root, new TreeNode(5), new TreeNode(1)));
  }

  private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }
    if (root.val == p.val || root.val == q.val) {
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