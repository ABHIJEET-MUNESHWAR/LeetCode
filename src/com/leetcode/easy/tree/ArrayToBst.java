package com.leetcode.easy.tree;

import com.leetcode.utils.TreeNode;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    10/08/22, Time:    7:36 AM
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/631/
 */
public class ArrayToBst {

  public static void main(String[] args) {
    ArrayToBst arrayToBst = new ArrayToBst();
    int[] nums = new int[]{-10, -3, 0, 5, 9};
    TreeNode root = arrayToBst.sortedArrayToBST(nums);
    root.inorderTraversal(root);
  }

  private TreeNode sortedArrayToBST(int[] nums) {
    int size = nums.length;
    if (size == 0) {
      return null;
    }
    TreeNode root = buildTree(nums, 0, size-1);
    return root;
  }

  private TreeNode buildTree(int[] nums, int low, int high) {
    if (low > high) {
      return null;
    }
    int mid = (low + high) / 2;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = buildTree(nums, low, mid - 1);
    root.right = buildTree(nums, mid + 1, high);
    return root;
  }
}