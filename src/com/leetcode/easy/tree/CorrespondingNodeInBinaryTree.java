package com.leetcode.easy.tree;

import com.leetcode.utils.TreeNode;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    27/01/23, Time:    1:10 pm
 * https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
 */
public class CorrespondingNodeInBinaryTree {

  public static void main(String[] args) {
    CorrespondingNodeInBinaryTree nodeInBinaryTree = new CorrespondingNodeInBinaryTree();
    TreeNode originalRoot = new TreeNode(7);
    originalRoot.left = new TreeNode(4);
    originalRoot.right = new TreeNode(3);
    originalRoot.right.left = new TreeNode(6);
    originalRoot.right.right = new TreeNode(19);
    TreeNode clonedRoot = new TreeNode(7);
    clonedRoot.left = new TreeNode(4);
    clonedRoot.right = new TreeNode(3);
    clonedRoot.right.left = new TreeNode(6);
    clonedRoot.right.right = new TreeNode(19);
    TreeNode target = nodeInBinaryTree.getTargetCopy(originalRoot, clonedRoot, originalRoot.right);
    System.out.println(target.val);
  }

  private TreeNode getTargetCopy(TreeNode original, TreeNode cloned, TreeNode target) {
    if (original == null || original == target) {
      return cloned;
    }
    TreeNode left = getTargetCopy(original.left, cloned.left, target);
    if (left != null) {
      return left;
    }
    return getTargetCopy(original.right, cloned.right, target);
  }
}