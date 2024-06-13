package com.leetcode.medium.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    13/06/24,
 * Time:    8:18 pm
 * 1443. Minimum Time to Collect All Apples in a Tree
 * https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/description/
 */
public class MinimumTimeToCollectAllApplesInTree {
  public static void main(String[] args) {
    MinimumTimeToCollectAllApplesInTree solution = new MinimumTimeToCollectAllApplesInTree();
    int n = 7;
    int[][] edges = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
    List<Boolean> hasApple = new ArrayList<>(Arrays.asList(false, false, true, false, true, true, false));
    System.out.println(solution.minTime(n, edges, hasApple));
  }

  private int minTime(int n, int[][] edges, List<Boolean> hasApple) {
    Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
    for (int i = 0; i < n; i++) {
      adjacencyList.put(i, new ArrayList<>());
    }
    for (int[] edge : edges) {
      adjacencyList.get(edge[0]).add(edge[1]);
      adjacencyList.get(edge[1]).add(edge[0]);
    }
    return dfs(adjacencyList, 0, -1, hasApple);
  }

  private int dfs(Map<Integer, List<Integer>> adjacencyList, int current, int parent, List<Boolean> hasApple) {
    int time = 0;
    for (int child : adjacencyList.get(current)) {
      if (child == parent) {
        continue;
      }
      int timeFromChild = dfs(adjacencyList, child, current, hasApple);
      if (timeFromChild > 0 || hasApple.get(child)) {
        time += timeFromChild + 2;
      }
    }
    return time;
  }
}