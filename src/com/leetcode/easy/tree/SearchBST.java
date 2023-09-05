package com.leetcode.easy.tree;

import com.leetcode.utils.TreeNode;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    05/09/23,
 * Time:    9:27 am
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 */
public class SearchBST {
  public static void main(String[] args) {
    SearchBST searchBST = new SearchBST();
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.right = new TreeNode(7);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    int val = 2;
    TreeNode subTreeRoot = searchBST.searchBST(root, val);
    subTreeRoot.inorderTraversal(subTreeRoot);
  }

  private TreeNode searchBST(TreeNode root, int val) {
    if (root == null) {
      return root;
    }
    if (root.val == val) {
      return root;
    }
    if (root.val > val) {
      return searchBST(root.left, val);
    } else {
      return searchBST(root.right, val);
    }
  }
}