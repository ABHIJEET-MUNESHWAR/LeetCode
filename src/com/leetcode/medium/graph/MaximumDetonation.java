package com.leetcode.medium.graph;

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
 * Date:    15/06/24,
 * Time:    4:26 pm
 * 2101. Detonate the Maximum Bombs
 * https://leetcode.com/problems/detonate-the-maximum-bombs/description/
 */
public class MaximumDetonation {
  public static void main(String[] args) {
    MaximumDetonation maximumDetonation = new MaximumDetonation();
    int[][] bombs = {{1, 2, 3}, {2, 3, 1}, {3, 4, 2}, {4, 5, 3}, {5, 6, 4}};
    System.out.println(maximumDetonation.maximumDetonationDfs(bombs));
    System.out.println(maximumDetonation.maximumDetonationBfs(bombs));
  }

  private int maximumDetonationBfs(int[][] bombs) {
    int size = bombs.length;
    Map<Integer, List<Integer>> graph = new HashMap<>();
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (i == j) {
          continue;
        }
        long x1 = bombs[i][0];
        long y1 = bombs[i][1];
        long r1 = bombs[i][2];
        long x2 = bombs[j][0];
        long y2 = bombs[j][1];
        long r2 = bombs[j][2];
        long distance = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
        if ((r1 * r1) >= distance) {
          graph.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
        }
      }
    }
    int result = 0;
    for (int i = 0; i < size; i++) {
      int count = bfs(graph, i);
      result = Math.max(result, count);
    }
    return result;
  }

  private int bfs(Map<Integer, List<Integer>> graph, int currentNode) {
    Set<Integer> visited = new HashSet<>();
    Queue<Integer> queue = new LinkedList<>();
    queue.add(currentNode);
    visited.add(currentNode);
    while (!queue.isEmpty()) {
      int node = queue.poll();
      for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
        if (!visited.contains(neighbor)) {
          queue.add(neighbor);
          visited.add(neighbor);
        }
      }
    }
    return visited.size();
  }

  private int maximumDetonationDfs(int[][] bombs) {
    int size = bombs.length;
    Map<Integer, List<Integer>> graph = new HashMap<>();
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (i == j) {
          continue;
        }
        long x1 = bombs[i][0];
        long y1 = bombs[i][1];
        long r1 = bombs[i][2];
        long x2 = bombs[j][0];
        long y2 = bombs[j][1];
        long r2 = bombs[j][2];
        long distance = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
        if ((r1 * r1) >= distance) {
          graph.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
        }
      }
    }
    int result = 0;
    for (int i = 0; i < size; i++) {
      boolean[] visited = new boolean[size];
      int count = dfs(graph, visited, i);
      result = Math.max(result, count);
    }
    return result;
  }

  private int dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int node) {
    visited[node] = true;
    int count = 1;
    if (!graph.containsKey(node)) {
      return count;
    }
    for (int nextNode : graph.get(node)) {
      if (!visited[nextNode]) {
        count += dfs(graph, visited, nextNode);
      }
    }
    return count;
  }
}