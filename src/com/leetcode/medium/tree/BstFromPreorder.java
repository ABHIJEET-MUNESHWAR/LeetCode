package com.leetcode.medium.tree;

import com.leetcode.utils.TreeNode;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    08/05/24,
 * Time:    8:48 pm
 * 1008. Construct Binary Search Tree from Preorder Traversal
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/
 */
public class BstFromPreorder {
  int i = 0;

  public static void main(String[] args) {
    BstFromPreorder bstFromPreorder = new BstFromPreorder();
    int[] preorder = {8, 5, 1, 7, 10, 12};
    TreeNode root = bstFromPreorder.bstFromPreorder(preorder);
    root.inorderTraversal(root);
  }

  private TreeNode bstFromPreorder(int[] preorder) {
    return bstFromPreorder(preorder, Integer.MAX_VALUE);
  }

  private TreeNode bstFromPreorder(int[] preorder, int maxValue) {
    if (i == preorder.length || preorder[i] > maxValue) {
      return null;
    }
    TreeNode root = new TreeNode(preorder[i++]);
    root.left = bstFromPreorder(preorder, root.val);
    root.right = bstFromPreorder(preorder, maxValue);
    return root;
  }
}