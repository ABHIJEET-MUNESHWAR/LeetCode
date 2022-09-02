package com.leetcode.easy.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    02/09/22, Time:    9:14 AM
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/
 */
public class LevelAverageOfBinaryTree {

  public static void main(String[] args) {
    LevelAverageOfBinaryTree levelAverageOfBinaryTree = new LevelAverageOfBinaryTree();
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    List<Double> averageDoubleList = levelAverageOfBinaryTree.averageOfLevels(root);
  }

  private List<Double> averageOfLevels(TreeNode root) {
    List<Double> averageDoubleList = new ArrayList<>();
    if (root == null) {
      return averageDoubleList;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      double sum = 0;
      int size = queue.size();
      int nums = 0;
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        if (node != null) {
          nums++;
          sum += node.val;
          queue.add(node.left);
          queue.add(node.right);
        }
      }
      if (nums > 0) {
        averageDoubleList.add(sum / nums);
      }
    }
    return averageDoubleList;
  }
}