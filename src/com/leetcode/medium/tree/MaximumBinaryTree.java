package com.leetcode.medium.tree;

import com.leetcode.utils.TreeNode;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    04/05/24,
 * Time:    10:46 am
 * 654. Maximum Binary Tree
 * https://leetcode.com/problems/maximum-binary-tree/description/
 */
public class MaximumBinaryTree {
  public static void main(String[] args) {
    MaximumBinaryTree maximumBinaryTree = new MaximumBinaryTree();
    int[] nums = {3, 2, 1, 6, 0, 5};
    TreeNode root = maximumBinaryTree.constructMaximumBinaryTree(nums);
  }

  private TreeNode constructMaximumBinaryTree(int[] nums) {
    TreeNode root = constructMaximumBinaryTree(nums, 0, nums.length - 1);
    return root;
  }

  private TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
    if (start > end) {
      return null;
    }
    if (start == end) {
      return new TreeNode(nums[start]);
    }
    int index = getMaxIndex(nums, start, end);
    TreeNode node = new TreeNode(nums[index]);
    node.left = constructMaximumBinaryTree(nums, start, index - 1);
    node.right = constructMaximumBinaryTree(nums, index + 1, end);
    return node;
  }

  private int getMaxIndex(int[] nums, int start, int end) {
    int max = Integer.MIN_VALUE;
    int maxIndex = 0;
    for (int i = start; i <= end; i++) {
      if (max < nums[i]) {
        max = nums[i];
        maxIndex = i;
      }
    }
    return maxIndex;
  }
}