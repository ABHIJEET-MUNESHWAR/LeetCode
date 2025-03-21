package com.leetcode.medium.tree;

import com.leetcode.utils.TreeNode;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    02/07/24,
 * Time:    8:13 am
 * 1161. Maximum Level Sum of a Binary Tree
 * https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/description/
 */
public class MaxLevelSum {
  public static void main(String[] args) {
    MaxLevelSum maxLevelSum = new MaxLevelSum();
    /*TreeNode root = new TreeNode(1);
    root.left = new TreeNode(7);
    root.right = new TreeNode(0);
    root.left.left = new TreeNode(7);
    root.left.right = new TreeNode(-8);*/
    /*TreeNode root = new TreeNode(989);
    root.right = new TreeNode(10250);
    root.right.left = new TreeNode(98693);
    root.right.right = new TreeNode(-89388);
    root.right.right.right = new TreeNode(-32127);*/
    TreeNode root = new TreeNode(-100);
    root.left = new TreeNode(-200);
    root.right = new TreeNode(-300);
    root.left.left = new TreeNode(-20);
    root.left.right = new TreeNode(-5);
    root.right.left = new TreeNode(-10);
    System.out.println(maxLevelSum.maxLevelSumBfs(root));
    System.out.println(maxLevelSum.maxLevelSumDfs(root));
  }

  Map<Integer, Integer> map = new HashMap<>();

  private int maxLevelSumDfs(TreeNode root) {
    dfs(root, 1);
    int maxSum = Integer.MIN_VALUE;
    int maxSumLevel = 0;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      int key = entry.getKey();
      int value = entry.getValue();
      if (maxSum < value) {
        maxSum = value;
        maxSumLevel = key;
      }
    }
    return maxSumLevel;
  }

  private void dfs(TreeNode root, int currentLevel) {
    if (root == null) {
      return;
    }
    dfs(root.left, currentLevel + 1);
    map.put(currentLevel, map.getOrDefault(currentLevel, 0) + root.val);
    dfs(root.right, currentLevel + 1);
  }

  private int maxLevelSumBfs(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int maxSum = Integer.MIN_VALUE;
    int currentSum = 0;
    int maxSumLevel = 0;
    int currentLevel = 1;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        currentSum += node.val;
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
      if (maxSum < currentSum) {
        maxSum = currentSum;
        maxSumLevel = currentLevel;
      }
      currentLevel++;
      currentSum = 0;
    }
    return maxSumLevel;
  }
}