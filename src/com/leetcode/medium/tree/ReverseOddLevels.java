package com.leetcode.medium.tree;

import com.leetcode.utils.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    10/06/24,
 * Time:    9:53 pm
 * 2415. Reverse Odd Levels of Binary Tree
 * https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/description/
 */
public class ReverseOddLevels {
  public static void main(String[] args) {
    ReverseOddLevels reverseOddLevels = new ReverseOddLevels();
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(3);
    root.right = new TreeNode(5);
    root.left.left = new TreeNode(8);
    root.left.right = new TreeNode(13);
    root.right.left = new TreeNode(21);
    root.right.right = new TreeNode(34);
    root = reverseOddLevels.reverseOddLevelsBFS(root);
    root.inorderTraversal(root);
    root = reverseOddLevels.reverseOddLevelsDFS(root);
    root.inorderTraversal(root);
  }

  private TreeNode reverseOddLevelsDFS(TreeNode root) {
    traverse(root.left, root.right, 1);
    return root;
  }

  private void traverse(TreeNode node1, TreeNode node2, int level) {
    if (node1 == null && node2 == null) {
      return;
    }
    if (level % 2 == 1) {
      int temp = node1.val;
      node1.val = node2.val;
      node2.val = temp;
    }
    traverse(node1.left, node2.right, level + 1);
    traverse(node1.right, node2.left, level + 1);
  }

  private TreeNode reverseOddLevelsBFS(TreeNode root) {
    if (root == null) {
      return null;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int level = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
      level++;
      if (level % 2 == 1 && !queue.isEmpty()) {
        int[] nums = new int[queue.size()];
        int i = 0;
        for (TreeNode node : queue) {
          nums[i++] = node.val;
        }
        int j = nums.length - 1;
        for (TreeNode node : queue) {
          node.val = nums[j--];
        }
      }
    }
    return root;
  }
}