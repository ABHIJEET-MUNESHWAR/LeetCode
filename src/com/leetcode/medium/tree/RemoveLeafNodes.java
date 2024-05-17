package com.leetcode.medium.tree;

import com.leetcode.utils.TreeNode;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    17/05/24,
 * Time:    8:02 am
 * 1325. Delete Leaves With a Given Value
 * https://leetcode.com/problems/delete-leaves-with-a-given-value/description/?envType=daily-question&envId=2024-05-17
 */
public class RemoveLeafNodes {
  public static void main(String[] args) {
    RemoveLeafNodes removeLeafNodes = new RemoveLeafNodes();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(2);
    root.right.left = new TreeNode(2);
    root.right.right = new TreeNode(4);
    int target = 2;
    root.inorderTraversal(removeLeafNodes.removeLeafNodes(root, target));
  }

  private TreeNode removeLeafNodes(TreeNode root, int target) {
    if (root == null) {
      return null;
    }
    root.left = removeLeafNodes(root.left, target);
    root.right = removeLeafNodes(root.right, target);
    if (root.left == null && root.right == null && root.val == target) {
      return null;
    }
    return root;
  }
}