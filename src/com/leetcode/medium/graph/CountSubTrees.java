package com.leetcode.medium.graph;

import com.leetcode.utils.ArrayUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    14/06/24,
 * Time:    8:18 am
 * 1519. Number of Nodes in the Sub-Tree With the Same Label
 * https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/description/
 */
public class CountSubTrees {
  public static void main(String[] args) {
    CountSubTrees countSubTrees = new CountSubTrees();
    int n = 4;
    int[][] edges = {{0, 1}, {1, 2}, {0, 3}};
    String labels = "bbbb";
    ArrayUtils.printArray(countSubTrees.countSubTrees(n, edges, labels));
  }

  private int[] countSubTrees(int n, int[][] edges, String labels) {
    // 1. Prepare adjacency list
    Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
    for (int i = 0; i < n; i++) {
      adjacencyList.put(i, new ArrayList<>());
    }
    for (int[] edge : edges) {
      adjacencyList.get(edge[0]).add(edge[1]);
      adjacencyList.get(edge[1]).add(edge[0]);
    }
    int[] result = new int[n];
    int[] count = new int[26];
    dfs(adjacencyList, 0, -1, result, labels, count);
    return result;
  }

  private void dfs(Map<Integer, List<Integer>> adjacencyList, int current, int parent, int[] result, String labels, int[] count) {
    char currentLabel = labels.charAt(current);
    int countBeforeVisitingCurrentChildren = count[currentLabel - 'a'];
    // Now I'll explore
    count[currentLabel - 'a']++;
    for (int child : adjacencyList.get(current)) {
      if (child == parent) {
        continue;
      }
      dfs(adjacencyList, child, current, result, labels, count);
    }
    // Now we'll update after variable
    int countAfterVisitingCurrentChildren = count[currentLabel - 'a'];
    result[current] = countAfterVisitingCurrentChildren - countBeforeVisitingCurrentChildren;
  }
}