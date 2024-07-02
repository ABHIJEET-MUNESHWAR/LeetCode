package com.leetcode.medium.tree;

import com.leetcode.utils.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    02/07/24,
 * Time:    1:52 pm
 * 2385. Amount of Time for Binary Tree to Be Infected
 * https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/description/
 */
public class AmountOfTime {
  public static void main(String[] args) {
    AmountOfTime amountOfTime = new AmountOfTime();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(5);
    root.right = new TreeNode(3);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(6);
    root.left.right = new TreeNode(4);
    root.left.right.left = new TreeNode(9);
    root.left.right.right = new TreeNode(2);
    int start = 3;
    System.out.println(amountOfTime.amountOfTime(root, start));
  }

  private int amountOfTime(TreeNode root, int start) {
    int maxDistance = 0;
    Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();
    buildAdjacencyMap(root, -1, adjacencyMap);
    Set<Integer> visited = new HashSet<>();
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    visited.add(start);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int curr = queue.poll();
        for (int neighbour : adjacencyMap.getOrDefault(curr, new ArrayList<>())) {
          if (!visited.contains(neighbour)) {
            queue.add(neighbour);
            visited.add(neighbour);
          }
        }
      }
      maxDistance++;
    }
    return maxDistance - 1;
  }

  private void buildAdjacencyMap(TreeNode root, int parent, Map<Integer, List<Integer>> adjacencyMap) {
    if (root == null) {
      return;
    }
    if (parent != -1) {
      adjacencyMap.computeIfAbsent(root.val, k -> new ArrayList<>()).add(parent);
    }
    if (root.left != null) {
      adjacencyMap.computeIfAbsent(root.val, k -> new ArrayList<>()).add(root.left.val);
    }
    if (root.right != null) {
      adjacencyMap.computeIfAbsent(root.val, k -> new ArrayList<>()).add(root.right.val);
    }
    buildAdjacencyMap(root.left, root.val, adjacencyMap);
    buildAdjacencyMap(root.right, root.val, adjacencyMap);
  }
}