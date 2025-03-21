package com.leetcode.easy.tree;

import com.leetcode.utils.TreeNode;

import java.util.Stack;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    03/08/22, Time:    10:47 AM
 */
public class IterativeInorderTraversal {

  public static void main(String[] args) {
    IterativeInorderTraversal iterativeInorderTraversal = new IterativeInorderTraversal();
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(4);
    root.right = new TreeNode(6);
    root.right.left = new TreeNode(3);
    root.right.right = new TreeNode(7);
    iterativeInorderTraversal.iterativeInorderTraversal(root);
  }

  private void iterativeInorderTraversal(TreeNode root) {
    if (root == null) {
      return;
    }
    Stack<TreeNode> stack = new Stack<>();
    TreeNode node = root;
    while (node != null || !stack.isEmpty()) {
      while (node != null) {
        stack.push(node);
        node = node.left;
      }
      node = stack.pop();
      System.out.println(node.val);
      node = node.right;
    }
  }
}