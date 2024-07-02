package com.leetcode.medium.tree;

import com.leetcode.utils.ListUtils;
import com.leetcode.utils.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    02/07/24,
 * Time:    10:32 am
 * 515. Find Largest Value in Each Tree Row
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
 */
public class LargestValues {
  public static void main(String[] args) {
    LargestValues largestValues = new LargestValues();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(3);
    root.right = new TreeNode(2);
    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(3);
    root.right.right = new TreeNode(9);
    ListUtils.printList(largestValues.largestValuesBfs(root));
    ListUtils.printList(largestValues.largestValuesDfs(root));
  }

  List<Integer> result = new ArrayList<>();

  private List<Integer> largestValuesDfs(TreeNode root) {
    if (root == null) {
      return result;
    }
    dfs(root, 0);
    return result;
  }

  private void dfs(TreeNode root, int currentDepth) {
    if (root == null) {
      return;
    }
    if (currentDepth == result.size()) {
      result.add(root.val);
    } else {
      result.set(currentDepth, Math.max(result.get(currentDepth), root.val));
    }
    dfs(root.left, currentDepth + 1);
    dfs(root.right, currentDepth + 1);
  }

  private List<Integer> largestValuesBfs(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      int currentMax = Integer.MIN_VALUE;
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        if (currentMax < node.val) {
          currentMax = node.val;
        }
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
      result.add(currentMax);
    }
    return result;
  }
}