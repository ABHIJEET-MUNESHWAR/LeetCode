package com.leetcode.medium.graph;

import com.leetcode.utils.ListUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    29/06/24,
 * Time:    12:54 pm
 * 2192. All Ancestors of a Node in a Directed Acyclic Graph
 * https://leetcode.com/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/description/?envType=daily-question&envId=2024-06-29
 */
public class GetAncestors {
  public static void main(String[] args) {
    GetAncestors getAncestors = new GetAncestors();
    int n = 8;
    int[][] edges = {{0, 3}, {0, 4}, {1, 3}, {2, 4}, {2, 7}, {3, 5}, {3, 6}, {3, 7}, {4, 6}};
    ListUtils.printLists(getAncestors.getAncestorsDfs(n, edges));
    ListUtils.printLists(getAncestors.getAncestorsReverseNodes(n, edges));
    ListUtils.printLists(getAncestors.getAncestorsTopologicalSort(n, edges));
  }

  private List<List<Integer>> getAncestorsTopologicalSort(int n, int[][] edges) {
    List<TreeSet<Integer>> ancestorList = new ArrayList();
    List<List<Integer>> list = new ArrayList();

    Queue<Integer> queue = new LinkedList();

    int inDegree[] = new int[n];
    ArrayList<Integer>[] connections = new ArrayList[n];

    for (int i = 0; i < n; i++) {
      connections[i] = new ArrayList<Integer>();
      ancestorList.add(new TreeSet<Integer>());
    }

    for (int edge[] : edges) {
      connections[edge[0]].add(edge[1]);
      inDegree[edge[1]]++;
    }

    for (int i = 0; i < n; i++) {
      if (inDegree[i] == 0) {
        queue.add(i);
      }
    }


    while (!queue.isEmpty()) {

      int currNode = queue.poll();
      for (int node : connections[currNode]) {
        ancestorList.get(node).addAll(new TreeSet(ancestorList.get(currNode)));
        ancestorList.get(node).add(currNode);

        inDegree[node]--;
        if (inDegree[node] == 0) {
          queue.add(node);
        }
      }
    }
    for (TreeSet<Integer> set : ancestorList) {
      list.add(new ArrayList<Integer>(set));
    }

    return list;
  }

  private List<List<Integer>> getAncestorsReverseNodes(int n, int[][] edges) {
    List<List<Integer>> result = new ArrayList<>();
    Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();
    for (int i = 0; i < n; i++) {
      adjacencyMap.put(i, new ArrayList<>());
    }
    for (int[] edge : edges) {
      adjacencyMap.get(edge[1]).add(edge[0]);
    }
    for (int u = 0; u < n; u++) {
      List<Integer> ancestors = new ArrayList<>();
      boolean[] visited = new boolean[n];
      dfsReverse(adjacencyMap, visited, u);
      for (int i = 0; i < n; i++) {
        if (i == u) {
          continue;
        }
        if (visited[i]) {
          ancestors.add(i);
        }
      }
      result.add(ancestors);
    }
    return result;
  }

  private void dfsReverse(Map<Integer, List<Integer>> adjacencyMap, boolean[] visited, int u) {
    visited[u] = true;
    for (int v : adjacencyMap.get(u)) {
      if (!visited[v]) {
        dfsReverse(adjacencyMap, visited, v);
      }
    }
  }

  private List<List<Integer>> getAncestorsDfs(int n, int[][] edges) {
    List<List<Integer>> result = new ArrayList<>();
    Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();
    for (int i = 0; i < n; i++) {
      adjacencyMap.put(i, new ArrayList<>());
      result.add(new ArrayList<>());
    }
    for (int[] edge : edges) {
      int u = edge[0];
      int v = edge[1];
      adjacencyMap.get(u).add(v);
    }
    for (int i = 0; i < n; i++) {
      int ancestor = i;
      dfs(adjacencyMap, result, ancestor, i);
    }
    return result;
  }

  private void dfs(Map<Integer, List<Integer>> adjacencyMap, List<List<Integer>> result, int ancestor, int currentNode) {
    for (int neighbor : adjacencyMap.get(currentNode)) {
      if (result.get(neighbor).isEmpty() || !result.get(neighbor).contains(ancestor)) {
        result.get(neighbor).add(ancestor);
        dfs(adjacencyMap, result, ancestor, neighbor);
      }
    }
  }
}