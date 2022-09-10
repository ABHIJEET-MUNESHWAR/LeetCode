package com.leetcode.easy.tree;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    10/09/22, Time:    12:43 PM
 * https://leetcode.com/problems/invert-binary-tree/
 */
public class InvertBinaryTree {

  public static void main(String[] args) {
    InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.right = new TreeNode(7);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(9);
    //root = invertBinaryTree.invertBinaryTree(root);
    root = invertBinaryTree.invertBinaryTree2(root);
    root.inorderTraversal(root);
  }

  private TreeNode invertBinaryTree(TreeNode root) {
    if (root == null) {
      return root;
    }
    TreeNode temp = root.right;
    root.right = root.left;
    root.left = temp;
    invertBinaryTree(root.left);
    invertBinaryTree(root.right);
    return root;
  }

  private TreeNode invertBinaryTree2(TreeNode root) {
    if (root == null) {
      return root;
    }
    TreeNode left = root.left;
    TreeNode right = root.right;
    root.left = invertBinaryTree2(right);
    root.right = invertBinaryTree2(left);
    return root;
  }
}