package com.leetcode.easy.tree;

import com.leetcode.utils.TreeNode;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    03/09/23,
 * Time:    3:36 pm
 * https://leetcode.com/problems/merge-two-binary-trees/
 */
public class MergeTrees {
  public static void main(String[] args) {
    MergeTrees mergeTrees = new MergeTrees();
    TreeNode root1 = new TreeNode(1);
    root1.left = new TreeNode(2);
    root1.left.left = new TreeNode(3);
    TreeNode root2 = new TreeNode(1);
    root2.right = new TreeNode(2);
    root2.right.right = new TreeNode(3);
    TreeNode root3 = mergeTrees.mergeTrees1(root1, root2);
    root3.inorderTraversal(root3);
    TreeNode root4 = mergeTrees.mergeTrees(root1, root2);
    System.out.println();
    root4.inorderTraversal(root4);
  }

  private TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) {
      return null;
    }
    if (root1 == null) {
      return root2;
    }
    if (root2 == null) {
      return root1;
    }
    TreeNode root3 = new TreeNode(root1.val + root2.val);
    root3.left = mergeTrees(root1.left, root2.left);
    root3.right = mergeTrees(root1.right, root2.right);
    return root3;
  }

  private TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
    if (root1 == null) {
      return root2;
    }
    if (root2 == null) {
      return root1;
    }
    return mergeTrees1(root1, root2, null);
  }

  private TreeNode mergeTrees1(TreeNode root1, TreeNode root2, TreeNode root3) {
    if (root1 == null && root2 == null) {
      return root3;
    }
    if (root1 == null) {
      root3 = new TreeNode(root2.val);
      root3.left = mergeTrees1(null, root2.left, root3.left);
      root3.right = mergeTrees1(null, root2.right, root3.right);
    } else if (root2 == null) {
      root3 = new TreeNode(root1.val);
      root3.left = mergeTrees1(root1.left, null, root3.left);
      root3.right = mergeTrees1(root1.right, null, root3.right);
    } else {
      root3 = new TreeNode(root1.val + root2.val);
      root3.left = mergeTrees1(root1.left, root2.left, root3.left);
      root3.right = mergeTrees1(root1.right, root2.right, root3.right);
    }
    return root3;
  }
}