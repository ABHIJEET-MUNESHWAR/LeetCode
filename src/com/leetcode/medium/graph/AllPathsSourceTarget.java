package com.leetcode.medium.graph;

import com.leetcode.utils.ListUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    08/05/24,
 * Time:    9:49 am
 * 797. All Paths From Source to Target
 * https://leetcode.com/problems/all-paths-from-source-to-target/description/
 */
public class AllPathsSourceTarget {
  public static void main(String[] args) {
    AllPathsSourceTarget allPathsSourceTarget = new AllPathsSourceTarget();
    int[][] graph = {{1, 2}, {3}, {3}, {}};
    ListUtils.printLists(allPathsSourceTarget.allPathsSourceTarget(graph));
  }

  private List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> current = new ArrayList<>();
    current.add(0);
    dfs(0, graph.length-1, graph, current, result);
    return result;
  }

  private void dfs(int source, int destination, int[][] graph, List<Integer> current, List<List<Integer>> result) {
    if (source == destination) {
      result.add(new ArrayList<>(current));
      return;
    }
    for (int v: graph[source]) {
      current.add(v);
      dfs(v, destination, graph, current, result);
      current.remove(current.size() - 1);
    }
  }
}