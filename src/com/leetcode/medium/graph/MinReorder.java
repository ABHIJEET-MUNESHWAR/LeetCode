package com.leetcode.medium.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    14/06/24,
 * Time:    4:52 pm
 * 1466. Reorder Routes to Make All Paths Lead to the City Zero
 * https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/description/
 */
public class MinReorder {
  public static void main(String[] args) {
    MinReorder minReorder = new MinReorder();
    int n = 6;
    int[][] connections = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
    System.out.println(minReorder.minReorder(n, connections));
  }

  int count = 0;

  class Pair {
    int node;
    int sign;

    public Pair(int node, int sign) {
      this.node = node;
      this.sign = sign;
    }
  }

  private int minReorder(int n, int[][] connections) {
    Map<Integer, List<Pair>> graph = new HashMap<>();
    for (int i = 0; i < n; i++) {
      graph.put(i, new ArrayList<>());
    }
    for (int[] connection : connections) {
      graph.get(connection[0]).add(new Pair(connection[1], 1));
      graph.get(connection[1]).add(new Pair(connection[0], 0));
    }
    dfs(graph, 0, -1);
    return count;
  }

  private void dfs(Map<Integer, List<Pair>> graph, int currentNode, int parent) {
    for (Pair pair : graph.get(currentNode)) {
      if (pair.node != parent) {
        count += pair.sign;
        dfs(graph, pair.node, currentNode);
      }
    }
  }
}