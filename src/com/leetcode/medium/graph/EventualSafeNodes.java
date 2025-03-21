package com.leetcode.medium.graph;

import com.leetcode.utils.ListUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    15/06/24,
 * Time:    9:44 pm
 * 802. Find Eventual Safe States
 * https://leetcode.com/problems/find-eventual-safe-states/description/
 */
public class EventualSafeNodes {
  public static void main(String[] args) {
    EventualSafeNodes eventualSafeNodes = new EventualSafeNodes();
    int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
    ListUtils.printList(eventualSafeNodes.eventualSafeNodes(graph));
  }

  private List<Integer> eventualSafeNodes(int[][] graph) {
    List<Integer> answer = new ArrayList<>();
    int n = graph.length;
    List<List<Integer>> adjacencyList = new ArrayList<>();
    boolean[] visited = new boolean[n];
    boolean[] inRecursion = new boolean[n];
    for (int i = 0; i < n; i++) {
      List<Integer> list = new ArrayList<>();
      for (int j = 0; j < graph[i].length; j++) {
        list.add(graph[i][j]);
      }
      adjacencyList.add(list);
    }
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        isCycleDFS(adjacencyList, i, visited, inRecursion);
      }
    }
    for (int i = 0; i < n; i++) {
      if (!inRecursion[i]) {
        answer.add(i);
      }
    }
    return answer;
  }

  private boolean isCycleDFS(List<List<Integer>> adjacencyList, int source, boolean[] visited, boolean[] inRecursion) {
    visited[source] = true;
    inRecursion[source] = true;
    for (int neighbor : adjacencyList.get(source)) {
      if (!visited[neighbor] && isCycleDFS(adjacencyList, neighbor, visited, inRecursion)) {
        return true;
      } else if (inRecursion[neighbor]) {
        return true;
      }
    }
    inRecursion[source] = false;
    return false;
  }
}