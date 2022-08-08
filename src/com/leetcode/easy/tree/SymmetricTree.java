package com.leetcode.easy.tree;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    05/08/22, Time:    9:50 AM
 */
public class SymmetricTree {

  public static void main(String[] args) {
    SymmetricTree symmetricTree = new SymmetricTree();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.right.left = new TreeNode(4);
    root.right.right = new TreeNode(3);
    System.out.println(symmetricTree.isSymmetricTree(root));
  }

  private boolean isSymmetricTree(TreeNode root) {
    if (root == null) {
      return true;
    }
    return isSymmetricTree(root.left, root.right);
  }

  private boolean isSymmetricTree(TreeNode root1, TreeNode root2) {
    if (root1 == null || root2 == null) {
      return root1 == root2;
    } else if (root1.val != root2.val) {
      return false;
    }
    return isSymmetricTree(root1.left, root2.right) && isSymmetricTree(root1.right, root2.left);
  }
}