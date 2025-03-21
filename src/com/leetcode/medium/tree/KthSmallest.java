package com.leetcode.medium.tree;

import com.leetcode.utils.TreeNode;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    02/06/24,
 * Time:    11:46 pm
 * 230. Kth Smallest Element in a BST
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 */
public class KthSmallest {
  public static void main(String[] args) {
    KthSmallest kthSmallest = new KthSmallest();
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(1);
    root.right = new TreeNode(4);
    root.left.right = new TreeNode(2);
    int k = 3;
    System.out.println(kthSmallest.kthSmallest(root, k));
  }

  int answer = 0;
  int count = 0;

  private int kthSmallest(TreeNode root, int k) {
    traverseTree(root, k);
    return answer;
  }

  private void traverseTree(TreeNode root, int k) {
    if (root == null) {
      return;
    }
    traverseTree(root.left, k);
    count++;
    if (k == count) {
      answer = root.val;
      return;
    }
    traverseTree(root.right, k);
  }
}