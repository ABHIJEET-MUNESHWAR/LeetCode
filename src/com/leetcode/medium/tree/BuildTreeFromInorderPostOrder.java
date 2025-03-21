package com.leetcode.medium.tree;

import com.leetcode.utils.TreeNode;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    01/07/24,
 * Time:    1:03 am
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 */
public class BuildTreeFromInorderPostOrder {
  public static void main(String[] args) {
    BuildTreeFromInorderPostOrder buildTreeFromInorderPostOrder = new BuildTreeFromInorderPostOrder();
    int[] inorder = {9, 3, 15, 20, 7};
    int[] postorder = {9, 15, 7, 20, 3};
    TreeNode root = buildTreeFromInorderPostOrder.buildTree(inorder, postorder);
  }

  private TreeNode buildTree(int[] inorder, int[] postorder) {
    int n = inorder.length;
    int inStart = 0;
    int postStart = 0;
    int inEnd = n - 1;
    int postEnd = n - 1;
    return solve(inorder, postorder, inStart, inEnd, postStart, postEnd);
  }

  private TreeNode solve(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
    if (inStart > inEnd) {
      return null;
    }
    TreeNode root = new TreeNode(postorder[postEnd]);
    int i = inStart;
    for (; i <= inEnd; i++) {
      if (inorder[i] == root.val) {
        break;
      }
    }
    int leftSize = i - inStart;
    int rightSize = inEnd - i;
    root.left = solve(inorder, postorder, inStart, i - 1, postStart, postStart + leftSize - 1);
    root.right = solve(inorder, postorder, i + 1, inEnd, postEnd - rightSize, postEnd - 1);
    return root;
  }
}