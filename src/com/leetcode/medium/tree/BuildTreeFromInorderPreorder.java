package com.leetcode.medium.tree;

import com.leetcode.utils.TreeNode;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    03/06/24,
 * Time:    2:30 pm
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 */
public class BuildTreeFromInorderPreorder {
  public static void main(String[] args) {
    BuildTreeFromInorderPreorder buildTreeFromInorderPreorder = new BuildTreeFromInorderPreorder();
    int[] preorder = {3, 9, 20, 15, 7};
    int[] inorder = {9, 3, 15, 20, 7};
    TreeNode root = buildTreeFromInorderPreorder.buildTree(preorder, inorder);
    root.inorderTraversal(root);
  }

  private int idx;

  private TreeNode solve(int[] preorder, int[] inorder, int start, int end) {

    if (start > end) {
      return null;
    }

    TreeNode root = new TreeNode(preorder[idx]);
    int i = start;

    for (; i <= end; i++) {
      if (inorder[i] == root.val) {
        break;
      }
    }

    idx++;

    root.left = solve(preorder, inorder, start, i - 1);
    root.right = solve(preorder, inorder, i + 1, end);

    return root;
  }

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    int n = preorder.length;
    idx = 0;

    return solve(preorder, inorder, 0, n - 1);

  }
}