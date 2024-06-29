package com.leetcode.medium.tree;

import com.leetcode.utils.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    29/06/24,
 * Time:    10:18 am
 * 958. Check Completeness of a Binary Tree
 */
public class IsCompleteTree {
  public static void main(String[] args) {
    IsCompleteTree isCompleteTree = new IsCompleteTree();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);
    System.out.println(isCompleteTree.isCompleteTreeBfs(root));
    System.out.println(isCompleteTree.isCompleteTreeDfs(root));
  }

  private boolean isCompleteTreeDfs(TreeNode root) {
    int totalNodes = inorderCount(root);
    int index = 1;
    return dfs(root, totalNodes, index);
  }

  private boolean dfs(TreeNode root, int totalNodes, int index) {
    if (root == null) {
      return true;
    }
    if (index > totalNodes) {
      return false;
    }
    return dfs(root.left, totalNodes, 2 * index) && dfs(root.right, totalNodes, 2 * index + 1);
  }

  private int inorderCount(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1 + inorderCount(root.left) + inorderCount(root.right);
  }

  private boolean isCompleteTreeBfs(TreeNode root) {
    if (root == null) {
      return true;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    boolean isPreviousNull = false;
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (node != null && isPreviousNull) {
        return false;
      }
      if (node == null) {
        isPreviousNull = true;
        continue;
      }
      queue.add(node.left);
      queue.add(node.right);
    }
    return true;
  }
}