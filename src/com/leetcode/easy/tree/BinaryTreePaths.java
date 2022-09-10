package com.leetcode.easy.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    10/09/22, Time:    4:31 PM
 * https://leetcode.com/problems/binary-tree-paths/
 */
public class BinaryTreePaths {

  public static void main(String[] args) {
    BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.right = new TreeNode(7);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(9);
    List<String> paths = binaryTreePaths.binaryTreePaths(root);
    System.out.println(paths);
  }

  private List<String> binaryTreePaths(TreeNode root) {
    List<String> lists = new ArrayList<>();
    if (root == null) {
      return lists;
    }
    binaryTreePaths(root, lists, "");
    return lists;
  }

  private void binaryTreePaths(TreeNode root, List<String> lists, String path) {
    if (root.left == null && root.right == null) {
      lists.add(path + root.val);
      return;
    }
    if (root.left != null) {
      binaryTreePaths(root.left, lists, path + root.val + "->");
    }
    if (root.right != null) {
      binaryTreePaths(root.right, lists, path + root.val + "->");
    }
  }
}